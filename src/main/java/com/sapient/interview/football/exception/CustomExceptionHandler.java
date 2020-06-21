package com.sapient.interview.football.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sapient.interview.football.common.ErrorDetails;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {	

	@ExceptionHandler(InputFormatException.class)
	public final ResponseEntity<ErrorDetails> handleInputFormatException(InputFormatException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}	

	@ExceptionHandler(ResourseAlreadyExistsException.class)
	public final ResponseEntity<ErrorDetails> handleResourseAlreadyExistsException(ResourseAlreadyExistsException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ResourceUnavailableException.class)
	public final ResponseEntity<ErrorDetails> handleResourceUnavailableException(ResourceUnavailableException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public final ResponseEntity<ErrorDetails> handleServiceUnavailableException(ServiceUnavailableException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE.value());
		return new ResponseEntity<>(errorDetails, HttpStatus.SERVICE_UNAVAILABLE);
	}

	

}
