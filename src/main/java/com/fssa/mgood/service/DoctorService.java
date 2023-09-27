package com.fssa.mgood.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.mgood.dao.DoctorDAO;
import com.fssa.mgood.dao.UserDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.DoctorValidation;
import com.fssa.mgood.validation.UserValidator;
import com.fssa.mgood.validation.exception.InvalidDoctorException;
import com.fssa.mgood.validation.exception.InvalidUserException;

public class DoctorService {

	public boolean createDoctor(DoctorsModel doctor) throws ServiceException {
	    DoctorDAO doctorDAO = new DoctorDAO();

	    try {
			
			 if (!DoctorValidation.validateDoctor(doctor)) { return false; 
			 } 
			   if (doctorDAO.docEmailAlreadyRegistered(doctor.getEmail())) {
		            throw new ServiceException("This email already exists. Try with some other email");
		        }
	        return doctorDAO.createDoctor(doctor);
	    } catch (DAOException | InvalidDoctorException   e) {
	        throw new ServiceException(e.getMessage(), e);
	    }
	}
	
	
	public List<DoctorsModel> doctorViewService() throws ServiceException {
		DoctorDAO doctorDAO = new DoctorDAO();

		try {
			return doctorDAO.viewDoctors();

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
    public boolean docServiceApprove(DoctorsModel doctors) throws ServiceException{
    	DoctorDAO docdao = new DoctorDAO();
    	try {
    		return docdao.doctorConfirmationApproved(doctors);
    	}
    	catch(DAOException e) {
    		throw new ServiceException(e.getMessage(), e);
    	}
    }

    public DoctorsModel loginDoctor(String email, String password) throws ServiceException {
        DoctorDAO doctorDAO = new DoctorDAO();
        try {
            return doctorDAO.loginDoctor(email, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public DoctorsModel findDoctorByEmailService(String email) throws ServiceException {
        try {
            DoctorDAO docdao = new DoctorDAO();
            return docdao.findDoctorByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException("Error in finding doctor by email", e);
        }
    }

    


	/*
	 * public boolean registerDoctor(DoctorsModel doc) throws ServiceException {
	 * DoctorDAO docdao = new DoctorDAO();
	 * 
	 * try { DoctorValidation.validateDoctor(doc);
	 * 
	 * if (docdao.docEmailAlreadyRegistered(doc.getEmail())) { throw new
	 * ServiceException("This email already exists. Try with some other email"); }
	 * if (docdao.createDoctor(doc)) { System.out.println(doc.getEmail() +
	 * " Successfully Register"); return true; } else {
	 * System.out.println("Registration was not Successful"); return false; } }
	 * catch (DAOException | InvalidDoctorException e) { throw new
	 * ServiceException(e.getMessage()); } }
	 */

	
	
	
    
	public boolean updateDoctor(DoctorsModel doctor) throws ServiceException {

		DoctorDAO docDAO = new DoctorDAO();

		try {
			DoctorValidation.validateDoctor(doctor);

			if (docDAO.updateDoctor(doctor)) {
				return true;
			} else {
				throw new ServiceException("Update was not successful");

			}

		} catch (DAOException | InvalidDoctorException e) {
			throw new ServiceException(e.getMessage(),e);
		}

	}
    public boolean isApproved(String email) throws ServiceException {
        DoctorDAO doctorDAO = new DoctorDAO();
        try {
            return doctorDAO.isApproved(email);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    
}
