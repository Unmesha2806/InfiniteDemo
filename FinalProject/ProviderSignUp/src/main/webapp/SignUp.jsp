<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>

	<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h:form>
			<h2>Add Provider</h2>
			
	
		
			<label>First Name</label>
			<h:inputText id="firstName" value="#{provider.firstName}" />
			<br />
			<br />
			 <h:message for="form:firstName"></h:message>

			<label>Last Name</label>
			<h:inputText id="lastName" value="#{provider.lastName}" />
			<br />
			<br />
			 <h:message for="form:lastName"></h:message>

			<label>Date of Birth</label>
			<h:inputText id="dateOfBirth" value="#{provider.dateOfBirth}">
			<f:convertDateTime pattern="yyyy-MM-dd" />
			</h:inputText>
			<br />
			<br />

			<label>Email</label>
			<h:inputText id="email" value="#{provider.email}" />
			<br />
			<br />
			 <h:message for="form:email"></h:message>

			<label>License Number</label>
			<h:inputText id="licenseNumber" value="#{provider.licenseNumber}" />
			<br />
			<br />

			<label>Qualification</label>
			<h:inputText id="qualification" value="#{provider.qualification}" />
			<br />
			<br />

			<label>User Name</label>
			<h:inputText id="userName" value="#{provider.userName}" />
			<br />
			<br />
			 <h:message for="form:userName" /><br/>

			<label>Phone Number</label>
			<h:inputText id="phoneno" value="#{provider.phoneno}" />
			<br />
			<br />
			<h:message for="form:phoneno"></h:message>

			<label>Gender:</label>
			<h:selectOneMenu id="gender" value="#{provider.gender}">
				<f:selectItem itemLabel="Select Gender" />
				<f:selectItem itemLabel="MALE" itemValue="MALE" />
				<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
			</h:selectOneMenu>

			<label>Specialty</label>
			<h:inputText id="speciality" value="#{provider.speciality}" />
			<br />
			<br />

			<label>Address</label>
			<h:inputText id="address" value="#{provider.address}" />
			<br />
			<br />

			<label>Is Active</label>
			<h:inputText id="isActive" value="#{provider.isActive}" />
			<br />
			<br />
			
			
			<label>Comments</label>
			<h:inputText id="comments" value="#{provider.comments}" />
			<br />
			<br />
			 
           <h:commandButton action="#{providerController.addProviderValid(provider)}" value="Provider Enroll" />
	       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       <input type="reset" value="Reset">
		
		
		</h:form>
	</body>
	</html>
</f:view>










