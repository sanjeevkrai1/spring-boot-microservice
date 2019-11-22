package com.geo.test.task.exception;

public class PublicationException extends Exception {

	private static final long serialVersionUID = -1037002313448598643L;
	private String errorCode = "Unknown_Exception";
	private String errorMessage;

	public PublicationException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

}
