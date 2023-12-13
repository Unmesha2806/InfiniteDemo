package com.java.jsp;

import java.io.Serializable;

public class Login implements Serializable {
	private int authId;
	private String providerid;
	private String email;
	private String username;
	private String password;
	private String status;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Login(int authId, String providerid, String email, String username, String password, String status,
			String otp) {
		super();
		this.authId = authId;
		this.providerid = providerid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
		this.otp = otp;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [authId=" + authId + ", providerid=" + providerid + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", status=" + status + ", otp=" + otp + "]";
	}
	
	
	
	
	

}
