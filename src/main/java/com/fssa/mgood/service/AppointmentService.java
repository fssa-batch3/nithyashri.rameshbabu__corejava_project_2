package com.fssa.mgood.service;

import java.util.List;

import com.fssa.mgood.dao.AppointmentDAO;
import com.fssa.mgood.dao.UserDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;
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

			if (appointmentDAO.updateAppointments(app)) {
				return true;
			} else {
				throw new ServiceException("Update Appointment was not successfull");

			}

		} catch (DAOException | InvalidAppointmentException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}
  
	// Cancel appointment
	public boolean AppointmentCancel(int AppointmentId) throws ServiceException {
		AppointmentDAO appDAO = new AppointmentDAO();
		try {

			return appDAO.cancelAppointment(AppointmentId);
		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	
	
	public static void main(String[] args) {
		AppointmentsModel app = new AppointmentsModel();
		UserModel user = new UserModel();
		user.setUserId(3);
		app.setUser(user);
		app.setDoctorName("Laksmi");
		app.setHospitalName("Miot");
		app.setTime("2023-08-25 14:30:00");

		AppointmentService appservice = new AppointmentService();

		// create appointment
//		try {
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
		try {

			List<AppointmentsModel> appointments = appservice.viewAppointmentService();
			assertNotNull(appointments);
			for (AppointmentsModel appointment : appointments) {
				System.out.println(appointment.toString());
			}
			System.out.println("Successfully Viewed All Appointments");
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// Test to update appointment
//		try {
//			app.setDoctorName("Nithyshri");
//			app.setHospitalName("Apollo");
//			app.setTime("2023-08-25 14:30:00"); // update time
//			app.setAppointmentId(2);
//			if (appservice.UpdateAppointment(app)) {
//				System.out.println("Appointment updated successfully.");
//			} else {
//				System.out.println("Appointment update failed.");
//			}
//
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}

		// Cancel the appointment
        try {
            boolean CancelApp = appservice.AppointmentCancel(9);
            
            if (CancelApp) {
                System.out.println("Appointment cancelled successfully.");
            } else {
                System.out.println("Failed to cancel the appointment");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        
    }

	}

	private static void assertNotNull(Object object) throws ServiceException {
		if (object == null) {
			throw new ServiceException("Object is null");		}
	}


	
   
}
