package org.hawk.service;

import java.util.List;

import org.hawk.dao.UserDAO;
import org.hawk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userservice")
@Transactional
public class UserService {
	
	
	@Autowired
	private UserDAO userDAO;

	
	public User createUser(User user) {
		return userDAO.saveUser(user);
	}
	
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
	public List<User> getUserDetails(User user){
		return userDAO.queryUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDAO.allUsers();
	}
	
}
