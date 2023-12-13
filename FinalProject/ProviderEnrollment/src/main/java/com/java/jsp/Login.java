package com.java.jsp;

import java.io.Serializable;


public class Login implements Serializable {
	private int authId;
	private String providerid;
	private String email;
	private String username;
	private String passcode;
	private String otp;
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getProviderid() {
		return providerid;
	}
	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Login(int authId, String providerid, String email, String username, String passcode, String otp) {
		super();
		this.authId = authId;
		this.providerid = providerid;
		this.email = email;
		this.username = username;
		this.passcode = passcode;
		this.otp = otp;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [authId=" + authId + ", providerid=" + providerid + ", email=" + email + ", username=" + username
				+ ", passcode=" + passcode + ", otp=" + otp + "]";
	}
	
	
	
	}
	
	
	
	
	


