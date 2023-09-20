package com.fssa.mgood.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.service.exception.ServiceException;

class TestViewDoctor {
	@Test
	void testviewdoctorssuccess() {
 
		DoctorService docservice = new DoctorService();

		try {

			List<DoctorsModel> doctors = docservice.doctorViewService();

			assertNotNull(doctors);

			for (DoctorsModel p : doctors) {
				System.out.println(p.toString());
			}

			System.out.println("Successfully Viewed");
		} 
		catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
             fail();
		}
	}

	@Test
	void testviewdoctorsinvalid() {
		
		DoctorService docservice = new DoctorService();
		try {

			List<DoctorsModel> doctors = docservice.doctorViewService();

			assertFalse(doctors.isEmpty());

		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
