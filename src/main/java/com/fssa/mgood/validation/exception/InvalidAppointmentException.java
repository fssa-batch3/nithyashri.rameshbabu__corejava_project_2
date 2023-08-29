package com.fssa.mgood.validation.exception;

public class InvalidAppointmentException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidAppointmentException(String msg) {
		super(msg);
	}

	public InvalidAppointmentException(Throwable e) {
		super(e);
	}

	public InvalidAppointmentException(String msg, Throwable e) {
		super(msg, e);
	}
}
