package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Doc;
import com.example.demo.repository.DocRepository;

@Service
public class DocStorageService {
  @Autowired
  private DocRepository docRepository;
  
  public Doc saveFile(MultipartFile file) {
	  try {
		  Doc doc = new Doc(file.getOriginalFilename(),file.getContentType(),file.getBytes(),file.getSize());
		  return docRepository.save(doc);
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  return null;
  }
  public Optional<Doc> getFile(Integer fileId) {
	  return docRepository.findById(fileId);
  }
  public List<Doc> getFiles(){
	  return docRepository.findAll();
  }
  public List<Integer> getIds() {
	  List<Integer> ids = new ArrayList<>();
	  List<Doc> files = docRepository.findAll();
	  ids.add(null);
	  for (Doc i : files) {
		ids.add(i.getId());
	  }
	  return ids;
  }
	public List<String> getTypes() {
		List<String> types = new ArrayList<>();
		List<Doc> files = docRepository.findAll();
		types.add("");
		for (Doc i : files) {
			types.add(i.getDocType());
		}
		return types;
	}

	public List<Doc> getSearch(Doc doc) {
		List<Doc> types = new ArrayList<>();
		List<Doc> files = docRepository.findAll();
		for (Doc i : files) {
			//if (doc.getId()<1 || (i.getId()==doc.getId())){
			if(doc.getId()==null || i.getId()==doc.getId()){
				if (doc.getDocType().equals("") || i.getDocType().equals(doc.getDocType())) {
					if(i.getDocName().equals(doc.getDocName()) || doc.getDocName().equals("")) {
						if(doc.getSize()==null || i.getSize().equals(doc.getSize())) {
							if(doc.getId()==null && doc.getDocType().equals("") && doc.getDocName().equals("") && doc.getSize()==null){}
							else types.add(i);
						}
					}
				}
			}
		}
		return types;
	}

}
