package com.fssa.mgood.model;

public class DoctorsModel {
	private String name;
	private String email;
	private String phone;
	private String password;
	private String bio;
	private String gender;
	private String specialization;
	private String registrationNumber;
	private String registrationCouncil;
	private String registrationYear;
	private String degree;
	private String college;
	private String completionYear;
	private int experience;
	private long aadharNo;
	private String aadharImg;
	private String doctorImg;
	private String clinicalName;
	private String clinicalAddress;
	private String doctorAvailabilityFrom;
	private String doctorAvailabilityEnd;
	private String clinicImg;
	private int consulationFee;
	private String confirmation;
	private int doctorId;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationCouncil() {
		return registrationCouncil;
	}

	public void setRegistrationCouncil(String registrationCouncil) {
		this.registrationCouncil = registrationCouncil;
	}

	public String getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCompletionYear() {
		return completionYear;
	}

	public void setCompletionYear(String completionYear) {
		this.completionYear = completionYear;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getAadharImg() {
		return aadharImg;
	}

	public void setAadharImg(String aadharImg) {
		this.aadharImg = aadharImg;
	}

	public String getDoctorImg() {
		return doctorImg;
	}

	public void setDoctorImg(String doctorImg) {
		this.doctorImg = doctorImg;
	}

	public String getClinicalName() {
		return clinicalName;
	}

	public void setClinicalName(String clinicalName) {
		this.clinicalName = clinicalName;
	}

	public String getClinicalAddress() {
		return clinicalAddress;
	}

	public void setClinicalAddress(String clinicalAddress) {
		this.clinicalAddress = clinicalAddress;
	}

	public String getDoctorAvailabilityFrom() {
		return doctorAvailabilityFrom;
	}

	public void setDoctorAvailabilityFrom(String doctorAvailabilityFrom) {
		this.doctorAvailabilityFrom = doctorAvailabilityFrom;
	}

	public String getDoctorAvailabilityEnd() {
		return doctorAvailabilityEnd;
	}

	public void setDoctorAvailabilityEnd(String doctorAvailabilityEnd) {
		this.doctorAvailabilityEnd = doctorAvailabilityEnd;
	}

	public String getClinicImg() {
		return clinicImg;
	}

	public void setClinicImg(String clinicImg) {
		this.clinicImg = clinicImg;
	}

	public int getConsulationFee() {
		return consulationFee;
	}

	public void setConsulationFee(int consulationFee) {
		this.consulationFee = consulationFee;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "DoctorsModel [name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ ", doctorId=" + doctorId + ", bio=" + bio + ", gender=" + gender + ", specialization="
				+ specialization + ", registrationNumber=" + registrationNumber + ", registrationCouncil="
				+ registrationCouncil + ", registrationYear=" + registrationYear + ", degree=" + degree + ", college="
				+ college + ", completionYear=" + completionYear + ", experience=" + experience + ", aadharNo="
				+ aadharNo + ", aadharImg=" + aadharImg + ", doctorImg=" + doctorImg + ", clinicalName=" + clinicalName
				+ ", clinicalAddress=" + clinicalAddress + ", doctorAvailabilityFrom=" + doctorAvailabilityFrom
				+ ", doctorAvailabilityEnd=" + doctorAvailabilityEnd + ", clinicImg=" + clinicImg + ", consulationFee="
				+ consulationFee + ", confirmation=" + confirmation + "]";
	}

}
