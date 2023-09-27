package com.fssa.mgood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;
import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;

public class AppointmentDAO {
    /**
     * Creates a new appointment in the database.
     *
     * @param app The AppointmentsModel representing the appointment to be created.
     * @return true if the appointment is created successfully; otherwise, false.
     * @throws DAOException If there is an error during the creation of the appointment, this exception is thrown with an error message.
     */
    public boolean createAppointment(AppointmentsModel app) throws DAOException {
        final String query = "INSERT INTO appointments (appointment_date, appointment_time, user_id, doctor_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
            pst.setString(1, app.getSlotdate());
            pst.setString(2, app.getTime());
            pst.setInt(3, app.getUser().getUserId());
            pst.setInt(4, app.getDoctor().getDoctorId());

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

		String query = "SELECT u.name AS user_name, u.email AS user_email, u.phone AS user_phone, u.user_id AS user_id, " +
	               "a.appointment_date, a.appointment_time, a.app_id, " +
	               "d.name AS doctor_name, d.email AS doctor_email, d.phone_number AS doctor_phone, " +
	               "d.clinic_name, d.clinic_address,d.clinic_img, d.doctor_availability_from, d.doctor_availability_end, d.doctor_id " +
	               "FROM appointments a " +
	               "INNER JOIN user u ON a.user_id = u.user_id " +
	               "INNER JOIN doctor d ON a.doctor_id = d.doctor_id";

		
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				
				
				String user_name = rs.getString("user_name");
				String user_email = rs.getString("user_email");
				String user_phone = rs.getString("user_phone");
				int user_id = rs.getInt("user_id");
				String appointment_date = rs.getString("appointment_date");
				String appointment_time = rs.getString("appointment_time");
				int appId = rs.getInt("app_id");
				String doctor_name = rs.getString("doctor_name");
				String doctor_email = rs.getString("doctor_email");
				String doctor_phone = rs.getString("doctor_phone");
				String clinic_name = rs.getString("clinic_name");
				String clinic_address = rs.getString("clinic_address");
				String clinic_img = rs.getString("clinic_img");
				String doctor_availability_from = rs.getString("doctor_availability_from");
				String doctor_availability_end = rs.getString("doctor_availability_end");
				int doctor_id = rs.getInt("doctor_id");
				
				
				AppointmentsModel appointment = new AppointmentsModel();
		        UserModel user = new UserModel();
		       
				user.setName(user_name);
				user.setEmail(user_email);
				user.setPhone(user_phone);
				user.setUserId(user_id);
				appointment.setUser(user);
				
				
				DoctorsModel doc = new DoctorsModel();
				doc.setName(doctor_name);
				doc.setEmail(doctor_email);
				doc.setPhone(doctor_phone);
				doc.setClinicalName(clinic_name);
				doc.setClinicalAddress(clinic_address);
				doc.setClinicImg(clinic_img);
				doc.setDoctorAvailabilityFrom(doctor_availability_from);
				doc.setDoctorAvailabilityEnd(doctor_availability_end);
				doc.setDoctorId(doctor_id);
				appointment.setDoctor(doc);
				
			
				appointment.setTime(appointment_time);
				appointment.setSlotdate(appointment_date);
				appointment.setAppointmentId(appId);
				appointments.add(appointment);
			}

		} catch (SQLException e) {
			throw new DAOException("Error reading appointment from the table",e);
		}
		return appointments;
	}
	
	public List<String> viewAppointmentTime(String appointmentDate, int doctorId) throws DAOException {
	    List<String> appointmentTimes = new ArrayList<>();

	    final String query = "SELECT appointment_time FROM appointments WHERE appointment_date = ? AND doctor_id = ?";

	    try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(query)) {

	    	ps.setString(1, appointmentDate);
	    	ps.setInt(2, doctorId);

	        try (ResultSet resultSet = ps.executeQuery()) {
	            while (resultSet.next()) {
	                String appointmentTime = resultSet.getString("appointment_time");
	                appointmentTimes.add(appointmentTime);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error retrieving appointment times", e);
	    }

	    return appointmentTimes;
	}

	
	public boolean isAppointmentAvailable(int doctorId, String date, String time) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        String sql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND slot_date = ? AND time = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setInt(1, doctorId);
	            preparedStatement.setString(2, date);
	            preparedStatement.setString(3, time);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int appointmentCount = resultSet.getInt(1);
	                    return appointmentCount == 0; 
	                }
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error checking appointment availability: " + e.getMessage(), e);
	    }

	    // Return true by default if there was an error or exception
	    return true;
	}

	
	  public static void main(String[] args) {
	        AppointmentDAO appointmentDAO = new AppointmentDAO();

	        try {
	            List<AppointmentsModel> appointments = appointmentDAO.viewAppointment();
	            if (appointments.isEmpty()) {
	                System.out.println("No appointments found.");
	            } else {
	                System.out.println("Appointments found:");
	                for (AppointmentsModel appointment : appointments) {
	                    System.out.println(appointment.toString());
	                }
	            }
	        } catch (DAOException e) {
	            e.printStackTrace();
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

    

    /**
     * Updates an existing appointment in the database.
     *
     * @param app The AppointmentsModel representing the appointment to be updated.
     * @return true if the appointment is updated successfully; otherwise, false.
     * @throws DAOException If there is an error during the update of the appointment, this exception is thrown with an error message.
     */
    public boolean updateAppointment(AppointmentsModel app) throws DAOException {
        try {
            String query = "UPDATE appointments " +
                    "SET appointment_date = ?, appointment_time = ?, user_id = ?, doctor_id = ? " +
                    "WHERE app_id = ?";

            try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
                pst.setString(1, app.getSlotdate());
                pst.setString(2, app.getTime());
                pst.setInt(3, app.getUser().getUserId());
                pst.setInt(4, app.getDoctor().getDoctorId());
                pst.setInt(5, app.getAppointmentId());

                int rows = pst.executeUpdate();
                return (rows == 1);
            }
        } catch (SQLException e) {
            throw new DAOException("Error updating appointment in the table", e);
        }
    }

    
    
    /**
     * Cancels an appointment by its ID in the database.
     *
     * @param appointmentId The ID of the appointment to be canceled.
     * @return true if the appointment is canceled successfully; otherwise, false.
     * @throws DAOException If there is an error during the cancellation of the appointment, this exception is thrown with an error message.
     */
    public boolean cancelAppointment(int appointmentId) throws DAOException {
        String deleteQuery = "DELETE FROM appointments WHERE app_id = ?";
        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(deleteQuery)) {
            ps.setInt(1, appointmentId);
            int rows = ps.executeUpdate();
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException("Error in canceling appointment", e);
        }
    }
    
    
    

}
