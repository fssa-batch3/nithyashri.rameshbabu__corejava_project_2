package com.fssa.mgood.validation;

import java.util.regex.Pattern;

import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.validation.exception.InvalidAppointmentException;


public class AppointmentValidation {
	
	public static boolean validateAppointements(AppointmentsModel appointmentmodel) throws InvalidAppointmentException {
		if(appointmentmodel == null) {
			throw new InvalidAppointmentException("Appointment cannot be null");
		}
		if(validateDoctorName(appointmentmodel.getDoctorName()) && validateHospitalName(appointmentmodel.getHospitalName()) && validateTime(appointmentmodel.getTime())) {
			return true;
		}
		else {
			throw new InvalidAppointmentException("Appointment is not valid");
		}
	} 

	public static boolean validateDoctorName(String name) throws InvalidAppointmentException {
        boolean match = false;
        if (name == null  || name.trim().isEmpty())
            return false;
       String regex = "^[A-Za-z]\\w{2,29}$";
       match = Pattern.matches(regex, name); 
        if (match) {
            return true;
        } else {
            throw new InvalidAppointmentException("The doctor name is not valid");
        }

    }
	
	public static boolean validateHospitalName(String name) throws InvalidAppointmentException {
        boolean match = false;
        if (name == null  || name.trim().isEmpty())
            return false;
       String regex = "^[A-Za-z]\\w{2,29}$";
       match = Pattern.matches(regex, name);
        if (match) {
            return true;
        } else {
            throw new InvalidAppointmentException("The hospital name is not valid");
        }
 
    }
	
	  public static boolean validateTime(String time) throws InvalidAppointmentException {
	        boolean match = false;
	        if (time == null || time.trim().isEmpty()) {
	            return false;
	        }    
	        String regex = "^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})$";
	        match = Pattern.matches(regex, time);
	        
	        if (match) {
	            return true;
	        } else {
	            throw new InvalidAppointmentException("The time is not valid");
	        }

	    }
	  
	  
	
}
