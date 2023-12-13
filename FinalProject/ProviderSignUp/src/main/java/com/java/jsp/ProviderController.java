package com.java.jsp;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class ProviderController {

	SessionFactory sf;
	Session session;

	private ProviderDAOImpl daoImpl;
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderDAOImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(ProviderDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public String addProviderValid(Provider provider) {
		 
		System.out.println(provider);
		System.out.println(daoImpl);
		System.out.println("addProviderValid is Hittingggggggggg");
		System.out.println(addValid(provider));
		if (addValid(provider)) {
			return daoImpl.addProviderDao(provider);
		}
		return "";

	}

	

	public boolean addValid(Provider provider) {
		FacesContext context = FacesContext.getCurrentInstance();
		String firstName = "^[A-Za-z\\s]+$";
		String lastName = "^[A-Za-z\\s]+$";
		String userName = "^[^\\s]{8,10}$";
		String phoneno = "^(\\+91|91|0)?[6789]\\d{9}$";
		String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

		

		if (!Pattern.matches(userName, provider.getUserName())) {
			context.addMessage("form:userName", new FacesMessage("Provider Username Contains min 8 characters"));
			System.out.println("UserName Failed...");
			return false;
		}
		if (!Pattern.matches(firstName, provider.getFirstName())) {
			context.addMessage("form:firstName", new FacesMessage("Invalid FirstName. Only letters are allowed."));
			System.out.println("FirstName Failed...");
			return false;
		}
		
		if (!Pattern.matches(lastName, provider.getLastName())) {
			context.addMessage("form:lastName", new FacesMessage("Invalid LastName. Only letters are allowed."));
			System.out.println("LastName Failed...");
			return false;
		}
		if (!Pattern.matches(phoneno, provider.getPhoneno())) {
			context.addMessage("form:phoneno", new FacesMessage("Invalid Phone Number."));
			System.out.println("PhoneNo Failed...");
			return false;
		}
		if (!Pattern.matches(email, provider.getEmail())) {
			context.addMessage("form:email", new FacesMessage("Invalid Email."));
			System.out.println("Email Failed...");
			return false;
		}
		return true;
	}
}