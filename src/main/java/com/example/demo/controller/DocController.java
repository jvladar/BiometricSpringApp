package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.demo.service.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Doc;
import com.example.demo.service.DocStorageService;

@Controller
public class DocController {

	@Autowired 
	private DocStorageService docStorageService;
	
	@GetMapping("/")
	public String get(Model model) {
		List<Doc> docs = docStorageService.getFiles();
		model.addAttribute("docs", docs);
		model.addAttribute("ids", docStorageService.getIds());
		model.addAttribute("types", docStorageService.getTypes());
		return "doc";
	}
	
	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			docStorageService.saveFile(file);
		}
		return "redirect:/";
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
