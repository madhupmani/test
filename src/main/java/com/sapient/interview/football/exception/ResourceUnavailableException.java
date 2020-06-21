package com.sapient.interview.football.exception;

public class ResourceUnavailableException extends RuntimeException {

	private static final long serialVersionUID = -6705651335849498954L;

	public ResourceUnavailableException(String message) {
		super(message);
	}
}
