package com.cg.AmusementPark.exception;

public class CustomerExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public CustomerExistsException(String message) {
		super(message);
	}
}
