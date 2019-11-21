package com.test.rest.webservices.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	
	@GetMapping("/user")
	public User fetchUser() {
		return new User("Sanjeev" , "Rai");
	}
}
