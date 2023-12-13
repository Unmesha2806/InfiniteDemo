<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>

	<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
  <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	
<style>
.required::after {
	content: " * ";
	color: red;
	font-size: 20px;
}

.ui-datepicker {
	font-size: 14px;
}

.ui-datepicker-header {
	background-color: #333;
	color: #fff;
}

.ui-datepicker-calendar {
	background-color: #fff;
}

.ui-datepicker-calendar a {
	color: #333;
}

.ui-datepicker-calendar a:hover {
	background-color: #ddd;
}

.ui-datepicker-year, .ui-datepicker-month {
	color: #333;
}

.inputs {
	padding: 5px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 130%;
	width: 100%;
}

.inputs2 {
	padding: 5px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	font-size: 130%;
	width: 100%;
}

body {
	font-family: 'Arial', sans-serif;
	margin: 0;
	padding: 10px;
	background-image: url(healthcare_image.png);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
}

.custom-button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 20px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 30px;
	cursor: pointer;
	border-radius: 4px;
}

/* .container {
	margin: 0 auto;
	width: 50%;
	background-color: rgba(255, 255, 255, 0.8);
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
	
} */
label {
	font-size: 150%;
	align-content: left;
}

.container1 {
	font-size: 18px;
	margin-left: 0px;
	width: 40%;
	height: auto;
	background-color: rgba(255, 255, 255, 0.8);
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
	margin-left: 0px;
}

.container2 {
	font-size: 18px;
	margin-left: 8px;
	width: 40%;
	height: auto;
	background-color: rgba(255, 255, 255, 0.5);
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.datepicker {
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
}

.error-message {
	color: red;
}
</style>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(document).ready(function () {
    $(".datepicker").datepicker({
        dateFormat: 'yy-mm-dd',
        changeMonth: true,
        changeYear: true,
        yearRange: "1960:2037"
    });
});
	function updateQualificationDropdown() {
		var specialtyDropdown = document.getElementById("form:speciality");
		var qualificationDropdown = document
				.getElementById("form:qualification");

		// Clear existing options
		qualificationDropdown.innerHTML = "";

		// Get the selected value from the Specialty dropdown
		var selectedSpecialty = specialtyDropdown.value;

		// Add options to the Qualification dropdown based on the selected Specialty
		if (selectedSpecialty === "Cardiologist") {
			addOption(qualificationDropdown, "MBBS", "MBBS");
			addOption(qualificationDropdown, "MD", "MD");
		} else if (selectedSpecialty === "Nursing") {
			addOption(qualificationDropdown, "BSN", "BSN");
		} else if (selectedSpecialty === "General Physician"
				|| selectedSpecialty === "Neurologist"
				|| selectedSpecialty === "Psychologist") {
			addOption(qualificationDropdown, "MBBS", "MBBS");
			addOption(qualificationDropdown, "MD", "MD");
		} else if (selectedSpecialty === "Urologist") {
			addOption(qualificationDropdown, "MBBS", "MBBS");
			addOption(qualificationDropdown, "MD", "MD");
			addOption(qualificationDropdown, "MS", "MS");
		} else if (selectedSpecialty === "Dentist") {
			addOption(qualificationDropdown, "BDS", "BDS");
		} else if (selectedSpecialty === "Pshychologist") {
			addOption(qualificationDropdown, "MBBS", "MBBS");
			addOption(qualificationDropdown, "MD", "MD");
			addOption(qualificationDropdown, "MS", "MS");

		} else {
			// Add default options if no specific options for the selected Specialty
			addOption(qualificationDropdown, "Select Qualification", "");
		}
	}

	// Initialize the Qualification dropdown based on the default selection in the Specialty dropdown
	updateQualificationDropdown();

	// Function to add options to a dropdown
	function addOption(selectElement, value, text) {
		var option = document.createElement("option");
		option.value = value;
		option.text = text;
		selectElement.add(option);
	}

	$(document).ready(function () {
        $(".datepicker").datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            yearRange: "1960:2037"
        });
    });
<%-- function togglePasswordVisibility() {
        var passwordInput = document.getElementById('password');
        var checkbox = document.getElementById('togglePassword');
        var eyeImage = document.querySelector('label[for="togglePassword"] img');

        if (passwordInput.type === 'password') {
            passwordInput.type = 'text';
            eyeImage.src = 'eye-slash.svg'; // Replace with the path to your eye-slash image
        } else {
            passwordInput.type = 'password';
            eyeImage.src = 'eye.svg'; // Replace with the path to your eye image
        }
    }--%>
	function togglePasswordVisibility() {
		var passwordInput = document.getElementById("form:password");
		var toggleButton = document.getElementById("togglePassword");
		var eyeImage = document
				.querySelector("label[for='togglePassword'] img");

		if (passwordInput.type === "password") {
			passwordInput.type = "text";
			eyeImage.src = "eye-slash.svg";

		} else {
			passwordInput.type = "password";
			eyeImage.src = "eye.svg";

		}
	}
<%-- $(document).ready(function() {
	        $('.password-toggle-icons').on('click', function() {
	            var passInput = $("#password");
	            var showPassIcon = $("#hide1");
	            var showPassSlashIcon = $("#hide2");

	            if (passInput.attr('type') === 'password') {
	                passInput.attr('type', 'text');
	                showPassIcon.hide();
	                showPassSlashIcon.show();
	            } else {
	                passInput.attr('type', 'password');
	                showPassIcon.show();
	                showPassSlashIcon.hide();
	            }
	        });
	    });  --%>
	
</script>
</head>
<body>
	<h:form id="form">
		<div style="margin-left: 40%; font-size: 30px;">
			<h1>Provider Enrollment</h1>
		</div>
		<div style="display: flex">
			<div class="container1">
				<div>
					<label class="required">First Name</label>
					<h:inputText styleClass="inputs" id="firstName"
						value="#{provider.firstName}" />
					<br />
					<h:message for="form:firstName" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">Last Name</label> &nbsp;
					<h:inputText styleClass="inputs" id="lastName"
						value="#{provider.lastName}" />
					<br />
					<h:message for="form:lastName" styleClass="error-message"
						style="color:red"></h:message>
				</div>

				<div>
					<label class="required">Gender</label> <br />
					<h:selectOneRadio styleClass="inputs" id="gender"
						style="font-size:15px;" value="#{provider.gender}">
						<f:selectItem itemLabel="MALE" itemValue="MALE" />
						<f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
						<f:selectItem itemLabel="OTHERS" itemValue="OTHERS" />
					</h:selectOneRadio>
					<br />
					<h:message for="form:gender" styleClass="error-message"
						style="color:red"></h:message>
				</div>




				<div>
                <label class="required">Date of Birth</label> &nbsp;
                <h:inputText id="dateOfBirth" value="#{provider.dateOfBirth}" styleClass="inputs form-control datepicker">
                    <f:convertDateTime pattern="yyyy-MM-dd" />
                </h:inputText>
                <br>
                <h:message for="form:dateOfBirth" styleClass="error-message" style="color:red" />
            </div>
				<div>
					<label class="required">Phone Number</label> &nbsp;
					<h:inputText styleClass="inputs" id="phoneno"
						value="#{provider.phoneno}" maxlength="10" />
					<br>
					<h:message for="form:phoneno" styleClass="error-message"
						style="color:red"></h:message>
				</div>

				<div>

					<label class="required">License Number</label> &nbsp;
					<h:inputText styleClass="inputs" id="licenseNumber"
						value="#{provider.licenseNumber}" maxlength="10" />
					<br>
					<h:message for="form:licenseNumber" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">Specialty</label> &nbsp;
					<h:selectOneMenu styleClass="inputs" id="speciality"
						value="#{provider.speciality}"
						onchange="updateQualificationDropdown()">
						<f:selectItem itemLabel="Select Specialty" />
						<f:selectItem itemLabel="Nursing" itemValue="Nursing" />
						<f:selectItem itemLabel="Dentist" itemValue="Dentist" />
						<f:selectItem itemLabel="Cardiologist" itemValue="Cardiologist" />
						<f:selectItem itemLabel="General Physician" itemValue="General Physician" />
						<f:selectItem itemLabel="Neurologist" itemValue="Neurologist" />
						<f:selectItem itemLabel="Urologist" itemValue="Urologist" />
						<f:selectItem itemLabel="Pshychologist" itemValue="Pshychologist" />
					</h:selectOneMenu>
					<br>
					<br>
					<h:message for="form:speciality" styleClass="error-message"
						style="color:red"></h:message>
				</div>

				<div>
					<label class="required">Qualification</label> &nbsp;
					<h:selectOneMenu styleClass="inputs" id="qualification"
						value="#{provider.qualification}">
						<f:selectItem itemLabel="Select Qualification" />
						<f:selectItem itemLabel="BSN" itemValue="BSN" />
						<f:selectItem itemLabel="BDS" itemValue="BDS" />
						<f:selectItem itemLabel="MBBS" itemValue="MBBS" />
						<f:selectItem itemLabel="MD" itemValue="MD" />
					</h:selectOneMenu>
					<br>
					<br>
					<h:message for="form:qualification" styleClass="error-message"
						style="color:red"></h:message>
				</div>
			</div>
			<div class="container2">
				<div>
					<label class="required">Email</label> &nbsp;
					<h:inputText styleClass="inputs" id="email"
						value="#{provider.email}" />
					<br />
					<h:message for="form:email" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<br /> <br /> <label class="required">User Name</label> &nbsp;
					<h:inputText styleClass="inputs" id="userName"
						value="#{provider.userName}" />
					<br />
					<h:message for="form:userName" styleClass="error-message"
						style="color:red" />
				</div>
				<div>

					<br /> <br /> <label class="required">Password</label>
					<p>
						minimum of 8 characters <br>must contain at least 3 of the 4
						following types<br /> Uppercase letters<br /> Lowercase letters<br />
						Numbers<br /> Non-Alphanumeric(!,$,# or %)
					</p>
					<div style="position: relative;">

						<h:inputSecret styleClass="inputs2" id="password"
							value="#{provider.password}" />
						<label for="togglePassword"> <img src="eye.svg"
							alt="Toggle Password Visibility" width="20" height="20"
							onclick="togglePasswordVisibility()"
							style="cursor: pointer; position: absolute; right: 17px; top: 50%; transform: translateY(-50%);">
						</label> <br />
					</div>
					<h:message for="form:password" styleClass="error-message"
						style="color:red"></h:message>
					<div style="font-size: 18px; font-family: monospace;"></div>
				</div>




				<div>
					<label class="required">SecurityQuestion</label> &nbsp;
					<h:selectOneMenu styleClass="inputs" id="securityQuestion"
						value="#{provider.securityQuestion}">
						<f:selectItem itemLabel="Select Question" />
						<f:selectItem itemLabel="What city were you born in?"
							itemValue="What city were you born in?" />
						<f:selectItem itemLabel="What was the first concert you attended?"
							itemValue="What was the first concert you attended?" />
						<f:selectItem itemLabel="What is your oldest sibling’s middle name?"
							itemValue="What is your oldest sibling’s middle name?" />
						<f:selectItem itemLabel="In what city or town did your parents meet?"
							itemValue="In what city or town did your parents meet?"/>
						<f:selectItem itemLabel="What was your favorite elementary school teacher’s name?"
							itemValue="What was your favorite elementary school teacher’s name?"/>
						</h:selectOneMenu>
					<br>
					<h:message for="form:securityQuestion" styleClass="error-message"
						style="color:red" />
				</div>

				<div>
					<label class="required">SecurityAnswer</label> &nbsp;
					<h:inputText styleClass="inputs" id="securityAnswer"
						value="#{provider.securityAnswer}" />
					<br>
					<h:message for="form:securityAnswer" styleClass="error-message"
						style="color:red"></h:message>
				</div>

			</div>
			<div class="container2">
				<div style="font-size: 20px; color: #b3b3b3; margin-left: 10px">*Address
					Details*</div>

				<div>
					<br /> <label class="required">Address</label> &nbsp;
					<h:inputText styleClass="inputs" id="address"
						value="#{provider.address}" />
					<br>
					<h:message for="form:address" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">City</label> &nbsp;
					<h:inputText styleClass="inputs" id="city" value="#{provider.city}" />
					<br>
					<h:message for="form:city" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">State</label> &nbsp;
					<h:inputText styleClass="inputs" id="state"
						value="#{provider.state}" />
					<br>
					<h:message for="form:state" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">Country</label> &nbsp;
					<h:inputText styleClass="inputs" id="country"
						value="#{provider.country}" />
					<br>
					<h:message for="form:country" styleClass="error-message"
						style="color:red"></h:message>
				</div>
				<div>
					<label class="required">Postal code</label> &nbsp;
					<h:inputText styleClass="inputs" id="postalCode"
						value="#{provider.postalCode}" />
					<br>
					<h:message for="form:postalCode" styleClass="error-message"
						style="color:red"></h:message>
				</div>
			</div>
		</div>
		<div style="margin-left: 40%;">
			<br /> <br />
			<h:commandButton styleClass="custom-button"
				action="#{providerController.addProviderValid(provider)}"
				value="Provider Enroll" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<%--  <h:commandButton  style="background-color: red;" type="reset" value="Reset" /> --%>
			<h:commandButton action="#{providerController.clear()}" value="Reset"
				styleClass="custom-button" style="background-color: red;" />

			<%-- <h:commandButton styleClass="custom-button"
			
				style="background-color: red;" type="reset" value="Reset" /> --%>
		</div>
	</h:form>

</body>
	</html>
</f:view>