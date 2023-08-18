package com.fssa.mgood.model;

public class UserModel {

	private String name;
	private String email;
	private String password;
	private boolean isdoc;

	public UserModel() {
	}

	public UserModel(String name, String email, String password, boolean isdoc) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.isdoc = isdoc;
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

	public boolean getisDoc() {
		return isdoc;
	}

	public void setisDoc(boolean isdoc) {
		this.isdoc = isdoc;
	}
	@Override
	
	public String toString() {
		return "UserModel [name=" + name + ", email=" + email + ", password=" + password + ", isdoc=" + isdoc + "]";
	}
}
