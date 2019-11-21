package com.test.rest.webservices.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducesVersioning {
	
	@GetMapping(value = "/person/produces" , produces = "application/vnd.company.app-v1+json")
	public Person getPersion() {
		return new Person("Sanjeev Rai");
	}
	
	
	@GetMapping(value = "/person/produces" ,  produces = "application/vnd.company.app-v2+json")
	public PersonV1 fetchPersion() {
		return new PersonV1(new Name("Sanjeev", "Rao" ));
	}

}
