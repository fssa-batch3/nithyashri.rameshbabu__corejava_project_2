package com.fssa.mgood.validation;

import java.util.regex.Pattern;



import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.validation.exception.InvalidUserException;

public class UserValidator {

	/**
	 * Validates a UserModel object by checking its email, password, and name.
	 *
	 * @param user The UserModel to validate.
	 * @return true if the user is valid; otherwise, false.
	 * @throws InvalidUserException If the user is invalid, this exception is thrown
	 *                              with an error message.
	 */

	public static boolean validateUser(UserModel user) throws InvalidUserException {
		if (user == null) {
			throw new InvalidUserException("User deatils cannot be null");
		}
		if (!validateEmail(user.getEmail()) || !validatePassword(user.getPassword()) || !validateName(user.getName()) || !validateMobileNo(user.getPhone())) {
			throw new InvalidUserException("Invalid format. Please avoid spaces.");
		}
		return true;
	}

	/**
	 * Validates an email address.
	 *
	 * @param email The email address to validate.
	 * @return true if the email address is valid; otherwise, false.
	 * @throws InvalidUserException If the email address is invalid, this exception
	 *                              is thrown with an error message.
	 */

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null || email.trim().isEmpty())
			return false;

		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The email address is: Invalid");
		}

	}

	/**
	 * Validates a password.
	 *
	 * @param password The password to validate.
	 * @return true if the password is valid; otherwise, false.
	 * @throws InvalidUserException If the password is invalid, this exception is
	 *                              thrown with an error message.
	 */

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null || password.trim().isEmpty())
			return false;
		String reg = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(reg, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException(
					"Invalid password. The password should follow the pattern like 'Abdul@007'."
					);
		}

	}

	/**
	 * Validates a user's name.
	 *
	 * @param name The name to validate.
	 * @return true if the name is valid; otherwise, false.
	 * @throws InvalidUserException If the name is invalid, this exception is thrown
	 *                              with an error message.
	 */

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		if (name == null || name.trim().isEmpty())
			return false;
		String regex = "^[A-Za-z]\\w{2,29}$";
		match = Pattern.matches(regex, name);
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("The user name is not valid");
		}

	}
	
	/**
	 * Validates a phone number.
	 *
	 * @param name The phone number to validate.
	 * @return true if the number is valid; otherwise, false.
	 * @throws InvalidUserException If the number is invalid, this exception is thrown
	 *                              with an error message.
	 */

	public static boolean validateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null || mobileno.trim().isEmpty()) {
			return false;
		}

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("Invalid mobile number format. Enter your mobile number like this: 6374449092.");

		}

	}

}
