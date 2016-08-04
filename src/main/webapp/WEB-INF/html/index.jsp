
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>
	        
	<h3>Welcome, Enter The Student Details</h3>
	        
	<form:form method="POST" action="/Incubation/create.html"
		commandName="student">
 <table>
<tr>
<td><form:label path="id">Id</form:label></td>
<td><form:input path="id" /></td>
</tr>

<tr>
<td><form:label path="firstName">First Name</form:label></td>
<td><form:input path="firstName" /></td>
</tr>
<tr>
<td><form:label path="lastName">Last Name</form:label></td>
<td><form:input path="lastName" /></td>
</tr>
<tr>
<td><form:label path="mobile">Mobile Number</form:label></td>
<td><form:input path="mobile" /></td>
</tr>
<tr></tr>
<tr>
<td><input type="submit" name="Submit" value="Submit" /></td>
<td><input type="submit" name="Display" value="Display" /></td>
</tr>
</table>
	
			
        </form:form>
	    
</body>
</html>