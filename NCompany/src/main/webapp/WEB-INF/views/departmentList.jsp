<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/css/bootstrap.css" var="bottstrapCss" />
 <link href="${bottstrapCss}" rel="stylesheet" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<form method="POST">
<div class="container">
<div class="row col-md-8 col-md-offset-1 custyle">
<table  class="table table-striped custab" >

 <thead>
    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new Department	</a>
        <tr>
	        <th>Department Name</th>
			<th>Location</th>
			<th class="text-center">Action</th>
        </tr>
    </thead>
	
<c:forEach var="dept" items="${departmentList}">
	<tr>
		<td>${dept.deptName}</td>
		<td>${dept.location}</td>
		<td class="text-center">
			<a class='btn btn-info btn-xs' href="#">
			<span class="glyphicon glyphicon-edit"></span> Edit</a>
			<a href="#" class="btn btn-danger btn-xs">
			<span class="glyphicon glyphicon-remove"></span> Del</a>
		 </td>
	</tr>
	 </c:forEach>
</table>
</div>
</div>
</form>

</body>
</html>