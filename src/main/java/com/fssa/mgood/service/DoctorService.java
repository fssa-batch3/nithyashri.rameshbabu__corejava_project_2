package com.fssa.mgood.service;

import java.util.List;

import com.fssa.mgood.dao.DoctorDAO;
import com.fssa.mgood.dao.exception.DAOException;
import com.fssa.mgood.model.DoctorsModel;
import com.fssa.mgood.service.exception.ServiceException;
import com.fssa.mgood.validation.DoctorValidation;
import com.fssa.mgood.validation.exception.InvalidDoctorException;

public class DoctorService {

	public boolean createDoctor(DoctorsModel doctor) throws ServiceException {
	    DoctorDAO doctorDAO = new DoctorDAO();

	    try {
	        if (!DoctorValidation.validateDoctor(doctor)) {
	            return false;
	        }
	        return doctorDAO.createDoctor(doctor);
	    } catch (DAOException | InvalidDoctorException e) {
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
    
}
