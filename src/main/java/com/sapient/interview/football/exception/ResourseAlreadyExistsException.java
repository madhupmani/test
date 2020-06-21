package com.sapient.interview.football.exception;

public class ResourseAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourseAlreadyExistsException(String message) {
		super(message);
	}
}