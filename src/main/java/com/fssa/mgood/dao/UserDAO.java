package com.fssa.mgood.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.UserModel;

public class UserDAO {
	/**
	 * Creates a new user in the database with the provided user information.
	 *
	 * @param user The UserModel object containing user details.
	 * @return true if the user is successfully created, false otherwise.
	 * @throws DAOException if there is an error during database operation.
	 */
	
	
	public boolean createUser(UserModel user) throws DAOException {
		
		final String query = "INSERT INTO user (name, email, password,phone) VALUES ( ?, ?, ? ,?)";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getPhone());
			int rows = pst.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	 /**
     * Checks if the provided email address is already registered in the database.
     *
     * @param email The email address to check.
     * @return true if the email is already registered, false otherwise.
     * @throws DAOException if there is an error during database operation.
     */
	
	
	public boolean emailAlreadyRegistered(String email) throws DAOException {
		final String query = "SELECT email FROM user WHERE email = ?";

		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	} 
	
	
	private String userPasswordFromDb;
	/**
     * Gets the user password from the database.
     *
     * @return The user's password from the database.
     */
	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	} 

	/**
     * Sets the user password from the database.
     *
     * @param userPasswordFromDb The user's password from the database.
     */
	
	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

	
	
	/**
     * Attempts to log in a user by checking their email and password in the database.
     *
     * @param user The UserModel object containing the user's email and password.
     * @return true if the login is successful, false otherwise.
     * @throws DAOException if there is an error during database operation.
     */
	
	public boolean loginUser(UserModel user) throws DAOException {
		String email = user.getEmail();
		final String query = "Select email,password FROM user Where email=? ";
		try (PreparedStatement pst = ConnectionUtil.getConnection().prepareStatement(query)) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {

					setUserPasswordFromDb(rs.getString("password"));
					return true;

				}

			}
		} catch (SQLException e) {

			throw new DAOException("Login is failed error in getting value from db");
		}

		return false;

	}

	/**
     * Retrieves user details by searching for a user with the given email address.
     *
     * @param email The email address to search for.
     * @return A UserModel object containing user details if found, or null if not found.
     * @throws DAOException if there is an error during database operation.
     */
	
	public UserModel findUserByEmail(String email) throws DAOException {
	    final String query = "SELECT name, email, password, phone, user_id FROM user WHERE email = ?";

	    try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(query)) {
	        pstmt.setString(1, email);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                UserModel user = new UserModel();
	                user.setName(rs.getString("name"));
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setPhone(rs.getString("phone"));
	                user.setUserId(rs.getInt("user_id"));
	                return user;
	            } else {
	                return null; // Return null if the email does not exist
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException("Error in getting the user details", e);
	    }
	}
}
