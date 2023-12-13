package com.java.jsp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

public class ProviderController {

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
		
//		System.out.println(daoImpl);
		System.out.println("addProviderValid is Hittingggggggggg");
//		System.out.println("Provider  " + provider);
//		System.out.println(addValid(provider));
		if (addValid(provider)) {
			return daoImpl.addProviderDao(provider);
		}
		System.out.println("No Provider Found");
		return "ghgh";

	}

	public static int calculateDifference(Date startDate, Date endDate) {
		// Create Calendar instances and set the dates
		Calendar startCal = new GregorianCalendar();
		startCal.setTime(startDate);

		Calendar endCal = new GregorianCalendar();
		endCal.setTime(endDate);

		if (startCal.after(endCal)) {
			// Swap the dates if they are in the wrong order
			Calendar temp = startCal;
			startCal = endCal;
			endCal = temp;
		}

		int yearDifference = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);

		// Adjust if end date hasn't reached the same month and day as start date
		if (endCal.get(Calendar.MONTH) < startCal.get(Calendar.MONTH)
				|| (endCal.get(Calendar.MONTH) == startCal.get(Calendar.MONTH)
						&& endCal.get(Calendar.DAY_OF_MONTH) < startCal.get(Calendar.DAY_OF_MONTH))) {
			yearDifference--;
		}

		return yearDifference;
	}

	public boolean addValid(Provider provider) {
		FacesContext context = FacesContext.getCurrentInstance();
		String firstName = "^[A-Za-z\\s]+$";
		String lastName = "^[A-Za-z\\s]+$";
		String userName = "^[^\\s]{8,16}$";
//	    String licenseNumber = "^[A-Z0-9]{8}$";
//		String licenseNumber= "^[A-Z0-9]{8,}$";
//		String licenseNumber = "^[A-Z]{2}\\d{2}(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])((19|20)\\d{2})$";
		String licenseNumber = "^[A-Z0-9]{10}$";
        String qualification = "^[A-Za-z0-9\\s]{1,100}$";
		String speciality = "^[A-Za-z0-9\\s]{1,100}$";
//		String phoneno = "^(\\+91|91|0)?[6789]\\d{9}$";
		String phoneno = "^(\\+\\d{1,4})?\\d{10}$";
		String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//		String password = "^(?=.*[A-Z])(?=.*[a-z0-9])(?=.*[^a-zA-Z0-9]).{8,18}$";
//	    String password = "^(?!.*(?:password1|password2|password3|password4|password5))(?=(.*[A-Z]))(?=(.*[a-z]))(?=(.*\d))(?=(.*[!$#%]))[A-Za-z\d!$#%]{8,}$";
//	    String password = "^(?=(.*[A-Z]){2,3})(?=(.*[a-z]){2,3})(?=(.*\\d){2,3})(?=(.*[!$#%]){2,3})[A-Za-z\\d!$#%]{8,}$";
		String password = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!#$%@]).{8,}$";
        String city="^[A-Za-z]+$";
		String state="^[A-Za-z]+$";
		String country="^[A-Za-z]+$";
		String postalCode = "\\d{5}";
//		String postalCode = "^[0-9]{6}$";
//		String dateFormatRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
//		String dob= provider.getDateOfBirth().toString();

//FIRSTNAME
		boolean flag = true;
		System.out.println("FirstName Length is " + provider.getFirstName().length());
		if (provider.getFirstName().length() <= 0) {
			context.addMessage("form:firstName", new FacesMessage("FirstName Cannot be Empty"));
			System.out.println("FirstName Null Failed");
			flag = false;
		}

		if (!Pattern.matches(firstName, provider.getFirstName())) {
			context.addMessage("form:firstName", new FacesMessage("Invalid FirstName. Only letters are allowed."));
			System.out.println("FirstName Failed");
			flag = false;
		}
//LASTNAME
		if (provider.getLastName().length() <= 0) {
			context.addMessage("form:lastName", new FacesMessage("LastName Cannot Be Empty"));
			System.out.println("LastName Failed");
			flag = false;
		}

		if (!Pattern.matches(lastName, provider.getLastName())) {
			context.addMessage("form:lastName", new FacesMessage("Invalid LastName. Only letters are allowed."));
			System.out.println("LastName Failed");
			flag = false;
		}

		ProviderDAOImpl daoImpl = new ProviderDAOImpl();
//USERNAME			
		if (!Pattern.matches(userName, provider.getUserName())) {
			context.addMessage("form:userName", new FacesMessage("Provider Username Contains min 8 characters"));
			System.out.println("UserName Failed");
			flag = false;
		}

		if (daoImpl.isUsernameExists(provider.getUserName())) {
			context.addMessage("form:userName", new FacesMessage("Provider Username already exists"));
			System.out.println("UserName Already Exists");
			flag = false;
		}

//PASSWORD
//		if (provider.getPassword().length() <= 0) {
//			context.addMessage("form:password", new FacesMessage("Password Cannot be Empty"));
//			System.out.println("Password Null Failed");
//			flag = false;
//		}
		
//		else {
//			if (!Pattern.matches(password, provider.getPassword())) {
//				context.addMessage("form:password", new FacesMessage("Invalid Password format.Hint: @Abcde1234"));
//				System.out.println("Password failed.");
//				flag = false;
//			}

//		if (provider.getPassword().trim().length() < 8) {
//			context.addMessage("form:password", new FacesMessage("Provider Password Contains min 8 characters"));
//			System.out.println("Password failed.");
//			flag = false;
//		}
		
		
		
		
		
		
		// Get the new password from the provider
		
//		String newPassword = provider.getPassword() ;;

		// Check if the password length is less than 8
		
//		if (newPassword.length() < 8) {
//		    context.addMessage("form:password", new FacesMessage("Password must be at least 8 characters "));
//		    System.out.println("Password Length Failed");
//		    flag = false;
//		}

		

		// Check if the password contains at least 3 of the 4 specified types
		
//		int typesCount = 0;
//		if (newPassword.matches(".*[A-Z].*")) {
//		    typesCount++;
//		}
//		if (newPassword.matches(".*[a-z].*")) {
//		    typesCount++;
//		}
//		if (newPassword.matches(".*\\d.*")) {
//		    typesCount++;
//		}
//		if (newPassword.matches(".*[!$#%@].*")) {
//		    typesCount++;
//		}

//		else {
//			if (!Pattern.matches(password, provider.getPassword())) {
		
//		    context.addMessage("form:password", new FacesMessage("Password must contain at least 3 of the following types: Uppercase letters, Lowercase letters, Numbers, Non-Alphanumeric characters (!,$,#,%,@).Eg-(Abcd@123)"));
//		    System.out.println("Password Types Failed");
//		    flag = false;
//		}
//	}

		// If all checks pass, the password is valid
		
		    // Your code to handle a valid password goes here
		
		
		
//		else {
//			if (!Pattern.matches(password, provider.getPassword())) {
 //           context.addMessage("form:password", new FacesMessage(
//						"The password must contain two or three of the four characters.Eg-(Abcd@123) "));
//				System.out.println("The password must contain two or three of the four characters.Eg-(Abcd@123)");
//				flag = false;
//			}
//		}
		
		
		
		
		

		    
 // Assuming that provider.getPassword() returns the actual password
		        String newPassword = provider.getPassword();

// Check if the password is empty
		        if (newPassword == null || newPassword.trim().isEmpty()) {
		            context.addMessage("form:password", new FacesMessage("Password cannot be empty"));
		            System.out.println("Password is empty");
		            flag = false;
		        } else {
		            // Check if the password length is less than 8
		            if (newPassword.length() < 8) {
		                context.addMessage("form:password", new FacesMessage("Password must be at least 8 characters"));
		                System.out.println("Password Length Failed");
		                flag = false;
		            }

 // Check if the password contains at least 3 of the 4 specified types
		            int typesCount = 0;
		            if (newPassword.matches(".*[A-Z].*")) {
		                typesCount++;
		            }
		            if (newPassword.matches(".*[a-z].*")) {
		                typesCount++;
		            }
		            if (newPassword.matches(".*\\d.*")) {
		                typesCount++;
		            }
		            if (newPassword.matches(".*[!$#%@].*")) {
		                typesCount++;
		            }

// Check if at least 3 types are present
		            
		            if (typesCount < 4) {
		                context.addMessage("form:password", new FacesMessage("Password must contain at least 3 of the following types: Uppercase letters, Lowercase letters, Numbers, Non-Alphanumeric characters (!,$,#,%,@). Eg-(Abcd@123)"));
		                System.out.println("Password Types Failed");
		                flag = false;
		            } 
		//            else {
		 //              // Your code to handle a valid password goes here
		  //              System.out.println("Password is valid");
		  //          }
		        }
		        
		        
		    
	

		



//PHONENUMBER
		if (provider.getPhoneno().length() <= 0) {
			context.addMessage("form:phoneno", new FacesMessage("Enter Your Phone Number"));
			System.out.println("PhoneNo Failed");
			flag = false;
		}
		if (!Pattern.matches(phoneno, provider.getPhoneno())) {
			context.addMessage("form:phoneno", new FacesMessage("Invalid Phone Number"));
			System.out.println("PhoneNo Failed");
			flag = false;
		}
		        
		        
		        
//ADDRESS
		if (provider.getAddress().length() <= 0) {
			context.addMessage("form:address", new FacesMessage("Please Enter Your Address"));
			System.out.println("Enter Your Address");
			flag = false;
		}

//CITY
		if (provider.getCity().length() <= 0) {
			context.addMessage("form:city", new FacesMessage("Please Enter Your City"));
			System.out.println("City Failed");
			flag = false;
		}
		
		if (!Pattern.matches(city, provider.getCity())) {
			context.addMessage("form:city", new FacesMessage("Invalid City. Only letters are allowed."));
			System.out.println("City Failed");
			flag = false;
		}

//STATE
		if (provider.getState().length() <= 0) {
			context.addMessage("form:state", new FacesMessage("Please Enter Your State"));
			System.out.println("State Failed");
			flag = false;
		}
		
		if (!Pattern.matches(state, provider.getState())) {
			context.addMessage("form:state", new FacesMessage("Invalid State. Only letters are allowed."));
			System.out.println("State Failed");
			flag = false;
		}

//COUNTRY
		if (provider.getCountry().length() <= 0) {
			context.addMessage("form:country", new FacesMessage("Please Enter Your Country"));
			System.out.println("Country failed");
			flag = false;

		}
		
		if (!Pattern.matches(country, provider.getCountry())) {
			context.addMessage("form:country", new FacesMessage("Invalid Country. Only letters are allowed."));
			System.out.println("Country Failed");
			flag = false;
		}

// POSTAL CODE
		if (provider.getPostalCode().length() <= 0) {
			context.addMessage("form:postalCode", new FacesMessage("Postal Code cannot be empty"));
			System.out.println("Postal Code Failed");
			flag = false;
		}
		if (!Pattern.matches(postalCode, provider.getPostalCode())) {
			context.addMessage("form:postalCode", new FacesMessage("Invalid Postal Code. Enter a valid 5-digit code."));
			System.out.println("Postal Code Failed");
			flag = false;
		}

//PERMANENT ADDRESS
//				if (provider.getPermanentAddress().length() <= 0) {
//					context.addMessage("form:permanentAddress", new FacesMessage("Please Enter Your Address"));
//					System.out.println("permanentaddress failed");
//					flag = false;
//				}
//PERMANENT COUNTRY
//				if (provider.getPermanentCountry().length() <= 0) {
//					context.addMessage("form:permanentCountry", new FacesMessage("Please Enter your Country"));
//					System.out.println("permanentCountry failed");
//					flag = false;
//				}

//PERMANENT STATE
//				if (provider.getPermanentState().length() <= 0) {
//					context.addMessage("form:permanentState", new FacesMessage("Please Enter your State"));
//					System.out.println("permanentState failed");
//					flag = false;
//				}

//PERMANENT CITY
//				if (provider.getPermanentCity().length() <= 0) {
//					context.addMessage("form:permanentCity", new FacesMessage("Please Enter your City"));
//					System.out.println("permanentCity failed");
//					flag = false;
//				}

//PERMANENT POSTALCODE

//				if (provider.getPermanentPostalCode().length() <= 0) {
//					context.addMessage("form:permanentPostalCode", new FacesMessage("Please Enter your Postalcode"));
//					System.out.println("Postalcode failed");
//					flag = false;
//				}
//				if (!Pattern.matches(postalCode, provider.getPermanentPostalCode())) {
//					context.addMessage("form:permanentPostalCode", new FacesMessage("Please Enter Valid PostalCode"));
//					System.out.println("permanentPostalCode id failed of pattern matching");
//					flag = false;
//				}

//LicenseNumber				
//	if (provider.getLicenseNumber() == null || provider.getLicenseNumber().isEmpty()) {
//		context.addMessage("form:licenseNumber", new FacesMessage("License Number Cannot Be Empty"));
//			System.out.println("License Number Failed");
//			flag = false;
//		}

//		else if (!Pattern.matches(licenseNumber, provider.getLicenseNumber())) {
//			context.addMessage("form:licenseNumber", new FacesMessage(
//					"Invalid License Number.It should be  10 characters  and contain only uppercase letters and digits"));
//			System.out.println("License Number Failed"); 
//			flag = false;
//		}
	
		
//LicenseNumber			
			if (!Pattern.matches(licenseNumber, provider.getLicenseNumber())) {
				context.addMessage("form:licenseNumber", new FacesMessage("Invalid License Number.It should be  10 characters  and contains only uppercase letters and digits"));
				System.out.println("License Number Failed");
				flag = false;
			}
			if (daoImpl.isLicenseNumberExists(provider.getLicenseNumber())) {
		        context.addMessage("form:licenseNumber", new FacesMessage("License Number already exists. Please choose a different license number."));
		        System.out.println("License Number Already Exists");
		        return false;
		    }
			

//Qualification				
		if (provider.getQualification() == null || provider.getQualification().isEmpty()) {
			context.addMessage("form:qualification", new FacesMessage("Qualification Cannot Be Empty"));
			System.out.println("Qualification Failed");
			flag = false;
		} else if (!Pattern.matches(qualification, provider.getQualification())) {
			context.addMessage("form:qualification", new FacesMessage(
					"Invalid Qualification. It should be 1 to 100 characters long and may contain letters, digits, and spaces"));
			System.out.println("Qualification Failed");
			flag = false;
		}
		
//Specialty				
		if (provider.getSpeciality() == null || provider.getSpeciality().isEmpty()) {
			context.addMessage("form:speciality", new FacesMessage("Speciality Cannot Be Empty"));
			System.out.println("Speciality Failed");
			flag = false;
		} else if (!Pattern.matches(speciality, provider.getSpeciality())) {
			context.addMessage("form:speciality", new FacesMessage(
					"Invalid Speciality. It should be 1 to 100 characters long and may contain letters, digits, and spaces"));
			System.out.println("Speciality Failed");
			flag = false;
		}

//GENDER
		if (provider.getGender() == null || provider.getGender().isEmpty()) {
			context.addMessage("form:gender", new FacesMessage("Select Gender"));
			System.out.println("Select Gender Failed");
			flag = false;
		}

		

//DateOfBirth

		if (provider.getDateOfBirth() == null) {
			context.addMessage("form:dateOfBirth", new FacesMessage("Enter Your Date Of Birth"));
			System.out.println("DateOfBirth Failed");

			flag = false;
		} else {
			LocalDate currentDate = LocalDate.now();
			LocalDate birthDate = provider.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			// Check if the birth year is after 2001
			int datecalc = calculateDifference(new Date(), provider.getDateOfBirth());
			if (datecalc <= 20) {
				System.out.println(datecalc);
				context.addMessage("form:dateOfBirth",new FacesMessage("Date of Birth should be greater than 20 yrs"));
				System.out.println("DateOfBirth Failed");
				flag = false;
			}
		}

//GMAIL
		if (provider.getEmail().length() <= 0) {
			context.addMessage("form:email", new FacesMessage("Email Cannot Be Empty"));
			System.out.println("Email Failed");
			flag = false;
		} 

			if (!Pattern.matches(email, provider.getEmail())) {
				context.addMessage("form:email",new FacesMessage("The entered email address format is incorrect .Eg - (abc123@gmail.com)"));
			    System.out.println("Email Failed");
				flag = false;
			}

		

//SecurityQuestion

		if (provider.getSecurityQuestion() == null || provider.getSecurityQuestion().isEmpty()) {
			context.addMessage("form:securityQuestion", new FacesMessage("Select SecurityQuestion"));
			System.out.println("Select Securityquestion Failed");
			flag = false;

		}

//SecurityAnswer
		if (provider.getSecurityAnswer().length() <= 0) {
			context.addMessage("form:securityAnswer", new FacesMessage("Please Enter Your SecurityAnswer"));
			System.out.println("Enter Your SecurityAnswer ");
			flag = false;
		}

		return flag;

	}

//reset
	
	public void clear() throws IOException {
		System.out.println("Reset");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("daoImpl", null);

		ExternalContext ex = FacesContext.getCurrentInstance().getExternalContext();
		ex.redirect(((HttpServletRequest) ex.getRequest()).getRequestURI());
	}



}



