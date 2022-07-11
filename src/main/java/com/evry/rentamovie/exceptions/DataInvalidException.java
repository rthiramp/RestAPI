package com.evry.rentamovie.exceptions;

public class DataInvalidException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DataInvalidException(String message) {
		super(message);
	}
	
	public DataInvalidException() {
		super();
	}
}
