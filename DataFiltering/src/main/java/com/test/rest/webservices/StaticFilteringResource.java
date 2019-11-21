package com.test.rest.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringResource {

	@GetMapping("/filter")
	public User filterBean() {
		return new User("Sanjeev", "GKP" , "23131");
	}
}
