package Futronic.controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.List;

import Futronic.Openfinger;
import Futronic.model.Fingerprint;
import Futronic.model.Level2;
import Futronic.model.User;
import Futronic.openFinger.*;
import Futronic.service.CommunicationService;
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

	@Autowired
	private CommunicationService communicationService;

	@GetMapping("/")
	public String get(Model model) {
		List<User> users = usersStorageService.getFiles();
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
					ByteString bs = ByteString.readFrom(bis);
					ExtractionRequestOuterClass.Fingerprint person = ExtractionRequestOuterClass.Fingerprint.newBuilder()
							.setHeight(300).setWidth(300).setResolution(500).setColorValue(0).setData(bs).build();
					ExtractionRequestOuterClass.ExtractionRequest request = ExtractionRequestOuterClass.ExtractionRequest.newBuilder().setFingerprint(person).build();
					System.out.println(request.getFingerprint().toByteArray().length); //velkost
					request.writeTo(clientSocket.getOutputStream());
		// RESPONSE
					WrapperOuterClass.Wrapper response = communicationService.parser(clientSocket);

					usersStorageService.saveUser(name0, username0, data,response.getExtractResponse().getLevel2Vector().getLevel2VectorList());
				}
				//verification
				else if(login0.length()>0 ) {
					List<Fingerprint> userFingerprints = usersStorageService.findUserFingers(login0);
				}
				//identification
				else{
					List<Fingerprint> fingerprints = usersStorageService.getFingers();
				}
				ByteString bs = ByteString.copyFrom(((DataBufferByte)image.getRaster().getDataBuffer()).getData());
				Openfinger.Fingerprint person = Openfinger.Fingerprint.newBuilder().setHeight(300).setWidth(300)
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
	public String scan(Model model, String inputGroupSelect02, String name, String username, String login ) throws IOException, InterruptedException {
		Scanner scanner = new Scanner();
		scanner.SetOptions(1, scanner.FTR_OPTIONS_INVERT_IMAGE);
		if(scanner.OpenDevice()){
			Socket clientSocket = new Socket("147.175.106.8",55555);
			byte[] data = new byte[320*480];
			scanner.GetImage2(3,data);

			/*BufferedImage image1 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
			byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
			System.arraycopy(data, 0, array, 0, array.length);
			ImageIO.write(image1 , "bmp", new File("final_file.bmp") );
			System.out.println("Converted Successfully!");*/

			//preprocessing
			if(inputGroupSelect02.equals("preprocessing")){
				ByteString bs = ByteString.copyFrom(data);
				FingerprintOuterClass.Fingerprint person = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320)
						.setResolution(500).setColorValue(0).setData(bs).build();
				PreprocessingRequestOuterClass.PreprocessingRequest request = PreprocessingRequestOuterClass.PreprocessingRequest.newBuilder().setFingerprint(person).build();
				WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.PREPROCESSING_REQUEST).setPreprocRequest(request).build();

				message.writeTo(clientSocket.getOutputStream());
				//REQUEST<-------------->RESPONSE
				WrapperOuterClass.Wrapper response = communicationService.parser(clientSocket);
				BufferedImage image1 = new BufferedImage(response.getPreprocResponse().getResults(0).getWidth(), response.getPreprocResponse().getResults(0).getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(0).getData().toByteArray(), 0, array, 0, array.length);


				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image1, "bmp", baos);
				byte[] bytes = baos.toByteArray();

				byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
				String s = new String(encodeBase64, "UTF-8");
				model.addAttribute("fotka",s);

			}
			//registration
			else if(username.length()>0) {
				ByteString bs = ByteString.copyFrom(data); // obrazok zo scanneru
				ExtractionRequestOuterClass.Fingerprint fprint = ExtractionRequestOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320).setResolution(500).setColorValue(0).setData(bs).build();

				ExtractionRequestOuterClass.ExtractionRequest request = ExtractionRequestOuterClass.ExtractionRequest.newBuilder().setFingerprint(fprint).build();

				WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.EXTRACTION_REQUEST).setExtractRequest(request).build();

				message.writeTo(clientSocket.getOutputStream());

				//    REQUEST <--------------> RESPONSE
				WrapperOuterClass.Wrapper response = communicationService.parser(clientSocket);

				usersStorageService.saveUser(name, username, data,response.getExtractResponse().getLevel2Vector().getLevel2VectorList());
			}
			//verification
			else if(login.length()>0 ) {
				List<Fingerprint> userFingerprints = usersStorageService.findUserFingers(login);
				ByteString bs = ByteString.copyFrom(data);
				FingerprintOuterClass.Fingerprint fprint = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320).setResolution(500).setColorValue(0).setData(bs).build();
				VerificationRequestOuterClass.VerificationRequest.Builder request = VerificationRequestOuterClass.VerificationRequest.newBuilder();
				request.setFingerprint(fprint);

				for (Fingerprint f : userFingerprints){
					List<Level2> level2 = f.getLevels();
					Level2VectorOuterClass.Level2Vector.Builder lvl2 = Level2VectorOuterClass.Level2Vector.newBuilder();
					for(Level2 lvl : level2){
						Level2OuterClass.Level2 level = Level2OuterClass.Level2.newBuilder().setX(lvl.getX()).setY(lvl.getY()).setAngle(lvl.getAngle()).setType(lvl.getType()).setQuality(lvl.getQuality()).setImgWidth(lvl.getImg_width()).setImgHeight(lvl.getImg_height()).build();
						lvl2.addLevel2Vector(level);
					}
					request.addLevel2Vectors(lvl2);
				}
				WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.VERIFICATION_REQUEST).setVerifyRequest(request).build();
				message.writeTo(clientSocket.getOutputStream());
				//    REQUEST <--------------> RESPONSE
				WrapperOuterClass.Wrapper response = communicationService.parser(clientSocket);

				System.out.println(response.getVerifyResponse().getResult());
				System.out.println(response.getVerifyResponse().getScore());
			}
			//identification
			else {
				List<Fingerprint> fingerprints = usersStorageService.getFingers();
				ByteString bs = ByteString.copyFrom(data);
				FingerprintOuterClass.Fingerprint fprint = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320).setResolution(500).setColorValue(0).setData(bs).build();
				IdentificationRequestOuterClass.IdentificationRequest.Builder request = IdentificationRequestOuterClass.IdentificationRequest.newBuilder();
				request.setFingerprint(fprint);

				for (Fingerprint f : fingerprints){
					List<Level2> level2 = f.getLevels();
					IdentificationRequestOuterClass.Level2VectorOfFingerprint.Builder vector = IdentificationRequestOuterClass.Level2VectorOfFingerprint.newBuilder();
					Level2VectorOuterClass.Level2Vector.Builder lvl2 = Level2VectorOuterClass.Level2Vector.newBuilder();

					for(Level2 lvl : level2){
						Level2OuterClass.Level2 level = Level2OuterClass.Level2.newBuilder().setX(lvl.getX()).setY(lvl.getY()).setAngle(lvl.getAngle()).setType(lvl.getType()).setQuality(lvl.getQuality()).setImgWidth(lvl.getImg_width()).setImgHeight(lvl.getImg_height()).build();
						lvl2.addLevel2Vector(level);
					}
					vector.setLevel2Vector(lvl2).setFingerprintId(f.getId());
					request.addVectors(vector);
				}
				WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.IDENTIFICATION_REQUEST).setIdentifyRequest(request).build();

				message.writeTo(clientSocket.getOutputStream());

				//    REQUEST <--------------> RESPONSE

				WrapperOuterClass.Wrapper response = communicationService.parser(clientSocket);
				System.out.println(response.getIdentifyResponse().getSuccess());
				System.out.println(response.getIdentifyResponse().getFingerprintId());
			}
			scanner.CloseDevice();
		}
		return "basic";
	}

}