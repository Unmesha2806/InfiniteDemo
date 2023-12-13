package com.java.jsp;

import java.util.Date;

import java.util.regex.Pattern;


public class Dummy {
	public static void main(String[] args) {
		String password = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!#$%]).{8,}$";
		ProviderDAOImpl dao= new ProviderDAOImpl();
		System.out.println(
				(Pattern.matches(password,"12345678Asd#")));
	}
}
