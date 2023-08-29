package com.fssa.mgood.service;

import com.fssa.mgood.dao.AppointmentDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.AppointmentValidation;
import com.fssa.mgood.validation.exception.InvalidAppointmentException;

public class AppointmentService {

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
	
	public static void main(String[] args) {
		AppointmentsModel app = new AppointmentsModel();
		UserModel user = new UserModel();
		user.setUserId(3);
		app.setUser(user);
		app.setDoctorName("Laks"); 
		app.setHospitalName("Arc");
		app.setTime("2023-08-25 14:30:00");
		
		AppointmentService appservice = new AppointmentService();
		  try {
	            boolean appointmentSuccess = appservice.createAppointment(app);
	            if (appointmentSuccess) {
	                System.out.println("Appoinment successful");
	            } else {
	                System.out.println("Appoinment failed");
	            }
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            System.out.println(e);
	        }
	        
	}
	
	
}
