package com.fssa.mgood.model;

public class AppointmentsModel {

	private String doctorName;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String time;
	private String hospitalName;
	private UserModel user;
	
	public AppointmentsModel() {
	}

	public AppointmentsModel(String doctorName, String userName, String userEmail, String userPhone, String time,
			String hospitalName) {
		this.doctorName = doctorName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.time = time;
		this.hospitalName = hospitalName;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public UserModel getUser() {
		return user;
	}
	
	public void setUser(UserModel user) {
		this.user = user;
	}
	
}
