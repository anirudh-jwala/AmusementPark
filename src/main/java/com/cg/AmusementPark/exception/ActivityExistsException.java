package com.cg.AmusementPark.exception;

public class ActivityExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public ActivityExistsException(String message) {
		super(message);
	}
}
