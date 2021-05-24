package Futronic.service;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
import Futronic.model.Fingerprint;
import Futronic.model.Level2;
import Futronic.model.User;
import Futronic.openFinger.Level2OuterClass;
import Futronic.repository.FingerRepository;
import Futronic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersStorageService {

  	@Autowired
  	private UserRepository userRepository;

	@Autowired
	private FingerRepository fingerRepository;


  public void sending(User user){
	  try{
		  Socket clientSocket = new Socket("147.175.106.8",55555);

		  OutputStream outputStream = clientSocket.getOutputStream();
		  ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		  objectOutputStream.writeObject(user);
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }

	public User saveUser(String name, String username, byte[] data, List<Level2OuterClass.Level2> lvls) {
  		if(findUserByUsername(username)!=null){
  			User user1 = findUserByUsername(username);
			user1 = savingProcess(user1, data,lvls);
  			return this.userRepository.save(user1);
		}
  		try{
			User user = new User(name, username);
			user = savingProcess(user, data,lvls);
			return this.userRepository.save(user);
	  	}
	  	catch(Exception e) {
		  e.printStackTrace();
	  	}
	  return null;
  	}

  	public User savingProcess(User user, byte[] data, List<Level2OuterClass.Level2> lvls){
		Fingerprint fingerprint = new Fingerprint(data);
		for(Level2OuterClass.Level2 i: lvls){
			Level2 level2 = new Level2();
			level2.setX(i.getX());
			level2.setY(i.getY());
			level2.setType(i.getType());
			level2.setAngle(i.getAngle());
			level2.setQuality(i.getQuality());
			level2.setImg_height(i.getImgHeight());
			level2.setImg_width(i.getImgWidth());

			fingerprint.getLevels().add(level2);
		}
		user.getFingers().add(fingerprint);
		return user;
	}


	public User saveFinger(byte[] data, String username) {
		try{
			Fingerprint fingerprint = new Fingerprint(data);
			List<User> users = getUsers();
			for(User user : users){
				if(user.getUsername().equals(username)){
					user.getFingers().add(fingerprint);
					return userRepository.save(user);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findUserByUsername(String username) {
		try{
			List<User> users = getUsers();
			for(User user : users){
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

	public User findUserByFingerprintId(Integer id) {
		try{
			List<User> users = getUsers();
			for(User user : users){

				List<Fingerprint> fprints = user.getFingers();
				for(Fingerprint fprint : fprints){
					if(fprint.getId().equals(id)){
						return user;
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<Fingerprint> findUserFingers(String username){
		List<User> users = getUsers();
		for(User user : users){
			if(user.getUsername().equals(username)){
				return user.getFingers();
			}
		}
		return null;
	}

	  public List<Fingerprint> getFingers(){
		return fingerRepository.findAll();
	}

	  public Optional<User> getUser(Integer id) {
		  return userRepository.findById(id);
	  }

	  public List<User> getUsers() {
			return userRepository.findAll();
		}


	  public List<User> getFiles(){
		  return userRepository.findAll();
	  }

	  public List<Integer> getIds() {
		  List<Integer> ids = new ArrayList<>();
		  List<User> files = userRepository.findAll();
		  ids.add(null);
		  for (User i : files) {
			ids.add(i.getId());
		  }
		  return ids;
	  }

}
