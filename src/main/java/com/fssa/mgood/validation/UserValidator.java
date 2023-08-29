package com.fssa.mgood.validation;

import java.util.regex.Matcher;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.validation.exception.InvalidUserException;
import java.util.regex.Pattern;

public class UserValidator {

    public static boolean validateUser(UserModel user) throws InvalidUserException {
    	if(user == null) {
    		throw new InvalidUserException("User deatils cannot be null");
    	}
        if (validateEmail(user.getEmail()) && validatePassword(user.getPassword())
                && validateName(user.getName())) {
            return true;
        } else {
            throw new InvalidUserException("User is Invalid");
        }
    }
    public static boolean validateEmail(String email) throws InvalidUserException {
        boolean isMatch = false;
        if (email == null || email.trim().isEmpty())
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
        if (password == null  || password.trim().isEmpty())
            return false;
        String reg = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
        match = Pattern.matches(reg, password);

        if (match) {
            System.out.println("Valid password.");
        } else {
            throw new InvalidUserException("Invalid password.");
        }

        return match;
    }

    public static boolean validateName(String name) throws InvalidUserException {
        boolean match = false;
        if (name == null  || name.trim().isEmpty())
            return false;
        String regex = "^[A-Za-z]\\w{2,29}$";
        match = Pattern.matches(regex, name);
        if (match) {
            System.out.println("The user name is valid.");
        } else {
            throw new InvalidUserException ("The user name is not valid");
        }
        return match;
    }

}
