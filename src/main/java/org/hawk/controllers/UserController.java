package org.hawk.controllers;

import org.hawk.model.User;
import org.hawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	

	
	
	@RequestMapping(path="/user",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Object createUser(@RequestBody User user) {
		System.out.println("comming to controller");
		
		return userService.createUser(user);
	}

	
	@RequestMapping(path="/user",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Object updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@RequestMapping(path="/user/{username}",method=RequestMethod.GET,produces="application/json")
	public Object getUser(@PathVariable String username) {
		User user = new User();
		user.setUsername(username);
		return userService.getUserDetails(user);
	}
	
	
	
	@RequestMapping(path="/users",method=RequestMethod.GET,produces="application/json")
	public Object getUser() {
		return userService.getAllUsers();
	}
	
	
	
}
