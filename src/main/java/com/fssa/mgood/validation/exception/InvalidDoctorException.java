package com.fssa.mgood.validation.exception;

public class InvalidDoctorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	    public InvalidDoctorException(String msg) {
	        super(msg);
	    }

	    public InvalidDoctorException(Throwable e) {
	        super(e);
	    }

	    public InvalidDoctorException(String msg, Throwable e) {
	        super(msg, e);
	    }
	

}
