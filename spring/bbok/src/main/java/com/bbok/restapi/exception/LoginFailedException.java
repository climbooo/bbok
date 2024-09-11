package com.bbok.restapi.exception;

public class LoginFailedException extends RuntimeException{

	public LoginFailedException(String message) {
		super(message);
	}
}
