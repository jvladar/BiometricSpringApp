package Futronic.controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.net.Socket;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import Futronic.Openfinger;
import Futronic.model.Fingerprint;
import Futronic.model.Level2;
import Futronic.model.User;
import Futronic.openFinger.*;
import Futronic.service.ConvertingService;
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
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class DocController {

	@Autowired
	private UsersStorageService usersStorageService;

	@Autowired
	private ConvertingService convertingService;

	@GetMapping("/")
	public String get(Model model) {
		List<User> users = usersStorageService.getFiles();
		model.addAttribute("docs", users);
		model.addAttribute("ids", usersStorageService.getIds());
		return "basic";
	}
	@GetMapping("/scan")
	public String getScan(Model model) {
		List<User> users = usersStorageService.getFiles();
		model.addAttribute("docs", users);
		model.addAttribute("ids", usersStorageService.getIds());
		return "basic";
	}
	@GetMapping("/uploadFiles")
	public String getUpload(Model model) {
		List<User> users = usersStorageService.getFiles();
		model.addAttribute("docs", users);
		model.addAttribute("ids", usersStorageService.getIds());
		return "basic";
	}

	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, String inputGroupSelect01, String name0, String username0, String login0, double sigma0, double lambda0, int block0,  Model model) throws IOException, InterruptedException {
		for (MultipartFile file: files) {
			try {
				Socket clientSocket = new Socket("147.175.106.8", 55555);
				System.out.println(file.getContentType());
				BufferedImage image = ImageIO.read(file.getInputStream());
				if(inputGroupSelect01.equals("showing") || inputGroupSelect01.equals("selected")){

					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					BufferedImage img = convertingService.invertimage(image);

					ImageIO.write(img, "png", baos);
					byte[] bytes = baos.toByteArray();

					byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
					String s = new String(encodeBase64, "UTF-8");
					model.addAttribute("fotka",s);
					System.out.println("Converted Successfully!");
				}
				//Preprocessing
				else if(inputGroupSelect01.equals("preprocessing")){
					BufferedImage img = convertingService.invertimage(image);
					BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
					byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();
					ByteString bat = ByteString.copyFrom(ara);
					FingerprintOuterClass.Fingerprint person = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(image.getHeight()).setWidth(image.getWidth())
							.setResolution(500).setColorValue(0).setData(bat).build();
					PreprocessingRequestOuterClass.PreprocessingParams params = PreprocessingRequestOuterClass.PreprocessingParams.newBuilder().setBlockSize(block0).setGaborLambda(lambda0).setGaborSigma(sigma0).build();
					PreprocessingRequestOuterClass.PreprocessingRequest request = PreprocessingRequestOuterClass.PreprocessingRequest.newBuilder().setFingerprint(person).setParams(params).build();
					WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.PREPROCESSING_REQUEST).setPreprocRequest(request).build();

					message.writeTo(clientSocket.getOutputStream());
					//REQUEST<-------------->RESPONSE
					WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);
					BufferedImage image0 = new BufferedImage(response.getPreprocResponse().getResults(0).getFingerprint().getWidth(), response.getPreprocResponse().getResults(0).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					byte[] array = ((DataBufferByte) image0.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(0).getFingerprint().getData().toByteArray(), 0, array, 0, array.length);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(image0, "bmp", baos);
					byte[] bytes = baos.toByteArray();

					byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
					String s = new String(encodeBase64, "UTF-8");
					model.addAttribute("fotka5",s);

					BufferedImage image1 = new BufferedImage(response.getPreprocResponse().getResults(1).getFingerprint().getWidth(), response.getPreprocResponse().getResults(1).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					byte[] array1 = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(1).getFingerprint().getData().toByteArray(), 0, array1, 0, array1.length);
					ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
					ImageIO.write(image1, "bmp", baos1);
					byte[] bytes1 = baos1.toByteArray();

					byte[] encodeBase641 = Base64.getEncoder().encode(bytes1);
					String s1 = new String(encodeBase641, "UTF-8");
					model.addAttribute("fotka1",s1);

					BufferedImage image2 = new BufferedImage(response.getPreprocResponse().getResults(2).getFingerprint().getWidth(), response.getPreprocResponse().getResults(2).getFingerprint().getHeight(), BufferedImage.TYPE_3BYTE_BGR);
					byte[] array2 = ((DataBufferByte) image2.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(2).getFingerprint().getData().toByteArray(), 0, array2, 0, array2.length);
					BufferedImage imge = convertingService.invertimage(image2);
					ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
					ImageIO.write(imge, "png", baos2);
					byte[] bytes2 = baos2.toByteArray();

					byte[] encodeBase642 = Base64.getEncoder().encode(bytes2);
					String s2 = new String(encodeBase642, "UTF-8");
					model.addAttribute("fotka2",s2);

					BufferedImage image3 = new BufferedImage(response.getPreprocResponse().getResults(3).getFingerprint().getWidth(), response.getPreprocResponse().getResults(3).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					byte[] array3 = ((DataBufferByte) image3.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(3).getFingerprint().getData().toByteArray(), 0, array3, 0, array3.length);
					ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
					ImageIO.write(image3, "bmp", baos3);
					byte[] bytes3 = baos3.toByteArray();

					byte[] encodeBase643 = Base64.getEncoder().encode(bytes3);
					String s3 = new String(encodeBase643, "UTF-8");
					model.addAttribute("fotka3",s3);

					BufferedImage image4 = new BufferedImage(response.getPreprocResponse().getResults(4).getFingerprint().getWidth(), response.getPreprocResponse().getResults(4).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					byte[] array4 = ((DataBufferByte) image4.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(4).getFingerprint().getData().toByteArray(), 0, array4, 0, array4.length);
					ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
					ImageIO.write(image4, "bmp", baos4);
					byte[] bytes4 = baos4.toByteArray();

					byte[] encodeBase644 = Base64.getEncoder().encode(bytes4);
					String s4 = new String(encodeBase644, "UTF-8");
					model.addAttribute("fotka4",s4);

					BufferedImage image5 = new BufferedImage(response.getPreprocResponse().getResults(5).getFingerprint().getWidth(), response.getPreprocResponse().getResults(5).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					byte[] array5 = ((DataBufferByte) image5.getRaster().getDataBuffer()).getData();
					System.arraycopy(response.getPreprocResponse().getResults(5).getFingerprint().getData().toByteArray(), 0, array5, 0, array5.length);
					ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
					ImageIO.write(image5, "bmp", baos5);
					byte[] bytes5 = baos5.toByteArray();

					byte[] encodeBase645 = Base64.getEncoder().encode(bytes5);
					String s5 = new String(encodeBase645, "UTF-8");
					model.addAttribute("fotka",s5);

				}
				//registration
				else if(inputGroupSelect01.equals("registration")) {
					String s;
					if(name0.length()==0 || username0.length()==0){
						s = "Zadaj správne meno a používateľské meno !";
					}
					else {
						BufferedImage img = convertingService.invertimage(image);
						BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
						imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
						byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();
						ByteString bat = ByteString.copyFrom(ara);

						ExtractionRequestOuterClass.Fingerprint fprint = ExtractionRequestOuterClass.Fingerprint.newBuilder().setHeight(image.getHeight()).setWidth(image.getWidth()).setResolution(500).setColorValue(0).setData(bat).build();

						ExtractionRequestOuterClass.ExtractionRequest request = ExtractionRequestOuterClass.ExtractionRequest.newBuilder().setFingerprint(fprint).build();

						WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.EXTRACTION_REQUEST).setExtractRequest(request).build();

						message.writeTo(clientSocket.getOutputStream());

						//    REQUEST <--------------> RESPONSE
						WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);

						usersStorageService.saveUser(name0, username0, ara, response.getExtractResponse().getLevel2Vector().getLevel2VectorList());
						s = "Registrácia užívateľa a pridanie odtlačku prebehlo úspešne !";
					}
					model.addAttribute("vysledok",s);
				}
				//verification
				else if(inputGroupSelect01.equals("verification") ) {
					List<Fingerprint> userFingerprints = usersStorageService.findUserFingers(login0);
					String s;
					if(login0.length()==0){
						s = "Zadaj správne prihlasovacie meno !";
					}
					else {
						if (userFingerprints != null) {
							BufferedImage img = convertingService.invertimage(image);
							BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
							imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
							byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();
							ByteString bat = ByteString.copyFrom(ara);
							FingerprintOuterClass.Fingerprint fprint = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(image.getHeight()).setWidth(image.getWidth()).setResolution(500).setColorValue(0).setData(bat).build();
							VerificationRequestOuterClass.VerificationRequest.Builder request = VerificationRequestOuterClass.VerificationRequest.newBuilder();
							request.setFingerprint(fprint);

							for (Fingerprint f : userFingerprints) {
								List<Level2> level2 = f.getLevels();
								Level2VectorOuterClass.Level2Vector.Builder lvl2 = Level2VectorOuterClass.Level2Vector.newBuilder();
								for (Level2 lvl : level2) {
									Level2OuterClass.Level2 level = Level2OuterClass.Level2.newBuilder().setX(lvl.getX()).setY(lvl.getY()).setAngle(lvl.getAngle()).setType(lvl.getType()).setQuality(lvl.getQuality()).setImgWidth(lvl.getImg_width()).setImgHeight(lvl.getImg_height()).build();
									lvl2.addLevel2Vector(level);
								}
								request.addLevel2Vectors(lvl2);
							}
							WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.VERIFICATION_REQUEST).setVerifyRequest(request).build();
							message.writeTo(clientSocket.getOutputStream());
							//    REQUEST <--------------> RESPONSE
							WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);
							System.out.println(response.getVerifyResponse().getScore());
							if (response.getVerifyResponse().getResult()) {
								s = "Verifikácia používateľa " + login0 + " prebehla úspešne !";
							} else {
								s = "Verifikácia používateľa " + login0 + " sa nepodarila, skúste ešte raz !";
							}
						} else {
							s = "Meno používateľa je zlé";
						}
					}
					model.addAttribute("vysledok",s);
				}
				//identification
				else {
					List<Fingerprint> fingerprints = usersStorageService.getFingers();
					BufferedImage img = convertingService.invertimage(image);
					BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
					byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();
					ByteString bat = ByteString.copyFrom(ara);
					FingerprintOuterClass.Fingerprint fprint = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(image.getHeight()).setWidth(image.getWidth()).setResolution(500).setColorValue(0).setData(bat).build();
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
					WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);
					User user = usersStorageService.findUserByFingerprintId(response.getIdentifyResponse().getFingerprintId());
					String s;
					String pouzivatel = null;
					System.out.println(response.getIdentifyResponse().getSuccess());
					System.out.println(response.getIdentifyResponse().getFingerprintId());
					if(response.getIdentifyResponse().getSuccess()){
						s="Identifikácia prebehla úspešne, nájdený používateľ : ";
						pouzivatel = user.getName();
					}
					else{
						s="Identifikácia sa nepodarila, nebola nájdena zhoda, skúste ešte raz !";
					}
					model.addAttribute("vysledok",s);
					model.addAttribute("uzivatel",pouzivatel);
				}
			}catch(Exception e){
				e.toString();
			}
		}
		return "basic";
	}

	@PostMapping("/scan")
	public String scan(Model model, String inputGroupSelect02, String name, String username, String login, double sigma, double lambda, int block ) throws IOException, InterruptedException {
		Scanner scanner = new Scanner();
		scanner.SetOptions(1, scanner.FTR_OPTIONS_INVERT_IMAGE);
		if(scanner.OpenDevice()){
			Socket clientSocket = new Socket("147.175.106.8",55555);
			byte[] data = new byte[320*480];
			scanner.GetImage2(4,data);

			if(inputGroupSelect02.equals("showing") || inputGroupSelect02.equals("selected")){

				BufferedImage image1 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
				byte[] array = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
				System.arraycopy(data, 0, array, 0, array.length);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				BufferedImage img = convertingService.invertimage(image1);

				ImageIO.write(img , "bmp", baos);
				byte[] bytes = baos.toByteArray();

				byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
				String s = new String(encodeBase64, "UTF-8");
				model.addAttribute("fotka",s);
				System.out.println("Converted Successfully!");
			}
			//preprocessing
			else if(inputGroupSelect02.equals("preprocessing")){

				BufferedImage image11 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
				byte[] ar = ((DataBufferByte) image11.getRaster().getDataBuffer()).getData();
				System.arraycopy(data, 0, ar, 0, ar.length);

				BufferedImage img = convertingService.invertimage(image11);

				BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
				byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();

				ByteString bs = ByteString.copyFrom(ara);


				FingerprintOuterClass.Fingerprint person = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320)
						.setResolution(500).setColorValue(0).setData(bs).build();
				PreprocessingRequestOuterClass.PreprocessingParams params = PreprocessingRequestOuterClass.PreprocessingParams.newBuilder().setBlockSize(block).setGaborLambda(lambda).setGaborSigma(sigma).build();
				PreprocessingRequestOuterClass.PreprocessingRequest request = PreprocessingRequestOuterClass.PreprocessingRequest.newBuilder().setFingerprint(person).setParams(params).build();
				WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.PREPROCESSING_REQUEST).setPreprocRequest(request).build();
				message.writeTo(clientSocket.getOutputStream());
				//REQUEST<-------------->RESPONSE

				WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);

				BufferedImage image = new BufferedImage(response.getPreprocResponse().getResults(0).getFingerprint().getWidth(), response.getPreprocResponse().getResults(0).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(0).getFingerprint().getData().toByteArray(), 0, array, 0, array.length);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "bmp", baos);
				byte[] bytes = baos.toByteArray();

				byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
				String s = new String(encodeBase64, "UTF-8");
				model.addAttribute("fotka5",s);

				BufferedImage image1 = new BufferedImage(response.getPreprocResponse().getResults(1).getFingerprint().getWidth(), response.getPreprocResponse().getResults(1).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array1 = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(1).getFingerprint().getData().toByteArray(), 0, array1, 0, array1.length);
				ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
				ImageIO.write(image1, "bmp", baos1);
				byte[] bytes1 = baos1.toByteArray();

				byte[] encodeBase641 = Base64.getEncoder().encode(bytes1);
				String s1 = new String(encodeBase641, "UTF-8");
				model.addAttribute("fotka1",s1);

				BufferedImage image2 = new BufferedImage(response.getPreprocResponse().getResults(2).getFingerprint().getWidth(), response.getPreprocResponse().getResults(2).getFingerprint().getHeight(),BufferedImage.TYPE_3BYTE_BGR);
				byte[] array2 = ((DataBufferByte) image2.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(2).getFingerprint().getData().toByteArray(), 0, array2, 0, array2.length);
				BufferedImage imge = convertingService.invertimage(image2);
				ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
				ImageIO.write(imge, "png", baos2);
				byte[] bytes2 = baos2.toByteArray();

				byte[] encodeBase642 = Base64.getEncoder().encode(bytes2);
				String s2 = new String(encodeBase642, "UTF-8");
				model.addAttribute("fotka2",s2);

				BufferedImage image3 = new BufferedImage(response.getPreprocResponse().getResults(3).getFingerprint().getWidth(), response.getPreprocResponse().getResults(3).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array3 = ((DataBufferByte) image3.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(3).getFingerprint().getData().toByteArray(), 0, array3, 0, array3.length);
				ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
				ImageIO.write(image3, "bmp", baos3);
				byte[] bytes3 = baos3.toByteArray();

				byte[] encodeBase643 = Base64.getEncoder().encode(bytes3);
				String s3 = new String(encodeBase643, "UTF-8");
				model.addAttribute("fotka3",s3);

				BufferedImage image4 = new BufferedImage(response.getPreprocResponse().getResults(4).getFingerprint().getWidth(), response.getPreprocResponse().getResults(4).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array4 = ((DataBufferByte) image4.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(4).getFingerprint().getData().toByteArray(), 0, array4, 0, array4.length);
				ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
				ImageIO.write(image4, "bmp", baos4);
				byte[] bytes4 = baos4.toByteArray();

				byte[] encodeBase644 = Base64.getEncoder().encode(bytes4);
				String s4 = new String(encodeBase644, "UTF-8");
				model.addAttribute("fotka4",s4);

				BufferedImage image5 = new BufferedImage(response.getPreprocResponse().getResults(5).getFingerprint().getWidth(), response.getPreprocResponse().getResults(5).getFingerprint().getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				byte[] array5 = ((DataBufferByte) image5.getRaster().getDataBuffer()).getData();
				System.arraycopy(response.getPreprocResponse().getResults(5).getFingerprint().getData().toByteArray(), 0, array5, 0, array5.length);
				ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
				ImageIO.write(image5, "bmp", baos5);
				byte[] bytes5 = baos5.toByteArray();

				byte[] encodeBase645 = Base64.getEncoder().encode(bytes5);
				String s5 = new String(encodeBase645, "UTF-8");
				model.addAttribute("fotka",s5);

			}

			//registration
			else if(inputGroupSelect02.equals("registration")) {
				String s;
				if(name.length()==0 || username.length()==0) {
					s = "Zadaj správne meno a prihlasovacie meno !";
				}
				else {
					BufferedImage image11 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
					byte[] array1 = ((DataBufferByte) image11.getRaster().getDataBuffer()).getData();
					System.arraycopy(data, 0, array1, 0, array1.length);

					BufferedImage img = convertingService.invertimage(image11);

					BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
					imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
					byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();

					ByteString bs = ByteString.copyFrom(ara);

					ExtractionRequestOuterClass.Fingerprint fprint = ExtractionRequestOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320).setResolution(500).setColorValue(0).setData(bs).build();

					ExtractionRequestOuterClass.ExtractionRequest request = ExtractionRequestOuterClass.ExtractionRequest.newBuilder().setFingerprint(fprint).build();

					WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.EXTRACTION_REQUEST).setExtractRequest(request).build();

					message.writeTo(clientSocket.getOutputStream());

					//    REQUEST <--------------> RESPONSE
					WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);

					usersStorageService.saveUser(name, username, data, response.getExtractResponse().getLevel2Vector().getLevel2VectorList());
					s = "Registrácia užívateľa a pridanie odtlačku prebehlo úspešne !";
				}
				model.addAttribute("vysledok",s);
			}
			//verification
			else if(inputGroupSelect02.equals("verification")) {
				List<Fingerprint> userFingerprints = usersStorageService.findUserFingers(login);
				String s;
				if(login.length()==0){
					s = "Zadaj správne prihlasovacie meno !";
				}
				else {
					if (userFingerprints != null) {
						BufferedImage image11 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
						byte[] array1 = ((DataBufferByte) image11.getRaster().getDataBuffer()).getData();
						System.arraycopy(data, 0, array1, 0, array1.length);

						BufferedImage img = convertingService.invertimage(image11);

						BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
						imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
						byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();

						ByteString bs = ByteString.copyFrom(ara);
						FingerprintOuterClass.Fingerprint fprint = FingerprintOuterClass.Fingerprint.newBuilder().setHeight(480).setWidth(320).setResolution(500).setColorValue(0).setData(bs).build();
						VerificationRequestOuterClass.VerificationRequest.Builder request = VerificationRequestOuterClass.VerificationRequest.newBuilder();
						request.setFingerprint(fprint);
						for (Fingerprint f : userFingerprints) {
							List<Level2> level2 = f.getLevels();
							Level2VectorOuterClass.Level2Vector.Builder lvl2 = Level2VectorOuterClass.Level2Vector.newBuilder();
							for (Level2 lvl : level2) {
								Level2OuterClass.Level2 level = Level2OuterClass.Level2.newBuilder().setX(lvl.getX()).setY(lvl.getY()).setAngle(lvl.getAngle()).setType(lvl.getType()).setQuality(lvl.getQuality()).setImgWidth(lvl.getImg_width()).setImgHeight(lvl.getImg_height()).build();
								lvl2.addLevel2Vector(level);
							}
							request.addLevel2Vectors(lvl2);
						}
						WrapperOuterClass.Wrapper message = WrapperOuterClass.Wrapper.newBuilder().setHeader(WrapperOuterClass.Wrapper.Header.VERIFICATION_REQUEST).setVerifyRequest(request).build();
						message.writeTo(clientSocket.getOutputStream());
						//    REQUEST <--------------> RESPONSE

						WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);
						if (response.getVerifyResponse().getResult()) {
							s = "Verifikácia používateľa " + login + " prebehla úspešne !";
						} else {
							s = "Verifikácia používateľa " + login + " sa nepodarila, skúste ešte raz !";
						}
					} else {
						s = "Meno používateľa je zlé";
					}
				}
				model.addAttribute("vysledok",s);
			}
			//identification
			else {
				List<Fingerprint> fingerprints = usersStorageService.getFingers();
				BufferedImage image11 = new BufferedImage(320, 480, BufferedImage.TYPE_BYTE_GRAY);
				byte[] array1 = ((DataBufferByte) image11.getRaster().getDataBuffer()).getData();
				System.arraycopy(data, 0, array1, 0, array1.length);

				BufferedImage img = convertingService.invertimage(image11);

				BufferedImage imag = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
				imag.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
				byte[] ara = ((DataBufferByte) imag.getRaster().getDataBuffer()).getData();

				ByteString bs = ByteString.copyFrom(ara);
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

				WrapperOuterClass.Wrapper response = convertingService.parser(clientSocket);
				User user = usersStorageService.findUserByFingerprintId(response.getIdentifyResponse().getFingerprintId());
				String s;
				String pouzivatel = null;
				System.out.println(response.getIdentifyResponse().getSuccess());
				System.out.println(response.getIdentifyResponse().getFingerprintId());
				if(response.getIdentifyResponse().getSuccess()){
					s="Identifikácia prebehla úspešne, nájdený používateľ : ";
					pouzivatel = user.getName();
				}
				else{
					s="Identifikácia sa nepodarila, nebola nájdena zhoda, skúste ešte raz !";
				}
				model.addAttribute("vysledok",s);
				model.addAttribute("uzivatel",pouzivatel);
			}
			scanner.CloseDevice();
		}
		return "basic";
	}

}