package com.test.rest.webservices.bean;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String details;

	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return String.format("ExceptionResponse [timeStamp=%s, message=%s, details=%s]", timeStamp, message, details);
	}

}
