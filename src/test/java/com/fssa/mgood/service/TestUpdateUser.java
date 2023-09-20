package com.fssa.mgood.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.mgood.model.UserModel;
import com.fssa.mgood.service.exception.ServiceException;

class TestUpdateUser {
 @Test
void testUpdateUserSuccess() {
	UserService user = new UserService();

	UserModel user1 = new UserModel();
	try {
		user1.setName("Nithyashri");
		user1.setEmail("nithirm1@gmail.com");
		user1.setPassword("Chennai@007");
		user1.setPhone("9791858933");
		user1.setAddress("No 61 vimal nagar");
		user1.setProfilePic("https://ca.slack-edge.com/T032648LE-U041NKBTPB8-dc85d68b5c37-192");
		assertTrue(user.updateUser(user1));
	} catch (ServiceException e) {
      fail(e.getMessage());
	}
	
}
 void testUpdateUserFailure() {
		UserService user = new UserService();

		UserModel user1 = new UserModel();
		try {
			user1.setName("Nithyashri");
			user1.setEmail("nithirm1@gmail.com");
			user1.setPassword("Chennai@007");
			user1.setPhone("9791858933");
			user1.setAddress("No 61 vimal nagar");
			user1.setProfilePic("https://ca.slack-edge.com/T032648LE-U041NKBTPB8-dc85d68b5c37-192");
			assertFalse(user.updateUser(user1));
		} catch (ServiceException e) {
	      fail(e.getMessage());
		}
		
	}


}
