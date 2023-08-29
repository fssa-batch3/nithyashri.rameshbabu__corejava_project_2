package com.fssa.mgood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.AppointmentsModel;


public class AppointmentDAO {
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

   




}
