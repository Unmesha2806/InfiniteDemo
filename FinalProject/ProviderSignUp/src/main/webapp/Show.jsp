<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    		 <h:form>
        	<center>
                <h2><h:outputText value="- Show HMS -"/></h2>
            </center>
        <h:dataTable value="#{pImpl.showProviderDao()}" var="d" border="5">
        	           <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Doctor_Id" />
        	           </f:facet>
        	            <h:outputText value="#{d.providerid}"/>
        	           </h:column>
        	           <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Doctor_Name" />
        	           </f:facet>
        	            <h:outputText value="#{d.firstName}"/>
        	           </h:column>
        	           <h:column>
        	           <f:facet name="header">
        	           		<h:outputText value="Department" />
        	           </f:facet>
        	            <h:outputText value="#{d.lastName}"/>
        	           </h:column>
        	           </h:dataTable>
        	   </h:form>        
    </body>
   </html>
   </f:view>