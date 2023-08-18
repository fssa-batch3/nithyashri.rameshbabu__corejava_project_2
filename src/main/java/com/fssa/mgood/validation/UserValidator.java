package com.fssa.mgood.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(UserModel user) throws InvalidUserException {
		if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())
				&& validateName(user.getName()) && validateisDoc(user.getisDoc())) {
			return true;
		} else {
			throw new InvalidUserException("User is Invalid");
              
		}
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null)
			return false;

		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			throw new InvalidUserException("The email address is: Invalid");
		}
		return isMatch;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		if (password == null)
			return false;
		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {

			System.out.println("Valid password.");
		} else {
			throw new InvalidUserException("Invalid password.");

		}

		return match;
	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		if (name == null)
			return false;
		String regex = "^[A-Za-z]\\w{2,29}$";
		match = Pattern.matches(regex, name);
		if (match) {

			System.out.println("The user name is valid.");
		} else {
			throw new InvalidUserException("The user name is not valid");
		}

		return match;
	}

	public static boolean validateisDoc(Boolean isDoc) throws InvalidUserException {
		if (isDoc != null) {
			System.out.println("You have entered a boolean isDoc");

			return true;
		} else {
			throw new InvalidUserException("You have not entered a boolean isDoc");
		}
	}

}
