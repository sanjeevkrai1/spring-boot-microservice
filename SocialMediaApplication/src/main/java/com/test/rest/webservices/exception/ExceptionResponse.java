package com.test.rest.webservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String messageDetails;

	public ExceptionResponse(Date timeStamp, String message, String messageDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.messageDetails = messageDetails;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageDetails() {
		return messageDetails;
	}

	@Override
	public String toString() {
		return String.format("ExceptionResponse [timeStamp=%s, message=%s, messageDetails=%s]", timeStamp, message,
				messageDetails);
	}

}
