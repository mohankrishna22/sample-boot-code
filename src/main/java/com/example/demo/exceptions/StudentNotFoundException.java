package com.example.demo.exceptions;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message, Exception ex) {
		super(message, ex);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException() {
		super();
	}

}
