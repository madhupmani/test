package com.sapient.interview.football.exception;

public class ServiceUnavailableException extends RuntimeException {
	
	private static final long serialVersionUID = 7732159198020194207L;

	public ServiceUnavailableException(String message) {
		super(message);
	}
}
