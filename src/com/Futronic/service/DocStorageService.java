package Futronic.service;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

import Futronic.model.Doc;
import Futronic.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocStorageService {

  @Autowired
  private DocRepository docRepository;


  public void sending(Doc doc){
	  try{
		  Socket clientSocket = new Socket("147.175.106.8",55555);

		  OutputStream outputStream = clientSocket.getOutputStream();
		  ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		  objectOutputStream.writeObject(doc);
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }

	public Doc saveFile(MultipartFile file, String request) {
	  try {
		  Doc doc = new Doc(file.getOriginalFilename(),request,file.getContentType(),file.getBytes(),file.getSize());

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
	public Set<String> getTypes() {
		Set<String> types = new HashSet<>();
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
