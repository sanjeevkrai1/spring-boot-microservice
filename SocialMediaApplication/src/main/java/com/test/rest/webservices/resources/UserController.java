package com.test.rest.webservices.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.webservices.model.User;
import com.test.rest.webservices.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value =  "/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") Integer userId) throws Exception {
		return userService.getUser(userId);
	}
	
	
	@PostMapping(value = "/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping(value = "/users/{userId}")
	public User updateUser(@PathVariable("userId") Integer userId , @RequestBody User user) {
		return userService.updateUser(userId , user);
	}
	
	@DeleteMapping(value = "/users")
	public void delete() {
		userService.deleteAll();
	}
	
	@DeleteMapping(value = "/users/{userId}")
	public void delete(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
	}
}
