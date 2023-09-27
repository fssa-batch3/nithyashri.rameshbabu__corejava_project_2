package com.fssa.mgood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.DoctorsModel;

public class DoctorDAO {

	 public boolean createDoctor(DoctorsModel doctor) throws DAOException {
	        final String query = "INSERT INTO doctor(name,email,specialization,gender,bio,phone_number,password,registration_number,registration_council,degree,institution,completion_year,experience_year,aadhar_no,aadhar_img,doctor_img,clinic_name,clinic_address,doctor_availability_from,doctor_availability_end,clinic_img,consultation_fee) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
	            preparedStatement.setString(10, doctor.getDegree());
	            preparedStatement.setString(11, doctor.getCollege());
	            preparedStatement.setString(12, doctor.getCompletionYear());
	            preparedStatement.setInt(13, doctor.getExperience());
	            preparedStatement.setLong(14, doctor.getAadharNo());
	            preparedStatement.setString(15, doctor.getAadharImg());
	            preparedStatement.setString(16, doctor.getDoctorImg());
	            preparedStatement.setString(17, doctor.getClinicalName());
	            preparedStatement.setString(18, doctor.getClinicalAddress());
	            preparedStatement.setString(19, doctor.getDoctorAvailabilityFrom());
	            preparedStatement.setString(20, doctor.getDoctorAvailabilityEnd());
	            preparedStatement.setString(21, doctor.getClinicImg());
	            preparedStatement.setInt(22, doctor.getConsulationFee());

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
	 
	 
	 
	   public DoctorsModel loginDoctor(String email, String password) throws DAOException {
	        final String query = "SELECT * FROM doctor WHERE email = ? AND password = ?";
	        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(query)) {
	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    DoctorsModel doctor = new DoctorsModel();
	                    doctor.setDoctorId(resultSet.getInt("doctor_id"));
	                    doctor.setName(resultSet.getString("name"));
	                    doctor.setEmail(resultSet.getString("email"));
	                    // Set other doctor properties from the ResultSet

	                    return doctor;
	                }
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Database error", e);
	        }
	        return null; // No doctor found with the given email and password
	    }

	    public boolean isApproved(String email) throws DAOException {
	        final String query = "SELECT confirmation FROM doctor WHERE email = ?";
	        try (PreparedStatement preparedStatement = ConnectionUtil.getConnection().prepareStatement(query)) {
	            preparedStatement.setString(1, email);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    String confirmationStatus = resultSet.getString("confirmation");
	                    return "approved".equals(confirmationStatus);
	                }
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Database error", e);
	        }
	        return false; // Default to false if no doctor found with the given email
	    }
	    
	    
	    public DoctorsModel findDoctorByEmail(String email) throws DAOException {
	        final String query = "SELECT doctor_id, name, email, specialization, phone, address, profile_pic, experience FROM doctor WHERE email = ?";

	        try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {
	            pstmt.setString(1, email);

	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    DoctorsModel doctor = new DoctorsModel();
	                    doctor.setDoctorId(rs.getInt("doctor_id"));
	                    doctor.setName(rs.getString("name"));
	                    doctor.setEmail(rs.getString("email"));
	                    doctor.setSpecialization(rs.getString("specialization"));
	                    doctor.setPhone(rs.getString("phone"));
	                    doctor.setClinicalAddress(rs.getString("address"));
	                    doctor.setDoctorImg(rs.getString("docimg"));
	                    doctor.setExperience(rs.getInt("experience"));
	                    return doctor;
	                } else {
	                    return null; 
	                }
	            }
	        } catch (SQLException e) {
	            throw new DAOException("Error in getting the doctor details", e);
	        }
	    }

	    
	    
    public boolean updateDoctor(DoctorsModel doctor) throws DAOException {
        final String query = "UPDATE doctors SET name = ?, phone = ?, clinical_address = ?, password = ?, doctor_img = ? WHERE email = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getPhone());
            preparedStatement.setString(3, doctor.getClinicalAddress());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, doctor.getDoctorImg());
            preparedStatement.setString(6, doctor.getEmail());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DAOException("Error updating doctor in the database", e);
        }
    }
	    
    public boolean docEmailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT email FROM doctor WHERE email = ?";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	} 
	 
}
