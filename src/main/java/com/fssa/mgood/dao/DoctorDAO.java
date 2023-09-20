package com.fssa.mgood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.DoctorsModel;

public class DoctorDAO {

	 public boolean createDoctor(DoctorsModel doctor) throws DAOException {
	        final String query = "INSERT INTO doctor(name,email,specialization,gender,bio,phone_number,password,registration_number,registration_council,registration_year,degree,institution,completion_year,experience_year,aadhar_no,aadhar_img,doctor_img,clinic_name,clinic_address,doctor_availability_from,doctor_availability_end,clinic_img,consultation_fee) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(query)) {
	            preparedStatement.setString(1, doctor.getName());
	            preparedStatement.setString(2, doctor.getEmail());
	            preparedStatement.setString(3, doctor.getSpecialization());
	            preparedStatement.setString(4, doctor.getGender());
	            preparedStatement.setString(5, doctor.getBio());
	            preparedStatement.setString(6, doctor.getPhone());
	            preparedStatement.setString(7, doctor.getPassword());
	            preparedStatement.setString(8, doctor.getRegistrationNumber());
	            preparedStatement.setString(9, doctor.getRegistrationCouncil());
	            preparedStatement.setString(10, doctor.getRegistrationYear());
	            preparedStatement.setString(11, doctor.getDegree());
	            preparedStatement.setString(12, doctor.getCollege());
	            preparedStatement.setString(13, doctor.getCompletionYear());
	            preparedStatement.setInt(14, doctor.getExperience());
	            preparedStatement.setLong(15, doctor.getAadharNo());
	            preparedStatement.setString(16, doctor.getAadharImg());
	            preparedStatement.setString(17, doctor.getDoctorImg());
	            preparedStatement.setString(18, doctor.getClinicalName());
	            preparedStatement.setString(19, doctor.getClinicalAddress());
	            preparedStatement.setString(20, doctor.getDoctorAvailabilityFrom());
	            preparedStatement.setString(21, doctor.getDoctorAvailabilityEnd());
	            preparedStatement.setString(22, doctor.getClinicImg());
	            preparedStatement.setInt(23, doctor.getConsulationFee());

	            int rowsInserted = preparedStatement.executeUpdate();
	            if (rowsInserted > 0) {
	                return true;
	            } else {
	                throw new DAOException("Failed to insert doctor");
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Database error", e);
	        }
	    }
	 
	 public List<DoctorsModel> viewDoctors() throws DAOException {
	        List<DoctorsModel> doctorsList = new ArrayList<>();
	        final String query = "SELECT * FROM doctor"; 
	        
	        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            
	            while (resultSet.next()) {
	                DoctorsModel doctor = new DoctorsModel();
	                doctor.setDoctorId(resultSet.getInt("doctor_id"));
	                doctor.setName(resultSet.getString("name"));
	                doctor.setEmail(resultSet.getString("email"));
	                doctor.setSpecialization(resultSet.getString("specialization"));
	                doctor.setGender(resultSet.getString("gender"));
	                doctor.setBio(resultSet.getString("bio"));
	                doctor.setPhone(resultSet.getString("phone_number"));
	                doctor.setPassword(resultSet.getString("password"));
	                doctor.setRegistrationNumber(resultSet.getString("registration_number"));
	                doctor.setRegistrationCouncil(resultSet.getString("registration_council"));
	                doctor.setRegistrationYear(resultSet.getString("registration_year"));
	                doctor.setDegree(resultSet.getString("degree"));
	                doctor.setCollege(resultSet.getString("institution"));
	                doctor.setCompletionYear(resultSet.getString("completion_year"));
	                doctor.setExperience(resultSet.getInt("experience_year"));
	                doctor.setAadharNo(resultSet.getLong("aadhar_no"));
	                doctor.setAadharImg(resultSet.getString("aadhar_img"));
	                doctor.setDoctorImg(resultSet.getString("doctor_img"));
	                doctor.setClinicalName(resultSet.getString("clinic_name"));
	                doctor.setClinicalAddress(resultSet.getString("clinic_address"));
	                doctor.setDoctorAvailabilityFrom(resultSet.getString("doctor_availability_from"));
	                doctor.setDoctorAvailabilityEnd(resultSet.getString("doctor_availability_end"));
	                doctor.setClinicImg(resultSet.getString("clinic_img"));
	                doctor.setConsulationFee(resultSet.getInt("consultation_fee"));
	                doctor.setConfirmation(resultSet.getString("confirmation"));
	                doctorsList.add(doctor);
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Database error", e);
	        }
	        
	        return doctorsList;
	    } 
	 
	 public boolean doctorConfirmationApproved(DoctorsModel doctors) throws DAOException {
		 final String query = "UPDATE doctor SET confirmation = ? WHERE doctor_id = ? ";
	     try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)){
	    	 pst.setString(1, doctors.getConfirmation());
	    	 pst.setInt(2, doctors.getDoctorId());
	    	 int rows = pst.executeUpdate();
	    	 return (rows>0);
	     } catch (SQLException e) {
			throw new DAOException("Error in updating the confirmation in doctor table",e);
			
		}
	 }
	 
}
