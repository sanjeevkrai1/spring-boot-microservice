package com.test.rest.webservices.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderVersioning {

	@GetMapping(value = "/person/header" , headers = "X-API-VERSION=1")
	public Person getPersion() {
		return new Person("Sanjeev Rai");
	}
	
	
	@GetMapping(value = "/person/header" ,  headers = "X-API-VERSION=2")
	public PersonV1 fetchPersion() {
		return new PersonV1(new Name("Sanjeev", "Rao" ));
	}
	
	
}
