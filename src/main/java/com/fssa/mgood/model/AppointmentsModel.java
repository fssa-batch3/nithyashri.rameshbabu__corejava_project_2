package com.fssa.mgood.model;

public class AppointmentsModel {

	private String doctorName;
	private String time;
	private String hospitalName;
	private UserModel user;
	private int appointmentId;

	public AppointmentsModel() {
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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


	@Override
	public String toString() {
		return "AppointmentsModel [doctorName=" + doctorName + ", time=" + time + ", hospitalName=" + hospitalName
				+  ", appointmentId=" + appointmentId +", user=" + user.toString() + "]";
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;

	}

}
