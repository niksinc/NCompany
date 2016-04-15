<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/css/bootstrap.css" var="bottstrapCss" />
 <link href="${bottstrapCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="f1" action="./home" method="POST" >

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Add Employee Detail <small>Nks Inc.</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					
			                <input type="text" name="fName" id="fName" class="form-control input-sm" placeholder="First Name">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="lName" id="lName" class="form-control input-sm" placeholder="Last Name">
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    				<input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="phoneNumber" id="password" class="form-control input-sm" placeholder="PhoneNumber">
			    					</div>
			    				</div>
			    				
			    			</div>
			    			<input type="submit" name="AddEmpl" value="Add Employee" class="btn btn-info btn-block" />
			    			<input type="submit" name="cancel" value="Cancel" class="btn btn-info btn-block" />
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>

</form>
</body>
</html>