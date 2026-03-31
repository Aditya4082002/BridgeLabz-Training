package com.healthclinicapp.model;


//patient class
public class Patient {
	//attributes
	private int patientId;
	private String name;
	private String phone;
	private String bloodGroup;
	private String dob;
	private String email;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//constructor
	public Patient(String name, String phone, String bloodGroup, String dob,String email,String address) {
		this.name = name;
		this.phone = phone;
		this.bloodGroup = bloodGroup;
		this.dob = dob;
		this.email = email;
		this.address = address;
	}

	//getters setters
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	
}

