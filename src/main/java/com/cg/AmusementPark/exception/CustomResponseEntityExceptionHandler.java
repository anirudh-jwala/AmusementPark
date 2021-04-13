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

}
