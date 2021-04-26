package Futronic.controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.List;

import Futronic.Openfinger;
import Futronic.model.Fingers;
import Futronic.model.Users;
import com.Futronic.ScanApiHelper.Scanner;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import Futronic.service.UsersStorageService;

import javax.imageio.ImageIO;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class DocController {

	@Autowired 
	private UsersStorageService usersStorageService;

	@GetMapping("/")
	public String get(Model model) {
		List<Users> users = usersStorageService.getFiles();
		model.addAttribute("docs", users);
		model.addAttribute("ids", usersStorageService.getIds());
		//model.addAttribute("types", docStorageService.getTypes());
		return "basic";
	}

	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, String inputGroupSelect01, String name0, String username0, String login0,  Model model) throws IOException, InterruptedException {
		String meno = null;
		for (MultipartFile file: files) {
			try{
				Socket clientSocket = new Socket("147.175.106.8",55555);
				byte [] data = file.getBytes();
				ByteArrayInputStream bis = new ByteArrayInputStream(data);
				BufferedImage image = ImageIO.read(bis);
				//registration
				if(username0.length()>0) {
					usersStorageService.saveUser(name0, username0,data);
					//usersStorageService.saveFinger(data,username0);
				}
				//verification
				else if(login0.length()>0 ) {
					List<Fingers> userFingers = usersStorageService.findUserFingers(login0);
				}
				//identification
				else{
					List<Fingers> fingers = usersStorageService.getFingers();
				}
				ByteString bs = ByteString.copyFrom(((DataBufferByte)image.getRaster().getDataBuffer()).getData());
				Openfinger.Fingerprint person = Openfinger.Fingerprint.newBuilder().setHeight(480).setWidth(320)
						.setResolution(500).setColor(Openfinger.Fingerprint.Colorspace.RGB).setData(bs).build();
				Openfinger.PreprocessingRequest requestt = Openfinger.PreprocessingRequest.newBuilder().setFingerprint(person).build();
				System.out.println(requestt.getFingerprint().toByteArray().length);
				requestt.writeTo(clientSocket.getOutputStream());
				// ZAPIS <- -------------------------------------------------- -> ODPOVED
				InputStream is = clientSocket.getInputStream();
				DataInputStream ds = new DataInputStream(is);
				int buffSize = ds.readInt();
				byte[] buffer = new byte[buffSize];
				ds.readFully(buffer);

				Openfinger.Fingerprint person1 = Openfinger.Fingerprint.parseFrom(buffer);
				BufferedImage image1 = new BufferedImage(person1.getWidth(), person1.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
				System.arraycopy(person1.getData().toByteArray(), 0, array, 0, array.length);

				System.out.println(person1.getWidth());

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image1, "bmp", baos);
				byte[] bytes = baos.toByteArray();

				byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
				String s = new String(encodeBase64, "UTF-8");
				model.addAttribute("fotka",s);

			} catch(Exception e){
				e.toString();
			}
		}
		return "basic";
	}

	@PostMapping("/scan")
	public String scan(Model model, String inputGroupSelect02, String name, String username, String login ) throws IOException {
		Scanner scanner = new Scanner();
		if(scanner.OpenDevice()){
			Socket clientSocket = new Socket("147.175.106.8",55555);
			byte[] data = new byte[320*480];
			scanner.GetImage2(7,data);
			//registration
			if(username.length()>0) {
				usersStorageService.saveUser(name, username,data);
				//usersStorageService.saveFinger(data,username);
			}
			//verification
			else if(login.length()>0 ) {
				List<Fingers> userFingers = usersStorageService.findUserFingers(login);
			}
			//identification
			else{
				List<Fingers> fingers = usersStorageService.getFingers();
			}

			ByteString bs = ByteString.copyFrom(data); // NNN
			Openfinger.Fingerprint person = Openfinger.Fingerprint.newBuilder().setHeight(480).setWidth(320)
					.setResolution(500).setColorValue(0).setData(bs).build();
			Openfinger.PreprocessingRequest request = Openfinger.PreprocessingRequest.newBuilder().setFingerprint(person).build();
			System.out.println(request.getFingerprint().toByteArray().length); //velkost

			request.writeTo(clientSocket.getOutputStream());
			//REQUEST<-------------->RESPONSE
			InputStream is = clientSocket.getInputStream();
			DataInputStream ds = new DataInputStream(is);
			int buffSize = ds.readInt();

			System.out.println(buffSize); //vypis do konzoly
			byte[] buffer = new byte[153613];
			ds.readFully(buffer);

			Openfinger.PreprocessingResponse.Builder response = Openfinger.PreprocessingResponse.newBuilder();
			response.addResults(Openfinger.Fingerprint.parseFrom(buffer));
			//Openfinger.Fingerprint person1 = Openfinger.Fingerprint.parseFrom(buffer);
			BufferedImage image1 = new BufferedImage(response.getResults(0).getWidth(), response.getResults(0).getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
			System.arraycopy(response.getResults(0).getData().toByteArray(), 0, array, 0, array.length);

			System.out.println(response.getResults(0).getWidth());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image1, "bmp", baos);
			byte[] bytes = baos.toByteArray();

			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			String s = new String(encodeBase64, "UTF-8");
			model.addAttribute("fotka",s);
			scanner.CloseDevice();
		}
		return "basic";
	}

/*	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
		Users doc = docStorageService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getDocName() + "\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	@GetMapping("/getFiles")
	public ResponseEntity<Object> getAllBooks() {
		ServiceResponse<List<Users>> response = new ServiceResponse<>("success", docStorageService.getFiles());
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@PostMapping("/searchData")
	public ResponseEntity<Object> getBook(@RequestBody Users doc) {
		ServiceResponse<List<Users>> response = new ServiceResponse<>("success", docStorageService.getSearch(doc));
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}*/
}

// Toto cele pribudlo
			/*byte [] data = file.getBytes();
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
			BufferedImage bImage2 = ImageIO.read(bis);
			meno = file.getOriginalFilename();
			Path currentPath = Paths.get("");
			Path absolutePath = currentPath.toAbsolutePath();
			Path path = Paths.get(absolutePath + "/src/main/resources/static/img/"+meno);
			File outputfile = new File(String.valueOf(path));
			ImageIO.write(bImage2, "bmp", outputfile);
			docStorageService.saveFile(file,request);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bImage2, "bmp", baos);
			byte[] bytes = baos.toByteArray();

			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			String s = new String(encodeBase64, "UTF-8");
			model.addAttribute("fotka",s);*/