package com.fssa.mgood.service;

import com.fssa.mgood.dao.UserDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.UserValidator;
import com.fssa.mgood.validation.exception.InvalidUserException;

public class UserService {

	/**
	 * Registers a new user by validating user information, checking if the email is
	 * already registered, and creating a user record in the database.
	 *
	 * @param user The UserModel representing the user to register.
	 * @return true if the registration is successful; otherwise, false.
	 * @throws ServiceException If there is an error during registration, this
	 *                          exception is thrown with an error message.
	 */

	public boolean registerUser(UserModel user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);
			if (userDAO.emailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("This email already exists. Try with some other email");
			}
			if (userDAO.createUser(user)) {
				System.out.println(user.getEmail() + " Successfully Register");
				return true;
			} else {
				System.out.println("Registration was not Successful");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Logs in a user by validating the email and password, and checking if they
	 * exist in the database.
	 *
	 * @param user The UserModel representing the user to log in.
	 * @return true if the login is successful; otherwise, false.
	 * @throws ServiceException If there is an error during login, this exception is
	 *                          thrown with an error message.
	 */

	public boolean loginUser(UserModel user) throws ServiceException {
		try {

			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true;
			}
			else {
				throw new ServiceException("To log in, please use the email you used for registration.");
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a user's details by their email address.
	 *
	 * @param email The email address of the user to find.
	 * @return The UserModel representing the user found, or null if not found.
	 * @throws ServiceException If there is an error during retrieval, this
	 *                          exception is thrown with an error message.
	 */

	public UserModel findUserByEmailService(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			return userDAO.findUserByEmail(email);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	// Test for user registration
	public static void main(String[] args) {
		UserService userService = new UserService();
		UserModel user1 = new UserModel("Ramesh", "ramesh12@gmail.com", "Daddy@2002", "9274909327");

		try {
			boolean registrationSuccess = userService.registerUser(user1);
			if (registrationSuccess) {
				System.out.println("User registration successful");
			} else {
				System.out.println("User registration failed");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		// Test for user login
		UserModel user2 = new UserModel("ramesh12@gmail.com", "Daddy@2002");
		try {
			boolean loginSuccess = userService.loginUser(user2);
			if (loginSuccess) {
				System.out.println("User login successful");
			} else {
				System.out.println("User login failed");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("User login error: " + e.getMessage());
		}
	}

}
