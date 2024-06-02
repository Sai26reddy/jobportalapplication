package com.digit.jobPortalApplication.exceptionHandling;

public class NoPostedJobExistsException extends Exception{

	public NoPostedJobExistsException(String message) {
		super(message);
	}
}
