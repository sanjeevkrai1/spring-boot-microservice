package com.test.rest.webservices.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.rest.webservices.bean.User;
import com.test.rest.webservices.service.UserNotFoundException;
import com.test.rest.webservices.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> findAllUser() {
		return userService.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable("id")int id) throws UserNotFoundException {
		return userService.findById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.createUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(savedUser.getId());
		
		return  ResponseEntity.created(uri).build();
	
	}

}
