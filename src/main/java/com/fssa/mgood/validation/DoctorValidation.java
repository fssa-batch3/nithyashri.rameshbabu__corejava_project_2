package com.fssa.mgood.validation;

import java.util.regex.Pattern;

import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.validation.exception.InvalidDoctorException;

public class DoctorValidation {


	public static boolean validateDoctor(DoctorsModel doctor) throws InvalidDoctorException {
	    if (doctor == null) {
	        throw new InvalidDoctorException("Doctor details cannot be null");
	    }
        
	    if (!validateDoctorEmail(doctor.getEmail()) || !validateDoctorPassword(doctor.getPassword())
	            || !validateDoctorName(doctor.getName()) || !validateDoctorMobile(doctor.getPhone())) {
	        throw new InvalidDoctorException("Invalid format. Please avoid spaces.");
	    }
	    return true;
	}

	
	// Modify validateEmail to validate doctor's email
	public static boolean validateDoctorEmail(String email) throws InvalidDoctorException {
	    boolean isMatch = false;
	    if (email == null || email.trim().isEmpty())
	        return false;
	    String regex = "^.*@.*\\..*$";
	    isMatch = Pattern.matches(regex, email);
	    if (isMatch) {
	        return true;
	    } else {
	    	System.out.println("hai");
	        throw new InvalidDoctorException("The email address is invalid");
	    }
	}

	// Modify validatePassword to validate doctor's password
	public static boolean validateDoctorPassword(String password) throws InvalidDoctorException {
	    boolean match = false;
	    if (password == null || password.trim().isEmpty())
	        return false;
	    String reg = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
	    match = Pattern.matches(reg, password);

	    if (match) {
	        return true;
	    } else {
	    	System.out.println("hai");
	        throw new InvalidDoctorException("Invalid password format. The password should follow the pattern like 'Abdul@007'.");
	    }
	}

	// Modify validateName to validate doctor's name
	public static boolean validateDoctorName(String name) throws InvalidDoctorException {
	    boolean match = false;
	    if (name == null || name.trim().isEmpty())
	        return false;

	    String regex = "^[A-Za-z]{3,30}$";
	    match = Pattern.matches(regex, name);
	    if (match) {
	        return true;
	    } else {
	        throw new InvalidDoctorException("The doctor name is not valid");
	    }
	}

	public static boolean validateDoctorMobile(String mobileno) throws InvalidDoctorException {
	    boolean isMatch = false;
	    if (mobileno == null || mobileno.trim().isEmpty()) {
	        return false;
	    }
	    String regex = "^[6789]\\d{9}$";
	    isMatch = Pattern.matches(regex, mobileno);
	    if (isMatch) {
	        return true;
	    } else {
	        throw new InvalidDoctorException("Invalid mobile number format. Enter your mobile number like this: 6374449092.");
	    }
	}

		
	
	
}
