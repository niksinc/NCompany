<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="f1" action="./home" method="POST" >
<h3> Add Employee </h3>
<table>
	<tr>
		<td><span>Employee First Name: </span></td>
		<td><input name="fName" type="text" /></td>
	</tr>
	<tr>
		<td><span>Employee Last Name: </span></td>
		<td><input name="lName" type="text" /></td>
	</tr>
	<tr>
		<td><span>Email: </span></td>
		<td><input name="email" type="email" /></td>
	</tr>
	<tr>
		<td><span>PhoneNumber: </span></td>
		<td><input name="phoneNumber" type="text" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="AddEmpl" value="Add Employee" /></td>
		<td><input type="button" name="cancel" value="Cancel" /></td>
	</tr>
</table>

</form>
</body>
</html>