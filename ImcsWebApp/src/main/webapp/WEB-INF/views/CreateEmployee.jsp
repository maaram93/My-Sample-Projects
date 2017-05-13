<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
.error {
	color: #ff0000;
}

.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Page</title>
</head>
<body>
<form:form action="createEmployee" commandName="employee" method="post">
		<form:errors path="*" cssClass="errorblock" element="div"/>
	
		<%
			if(request.getAttribute("EmployeeData") != null) {
		%>	
			Saved Successfully!!	
		
		<% } %>
	
	    <table>
	    	<tr>
	    		<td><spring:message code="Employee.FirstName.lbl"/>: </td> 
	    		<td><form:input path="firstname" /></td>
	    		<td><form:errors path="firstname" /></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="Employee.LastName.lbl"/>: </td> 
	    		<td><form:input path="lastname" /></td>
	    		<td><form:errors path="lastname" cssClass="error" /></td>
	    	</tr>	    	
	    	<tr>
	    		<td><spring:message code="Employee.gender.lbl" />: </td> 
	    		<td>
	    			<form:checkbox path="gender" value="MALE" />Male 
        			<form:checkbox path="gender" value="FEMALE" />Female 
        		</td>
        		<td><form:errors path="gender" cssClass="error" /></td>
	    	</tr>
	    	<tr>
	    		<td><spring:message code="Employee.salary.lbl"/>: </td> 
	    		<td><form:input path="salary" /></td>
	    		<td><form:errors path="salary"  cssClass="error" /></td>
	    	</tr>
	    	<tr>
				<td colspan="3">
					<input type="submit" value="Register"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>