package com.nik.ncompany.domain;

public class Employee {
	
	private int empId;
	private String fName,lName,email,phoneNumber;
	
	public Employee(String fName, String lName, String email, String phoneNumber) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
