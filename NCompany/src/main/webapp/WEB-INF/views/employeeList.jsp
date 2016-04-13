<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<form method="POST">
<table border="1">
<tr align="center"><td colspan="5">Employee List</td></tr>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>email</th>
		<th>Phone Number</th>
		<th>Options</th>
	</tr>

<c:forEach var="emp" items="${employeeList}">
	<tr>
		<td>${emp.fName}</td>
		<td>${emp.lName}</td>
		<td>${emp.email}</td>
		<td>${emp.phoneNumber}</td>
		<td> <a href="#">Edit</a> | <a href="#">Delete</a> </td>
	</tr>
	 </c:forEach>
</table>

</form>

</body>
</html>