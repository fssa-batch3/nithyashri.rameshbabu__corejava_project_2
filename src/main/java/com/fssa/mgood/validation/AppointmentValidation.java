package com.fssa.mgood.validation;

import java.util.regex.Pattern;

import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.validation.exception.InvalidAppointmentException;


public class AppointmentValidation {
	
	/**
     * Validates an AppointmentsModel object by checking its doctor name, hospital name, and time.
     *
     * @param appointmentmodel The AppointmentsModel to validate.
     * @return true if the appointment is valid; otherwise, false.
     * @throws InvalidAppointmentException If the appointment is invalid, this exception is thrown with an error message.
     */
	
	public static boolean validateAppointements(AppointmentsModel appointmentmodel) throws InvalidAppointmentException {
		if(appointmentmodel == null) {
			throw new InvalidAppointmentException("Appointment cannot be null");
		}
		if(!validateDoctorName(appointmentmodel.getDoctorName()) || !validateHospitalName(appointmentmodel.getHospitalName()) || !validateTime(appointmentmodel.getTime())) {
			throw new InvalidAppointmentException("Appointment is not valid");
		}
		return true;
	} 

	
	 /**
     * Validates a doctor's name.
     *
     * @param name The doctor's name to validate.
     * @return true if the doctor's name is valid; otherwise, false.
     * @throws InvalidAppointmentException If the doctor's name is invalid, this exception is thrown with an error message.
     */
	
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
	
	/**
     * Validates a hospital's name.
     *
     * @param name The hospital's name to validate.
     * @return true if the hospital's name is valid; otherwise, false.
     * @throws InvalidAppointmentException If the hospital's name is invalid, this exception is thrown with an error message.
     */
	
	
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
	

    /**
     * Validates a time string.
     *
     * @param time The time string to validate.
     * @return true if the time string is valid; otherwise, false.
     * @throws InvalidAppointmentException If the time string is invalid, this exception is thrown with an error message.
     */
	
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
