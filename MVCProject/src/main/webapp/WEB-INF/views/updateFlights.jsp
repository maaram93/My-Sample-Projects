<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Page</title>
</head>
<body>
	<form:form action="updateEmployee" commandName="flightInformation" method="post">
		<form:errors path="*" cssClass="errorblock" element="div" />

		<%
			if (request.getAttribute("EmployeeData") != null) {
		%>	
			Saved Successfully!!	
		
		<%
			}
		%>

		<table>
			<tr>
				<td><spring:message code="FlightInformation.flightId.lbl" />:</td>
				<td><form:input path="flightId" /></td>
				<td><form:errors path="flightId" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.airlineId.lbl" />:</td>
				<td><form:input path="airlineId" /></td>
				<td><form:errors path="airlineId" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.airlineName.lbl" />:</td>
				<td><form:input path="airlineName" /></td>
				<td><form:errors path="airlineName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.origin.lbl" />:</td>
				<td><form:input path="origin" /></td>
				<td><form:errors path="origin" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.destination.lbl" />:</td>
				<td><form:input path="destination" /></td>
				<td><form:errors path="destination" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.departureTime.lbl" />:</td>
				<td><form:input path="departureTime" /></td>
				<td><form:errors path="departureTime" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.arrivaltime.lbl" />:</td>
				<td><form:input path="arrivaltime" /></td>
				<td><form:errors path="arrivaltime" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee. duation.lbl" />:</td>
				<td><form:input path=" duation" /></td>
				<td><form:errors path=" duation" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.totalseats.lbl" />:</td>
				<td><form:input path="totalseats" /></td>
				<td><form:errors path="totalseats" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="Employee.price.lbl" />:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>