package com.java.jsp;

import java.util.Date;



public class Provider {
	
	private String providerid;
	private String firstName;
	private String lastName;
    private Date dateOfBirth;
    private String email;
    private String licenseNumber;
    private String qualification;
    private String userName;
    private String status;
    private String phoneno;
    private String gender;
    private String speciality;
    private String address;
    private String isActive;
    private String comments;
	public String getProviderid() {
		return providerid;
	}
	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Provider(String providerid, String firstName, String lastName, Date dateOfBirth, String email,
			String licenseNumber, String qualification, String userName, String status, String phoneno, String gender,
			String speciality, String address, String isActive, String comments) {
		super();
		this.providerid = providerid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.qualification = qualification;
		this.userName = userName;
		this.status = status;
		this.phoneno = phoneno;
		this.gender = gender;
		this.speciality = speciality;
		this.address = address;
		this.isActive = isActive;
		this.comments = comments;
	}
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Provider [providerid=" + providerid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", licenseNumber=" + licenseNumber
				+ ", qualification=" + qualification + ", userName=" + userName + ", status=" + status + ", phoneno="
				+ phoneno + ", gender=" + gender + ", speciality=" + speciality + ", address=" + address + ", isActive="
				+ isActive + ", comments=" + comments + "]";
	}
    
    
    
    
	
}
