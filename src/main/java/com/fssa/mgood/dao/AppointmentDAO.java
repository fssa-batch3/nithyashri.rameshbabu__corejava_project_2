package com.fssa.mgood.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.model.UserModel;


public class AppointmentDAO {
	/**
     * Creates a new appointment in the database.
     *
     * @param app The AppointmentsModel representing the appointment to be created.
     * @return true if the appointment is created successfully; otherwise, false.
     * @throws DAOException If there is an error during the creation of the appointment, this exception is thrown with an error message.
     */
	
	public boolean createAppointment(AppointmentsModel app) throws DAOException {

		final String query = "INSERT INTO appointments (doctor_name,appointment_time,hospital_name,user_id) VALUES ( ?, ?, ?, ?)";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, app.getDoctorName());
			pst.setString(2, app.getTime());
			pst.setString(3, app.getHospitalName());
			pst.setInt(4, app.getUser().getUserId());
			int rows = pst.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

  
	/**
     * Retrieves a list of appointments with user and appointment details from the database.
     *
     * @return A list of AppointmentsModel representing appointments.
     * @throws DAOException If there is an error while retrieving appointments, this exception is thrown with an error message.
     */
	
	
	public List<AppointmentsModel> viewAppointment() throws DAOException {
		List<AppointmentsModel> appointments = new ArrayList<>();

		String query = "SELECT user.name, user.email, user.phone, " +
	               "appointments.doctor_name, appointments.hospital_name, appointments.appointment_time , appointments.app_id " + 
	               "FROM user " +
	               "INNER JOIN appointments ON user.user_id = appointments.user_id";
		
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				
				
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phno = rs.getString("phone");
				String docName = rs.getString("doctor_name");
				String hosName = rs.getString("hospital_name");
				String appTime = rs.getString("appointment_time");
				int appId = rs.getInt("app_id");
				
				AppointmentsModel appointment = new AppointmentsModel();
				
				
				UserModel user = new UserModel();
				user.setName(name);
				user.setEmail(email);
				user.setPhone(phno);
	
				
				appointment.setUser(user);
				appointment.setDoctorName(docName);
				appointment.setHospitalName(hosName);
				appointment.setTime(appTime);
				appointment.setAppointmentId(appId);
				appointments.add(appointment);
			}

		} catch (SQLException e) {
			throw new DAOException("Error reading appointment from the table",e);
		}
		return appointments;
	}


	 /**
     * Updates an existing appointment in the database.
     *
     * @param app The AppointmentsModel representing the appointment to be updated.
     * @return true if the appointment is updated successfully; otherwise, false.
     * @throws DAOException If there is an error during the update of the appointment, this exception is thrown with an error message.
     */
	
	public boolean updateAppointments(AppointmentsModel app) throws DAOException {
	    try {
	        String query = "UPDATE appointments " +
	                       "SET doctor_name = ?, appointment_time = ?, hospital_name = ?" +
	                       "WHERE app_id = ?";

	        try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
	        	pst.setString(1, app.getDoctorName());
				pst.setString(2, app.getTime());
				pst.setString(3, app.getHospitalName());
				pst.setInt(4, app.getAppointmentId());

	            int rows = pst.executeUpdate();
	            return (rows == 1);
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error updating appointment in the table",e);
	    }
	    
	    
	}
	
	
	/**
     * Cancels an appointment by its ID in the database.
     *
     * @param appointmentId The ID of the appointment to be canceled.
     * @return true if the appointment is canceled successfully; otherwise, false.
     * @throws DAOException If there is an error during the cancellation of the appointment, this exception is thrown with an error message.
     */
	
	public boolean cancelAppointment(int AppointmentId) throws DAOException {
		String deleteQuery = "DELETE from appointments WHERE app_id=?";
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {

			ps.setInt(1, AppointmentId);
			int rows = ps.executeUpdate();
			return rows == 1;
		} catch (SQLException e) {
			throw new DAOException("Error in cancelling appointment", e);
		}

	}

	
}
