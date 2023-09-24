package com.fssa.mgood.service;

import java.util.List;

import com.fssa.mgood.dao.AppointmentDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.AppointmentValidation;
import com.fssa.mgood.validation.exception.InvalidAppointmentException;

public class AppointmentService {

	/**
	 * Creates a new appointment.
	 *
	 * @param app The appointment to be created.
	 * @return True if the appointment creation was successful, false otherwise.
	 * @throws ServiceException If there is an issue with the service.
	 */

	public boolean createAppointment(AppointmentsModel app) throws ServiceException {

		AppointmentDAO appDAO = new AppointmentDAO();

		try {
			if (!AppointmentValidation.validateAppointements(app)) {
				return false;
			}
			return appDAO.createAppointment(app);
		} catch (DAOException | InvalidAppointmentException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Retrieves a list of appointments.
	 *
	 * @return A list of AppointmentsModel objects representing appointments.
	 * @throws ServiceException If there is an issue with the service.
	 */
	public List<AppointmentsModel> viewAppointmentService() throws ServiceException {
		AppointmentDAO appointmentDAO = new AppointmentDAO();

		try {
			return appointmentDAO.viewAppointment();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<String> viewAppointmentTimesService(String appointmentDate, int doctorId) throws ServiceException {
		AppointmentDAO appointmentDAO = new AppointmentDAO();

		try {
			return appointmentDAO.viewAppointmentTime(appointmentDate, doctorId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Updates an existing appointment.
	 *
	 * @param app The appointment to be updated.
	 * @return True if the appointment update was successful, false otherwise.
	 * @throws ServiceException If there is an issue with the service.
	 */

	public boolean UpdateAppointment(AppointmentsModel app) throws ServiceException {

		AppointmentDAO appointmentDAO = new AppointmentDAO();

		try {
			AppointmentValidation.validateAppointements(app);

			if (appointmentDAO.updateAppointment(app)) {
				return true;
			} else {
				throw new ServiceException("Update Appointment was not successfull");

			}

		} catch (DAOException | InvalidAppointmentException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	/**
	 * Cancels an appointment by its ID in the database.
	 *
	 * @param appointmentId The ID of the appointment to be canceled.
	 * @return true if the appointment is canceled successfully; otherwise, false.
	 * @throws DAOException If there is an error during the cancellation of the
	 *                      appointment, this exception is thrown with an error
	 *                      message.
	 */

	public boolean AppointmentCancel(int AppointmentId) throws ServiceException {
		AppointmentDAO appDAO = new AppointmentDAO();
		try {

			return appDAO.cancelAppointment(AppointmentId);
		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

	public boolean isAppointmentAvailable(int doctorId, String date, String time) throws ServiceException {
		AppointmentDAO appdao = new AppointmentDAO();
	    try {
	        return appdao.isAppointmentAvailable(doctorId, date, time);
	    } catch (DAOException e) {
	        throw new ServiceException("Error checking appointment availability: " + e.getMessage(), e);
	    }
	}


// Testing
	// create appointment
	public static void main(String[] args) {
		AppointmentsModel app = new AppointmentsModel();
		UserModel user = new UserModel();
		DoctorsModel doc = new DoctorsModel();

		user.setUserId(3);
		doc.setDoctorId(6);
		app.setUser(user);
		app.setDoctor(doc);
		app.setForWhom("myself");
		app.setSlotdate("2023-09-25");
		app.setTime("10:00 AM-11:00 AM");

		AppointmentService appservice = new AppointmentService();
//	try {
//			boolean appointmentSuccess = appservice.createAppointment(app);
//			if (appointmentSuccess) {
//				System.out.println("Appoinment successful");
//			} else {
//				System.out.println("Appoinment failed");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			System.out.println(e);
//		}

		// Test to view appointment
//		try {
//			List<AppointmentsModel> appointments = appservice.viewAppointmentService();
//			if (appointments.isEmpty()) {
//				System.out.println("No appointments found.");
//			} else {
//				for (AppointmentsModel appointment : appointments) {
//					System.out.println(appointment.toString());
//				}
//				System.out.println("Successfully Viewed All Appointments");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//		
		

	    String appointmentDate = "2023-09-25"; // Replace with your desired date
	    int doctorId = 6; // Replace with the doctor's ID you want to retrieve times for

	    try {
	        List<String> appointmentTimes = appservice.viewAppointmentTimesService(appointmentDate, doctorId);
	        
	        if (appointmentTimes.isEmpty()) {
	            System.out.println("No appointment times found.");
	        } else {
	            System.out.println("Appointment times:");
	            for (String time : appointmentTimes) {
	                System.out.println(time);
	            }
	        }
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        System.out.println("Error: " + e.getMessage());
	    }

		// Test to update appointment
//
//		try {
//			app.setTime("2023-08-25 14:30:00"); // To do update time
//			app.setAppointmentId(2);
//			if (appservice.UpdateAppointment(app)) {
//				System.out.println("Appointment updated successfully.");
//			} else {
//				System.out.println("Appointment update failed.");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}

		// Cancel the appointment

//		try {
//			boolean CancelApp = appservice.AppointmentCancel(9);
//
//			if (CancelApp) {
//				System.out.println("Appointment cancelled successfully.");
//			} else {
//				System.out.println("Failed to cancel the appointment");
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//
//		}

	}

//	private static void assertNotNull(Object object) throws ServiceException {
//		if (object == null) {
//			throw new ServiceException("Object is null");
//		}
//	}

}
