package com.cg.AmusementPark.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ CustomerNotFoundException.class })
	public final ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception,
			WebRequest req) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),
				"The customer which you are trying to perform operation on is not present in the database", new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler({ CustomerExistsException.class })
	public final ResponseEntity<Object> handleCustomerExistsException(CustomerExistsException exception,
			WebRequest req) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),
				"The customer which you are trying to perform operation is already present in the database", new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.CONFLICT);

	}
	
	@ExceptionHandler({ ActivityNotFoundException.class })
	public final ResponseEntity<Object> handleActivityNotFoundException(ActivityNotFoundException exception,
			WebRequest req) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),
				"The Activity which you are trying to perform operation is not present in the database", new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler({ ActivityExistsException.class })
	public final ResponseEntity<Object> handleActivityExistsException(ActivityExistsException exception,
			WebRequest req) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(),
				"The Activity which you are trying to perform operation is already present in the database", new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.CONFLICT);

	}

}
