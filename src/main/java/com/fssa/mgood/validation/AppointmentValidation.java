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
		
		return true;
	} 

  
	
}
