package com.fssa.mgood.validation.exception;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable e) {
		super(e);
	}

	public InvalidUserException(String msg, Throwable e) {
		super(msg, e);
	}

}
