<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h:form>
		<center>
		<h2>Address Details</h2>
		<br><br>
			<label>PermanentAddress</label>
		<h:inputText id="permanentAddress" value="#{provider.permanentAddress}" />
		<h:message for="form:permanentAddress" styleClass="error-message" style="color:red"></h:message><br><br>
		<br />
		
		
		         	<label>Permanent State</label>
		<h:inputText id="permanentState" value="#{provider.permanentState}" />
		<h:message for="form:permanentState" styleClass="error-message" style="color:red"></h:message><br><br>
		<br />
		
		          
		          	<label> Permanent Postal code</label>
		<h:inputText id="permanentPostalCode" value="#{provider.permanentPostalCode}" />
		<h:message for="form:permanentPostalCode" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 
				
				<label> Permanent City</label>
		<h:inputText id="permanentCity" value="#{provider.permanentCity}" />
		<h:message for="form:permanentCity" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 	
				
				<label>Permanent Country</label>
		<h:inputText id="permanentCountry" value="#{provider.permanentCountry}" />
		<h:message for="form:permanentCountry" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 		
		
		        <label>Country</label>
		<h:inputText id="country" value="#{provider.country}" />
		<h:message for="form:country" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 	
		
		
		         <label>State</label>
		<h:inputText id="state" value="#{provider.state}" />
		<h:message for="form:state" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 
		
		
		          <label>City</label>
		<h:inputText id="city" value="#{provider.city}" />
		<h:message for="form:city" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 		
					
					<label>Postal code</label>
		<h:inputText id="postalCode" value="#{provider.postalCode}" />
		<h:message for="form:postalCode" styleClass="error-message" style="color:red"></h:message><br><br>
		<br /> 
		
		
		                 <label>Country code</label>
		                   <h:selectOneMenu id="countryCode" value="#{provider.countryCode}">
							<f:selectItem itemLabel="Select Country Code" itemValue="" />
							<f:selectItem itemLabel="+1 (USA)" itemValue="+1" />
							<f:selectItem itemLabel="+44 (UK)" itemValue="+44" />
							<f:selectItem itemLabel="+91 (IN)" itemValue="+91" />
							<f:selectItem itemLabel="+33 (FR)" itemValue="+33" />
							<f:selectItem itemLabel="+49 (DE)" itemValue="+49" />
						</h:selectOneMenu>
						<h:message for="form:countryCode" styleClass="error-message"
					style="color:red"></h:message>
				
				  <label>Corresponding Address</label>
				<h:inputTextarea id="address" value="#{provider.address}"/>
				<h:message for="form:address" styleClass="error-message"
					style="color:red"></h:message>
				
	

	<h:commandButton
		action="#{providerController.addProviderValid(provider)}"
		value="Provider Enroll" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<h:commandButton type="reset" value="Reset" />
	<h:messages globalOnly="true" />
		</center>
	</h:form>
</body>
</html>
</f:view>