package com.test.rest.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = -3365310515373994600L;
	@SuppressWarnings("unused")
	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

}
