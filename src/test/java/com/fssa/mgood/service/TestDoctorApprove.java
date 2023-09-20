package com.fssa.mgood.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.service.exception.ServiceException;

public class TestDoctorApprove {
	   @Test
	    public void testDocServiceApprove() {
	        DoctorsModel doctors = new DoctorsModel();
	        doctors.setConfirmation("approved");
	        doctors.setDoctorId(1); 
	        DoctorService doctorService = new DoctorService();
	        try {
	            boolean result = doctorService.docServiceApprove(doctors);
	            assertTrue(result);
	        } catch (ServiceException e) {
	            fail("Exception should not be thrown: " + e.getMessage());
	        }
	    }
	   
	   @Test
	    public void testDocServiceApprovefail() {
	        DoctorsModel doctors = new DoctorsModel();
	        doctors.setConfirmation("approved failed");
	        doctors.setDoctorId(-1); 
	        DoctorService doctorService = new DoctorService();
	        try {
	            boolean result = doctorService.docServiceApprove(doctors);
	            assertFalse(result);
	        } catch (ServiceException e) {
	        	System.out.println(e.getMessage());
	        }
	    }
	   
}
