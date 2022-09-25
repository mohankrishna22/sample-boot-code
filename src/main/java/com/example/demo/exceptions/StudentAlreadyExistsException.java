package com.example.demo.exceptions;

public class StudentAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentAlreadyExistsException(String message, Exception ex) {
		super(message, ex);
	}

	public StudentAlreadyExistsException(String message) {
		super(message);
	}

	public StudentAlreadyExistsException() {
		super();
	}

}
