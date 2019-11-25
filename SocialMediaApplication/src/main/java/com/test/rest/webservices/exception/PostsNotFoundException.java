package com.test.rest.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostsNotFoundException extends Exception {
	
	private static final long serialVersionUID = 2775912780555301341L;
	@SuppressWarnings("unused")
	private String messgae;
	
	public PostsNotFoundException(String messgae) {
		super();
		this.messgae = messgae;
	}

}
