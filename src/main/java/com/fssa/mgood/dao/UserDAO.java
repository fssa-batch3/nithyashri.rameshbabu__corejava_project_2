package com.fssa.mgood.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.UserModel;

public class UserDAO {
 
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

	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	} 

	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

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

}
