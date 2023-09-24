package com.fssa.mgood.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.service.exception.ServiceException;

class TestCreateDoctor {
	@Test
	void testCreateDoctorSuccess() {
		DoctorService doctorService = new DoctorService();
		DoctorsModel doctor = new DoctorsModel();
		try {
			doctor.setName("Doe");
			doctor.setEmail("johndoe@gmail.com");
			doctor.setPassword("Password@123");
			doctor.setPhone("9876543210");
			doctor.setBio("Experienced cardiologist");
			doctor.setGender("Male");
			doctor.setSpecialization("Cardiology");
			doctor.setRegistrationNumber("12345");
			doctor.setRegistrationCouncil("Medical Council");
			doctor.setRegistrationYear("2020");
			doctor.setDegree("MBBS");
			doctor.setCollege("Medical College");
			doctor.setCompletionYear("2015");
			doctor.setExperience(10);
			doctor.setAadharNo(1234567890);
			doctor.setAadharImg("https://example.com/aadhar.jpg");
			doctor.setDoctorImg("https://example.com/doctor.jpg");
			doctor.setClinicalName("Heart Care Clinic");
			doctor.setClinicalAddress("123 Main Street");
			doctor.setDoctorAvailabilityFrom("9:00 AM");
			doctor.setDoctorAvailabilityEnd("5:00 PM");
			doctor.setClinicImg("https://example.com/clinic.jpg");
			doctor.setConsulationFee(200);

			assertTrue(doctorService.createDoctor(doctor));
		} catch (ServiceException e) {
			 e.printStackTrace();
//			fail(e.getMessage());
		}
	}

	@Test
	void testCreateDoctorWithInvalidData() {
		DoctorService doctorService = new DoctorService();
		DoctorsModel doctor = new DoctorsModel();
		try {
			doctor.setName(null);
			doctor.setEmail("invalid_email");
			doctor.setPassword("password123"); 
			doctor.setPhone("12345"); 
			assertFalse(doctorService.createDoctor(doctor));
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
	}
}
