package com.fssa.mgood.model;

public class UserModel {

	private String name;
	private String email;
	private String phone;
	private String password;
	private String profilePic;
	private String address;
	private int userId;


	public UserModel() {
	}

	public UserModel(String name, String email, String password, String phone) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		
	}
	
	public UserModel(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	 /**
     * Generates a string representation of the UserModel object.
     *
     * @return A string containing the name, email, and phone of the user.
     */

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", profilePic=" + profilePic + ", address=" + address + ", userId=" + userId + "]";
	}

	
}
