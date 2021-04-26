package Futronic.service;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

import Futronic.model.Fingers;
import Futronic.model.Users;
import Futronic.repository.FingersRepository;
import Futronic.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersStorageService {

  	@Autowired
  	private UsersRepository usersRepository;

	@Autowired
	private FingersRepository fingersRepository;


  public void sending(Users users){
	  try{
		  Socket clientSocket = new Socket("147.175.106.8",55555);

		  OutputStream outputStream = clientSocket.getOutputStream();
		  ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		  objectOutputStream.writeObject(users);
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }

	public Users saveUser(String name, String username, byte[] data) {
  		if(findUserByUsername(username)!=null){
  			Users user1 = findUserByUsername(username);
			Fingers finger1 = new Fingers(data);
  			user1.getFingers().add(finger1);
  			return this.usersRepository.save(user1);
		}
  		try{
			Fingers finger = new Fingers(data);
			Users user = new Users(name, username);
			user.getFingers().add(finger);
			return this.usersRepository.save(user);
	  	}
	  	catch(Exception e) {
		  e.printStackTrace();
	  	}
	  return null;
  	}

	public Users saveFinger(byte[] data, String username) {
		try{
			Fingers finger = new Fingers(data);
			List<Users> users = getUsers();
			for(Users user : users){
				if(user.getUsername().equals(username)){
					user.getFingers().add(finger);
					return usersRepository.save(user);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Users findUserByUsername(String username) {
		try{
			List<Users> users = getUsers();
			for(Users user : users){
				if(user.getUsername().equals(username)){
					return user;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<Fingers> findUserFingers(String username){
		List<Users> users = getUsers();
		for(Users user : users){
			if(user.getUsername().equals(username)){
				return user.getFingers();
			}
		}
		return null;
	}

	public List<Fingers> getFingers(){
		return fingersRepository.findAll();
	}

  public Optional<Users> getUser(Integer id) {
	  return usersRepository.findById(id);
  }

  public List<Users> getUsers() {
		return usersRepository.findAll();
	}


  public List<Users> getFiles(){
	  return usersRepository.findAll();
  }

  public List<Integer> getIds() {
	  List<Integer> ids = new ArrayList<>();
	  List<Users> files = usersRepository.findAll();
	  ids.add(null);
	  for (Users i : files) {
		ids.add(i.getId());
	  }
	  return ids;
  }

/*	public Set<String> getTypes() {
		Set<String> types = new HashSet<>();
		List<Users> files = usersRepository.findAll();
		types.add("");
		for (Users i : files) {
			types.add(i.getDocType());
		}
		return types;
	}

	public List<Users> getSearch(Users doc) {
		List<Users> types = new ArrayList<>();
		List<Users> files = usersRepository.findAll();
		for (Users i : files) {
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
	}*/

}
