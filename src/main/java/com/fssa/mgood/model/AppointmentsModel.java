package com.fssa.mgood.model;

public class AppointmentsModel {
	
	private String time;
	private UserModel user;
	private String slotdate;
	private String  status;
	private String forWhom;
	private int appointmentId;
	private DoctorsModel doctor;

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getForWhom() {
		return forWhom;
	}


	public void setForWhom(String forWhom) {
		this.forWhom = forWhom;
	}


	public AppointmentsModel() {
	}

  	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}






	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;

	}
	
	public String getSlotdate() {
		return slotdate;
	}


	public void setSlotdate(String slotdate) {
		this.slotdate = slotdate;
	}


	public DoctorsModel getDoctor() {
		return doctor;
	}


	public void setDoctor(DoctorsModel doctor) {
		this.doctor = doctor;
	}
	
	
	@Override
	public String toString() {
	    StringBuilder stringBuilder = new StringBuilder("AppointmentsModel [time=")
	        .append(time)
	        .append(", slotdate=")
	        .append(slotdate)
	        .append(", appointmentId=")
	        .append(appointmentId)
	        .append(", status=")
	        .append(status)
	        .append(", forWhom=")
	        .append(forWhom);

	    if (user != null) {
	        stringBuilder.append(", user=")
	            .append(user.toString());
	    } else {
	        stringBuilder.append(", user=null");
	    }

	    if (doctor != null) {
	        stringBuilder.append(", doctor=")
	            .append(doctor.toString());
	    } else {
	        stringBuilder.append(", doctor=null");
	    }

	    return stringBuilder.append("]").toString();
	}



}
