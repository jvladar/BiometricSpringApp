package Futronic.controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import Futronic.model.Doc;
import Futronic.PersonOuterClass;
import Futronic.service.ServiceResponse;
import com.Futronic.ScanApiHelper.Scanner;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import Futronic.service.DocStorageService;

import javax.imageio.ImageIO;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;

	@GetMapping("/")
	public String get(Model model) {
		List<Doc> docs = docStorageService.getFiles();
		model.addAttribute("docs", docs);
		model.addAttribute("ids", docStorageService.getIds());
		model.addAttribute("types", docStorageService.getTypes());
		return "basic";
	}

	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("radiobut") String request, Model model) throws IOException, InterruptedException {
		String meno = null;
		for (MultipartFile file: files) {
			try{
				Socket clientSocket = new Socket("147.175.106.8",55555);
				byte [] data = file.getBytes();
				ByteArrayInputStream bis = new ByteArrayInputStream(data);
				BufferedImage image = ImageIO.read(bis);

				ByteString bs = ByteString.copyFrom(((DataBufferByte)image.getRaster().getDataBuffer()).getData());
				PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setFirstname("Jan").setLastname("Vladar")
						.setAge(22).setImage(bs).setImgHeight(image.getHeight()).setImgWidth(image.getWidth()).build();
				person.writeTo(clientSocket.getOutputStream());
				// ZAPIS <- -------------------------------------------------- -> ODPOVED
				InputStream is = clientSocket.getInputStream();
				DataInputStream ds = new DataInputStream(is);
				int buffSize = ds.readInt();
				byte[] buffer = new byte[buffSize];
				ds.readFully(buffer);

				System.out.println(buffer.length);
				PersonOuterClass.Person person1 = PersonOuterClass.Person.parseFrom(buffer);
				BufferedImage image1 = new BufferedImage(person1.getImgWidth(), person1.getImgHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
				System.arraycopy(person1.getImage().toByteArray(), 0, array, 0, array.length);

				System.out.println(person1.getAge());
				/*meno = file.getOriginalFilename();
				Path currentPath = Paths.get("");
				Path absolutePath = currentPath.toAbsolutePath();
				Path path = Paths.get(absolutePath + "/src/main/resources/static/img/"+meno);
				ImageIO.write(image1, "bmp", new File(String.valueOf(path)));*/
				docStorageService.saveFile(file,request);

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
		return "docNew";
	}
	@PostMapping("/scan")
	public String scan(Model model) throws IOException {
		Scanner scanner = new Scanner();
		if(scanner.OpenDevice()){
			Socket clientSocket = new Socket("147.175.106.8",55555);

			byte[] data = new byte[320*480];
			scanner.GetImage2(7,data);

			//ByteArrayInputStream bis = new ByteArrayInputStream(data);
			//BufferedImage image = ImageIO.read(bis);
			ByteString bs = ByteString.copyFrom(data);
			PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder().setFirstname("Jan").setLastname("Vladar")
					.setAge(22).setImage(bs).setImgHeight(480).setImgWidth(320).build();
			person.writeTo(clientSocket.getOutputStream());

			InputStream is = clientSocket.getInputStream();
			DataInputStream ds = new DataInputStream(is);
			int buffSize = ds.readInt();
			byte[] buffer = new byte[buffSize];
			ds.readFully(buffer);

			System.out.println(buffer.length);
			PersonOuterClass.Person person1 = PersonOuterClass.Person.parseFrom(buffer);
			BufferedImage image1 = new BufferedImage(person1.getImgWidth(), person1.getImgHeight(), BufferedImage.TYPE_BYTE_GRAY);
			byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
			System.arraycopy(person1.getImage().toByteArray(), 0, array, 0, array.length);

			System.out.println(person1.getAge());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image1, "bmp", baos);
			byte[] bytes = baos.toByteArray();

			byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			String s = new String(encodeBase64, "UTF-8");
			model.addAttribute("fotka",s);
			scanner.CloseDevice();
		}
		return "basicNew";
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
		Doc doc = docStorageService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + doc.getDocName() + "\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	@GetMapping("/getFiles")
	public ResponseEntity<Object> getAllBooks() {
		ServiceResponse<List<Doc>> response = new ServiceResponse<>("success", docStorageService.getFiles());
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@PostMapping("/searchData")
	public ResponseEntity<Object> getBook(@RequestBody Doc doc) {
		ServiceResponse<List<Doc>> response = new ServiceResponse<>("success", docStorageService.getSearch(doc));
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
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