package com.fssa.mgood.service;

import com.fssa.mgood.dao.UserDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.UserValidator;
import com.fssa.mgood.validation.exception.InvalidUserException;

public class UserService {
	public boolean registerUser(UserModel user) throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try { 
			UserValidator.validateUser(user);
			if (userDAO.emailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
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
	
	public boolean loginUser(UserModel user) throws ServiceException {
		try {

			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.loginUser(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				return true; 
			}
		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}
		return false;
	}
	
	
	public UserModel findUserByEmailService(String email) throws ServiceException {
		 UserDAO userDAO = new UserDAO();
	        try {
	            return userDAO.findUserByEmail(email);
	        } catch (DAOException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	
	public static void main(String[] args) {
		System.out.println("test");
		UserService userService = new UserService();
        UserModel user1 = new UserModel("Ramesh", "ramesh12@gmail.com",              "Daddy@2002","9274909327");

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
        
    }
	
	
	}
  

