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
			    		<h3 class="panel-title">Add Project <small>Nks Inc.</small></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					
			                <input type="text" name="projName" id="projName" class="form-control input-sm" placeholder="Project Name">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="deptId" id="deptId" class="form-control input-sm" placeholder="Department Id">
			    					</div>
			    				</div>
			    			</div>
							<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="startDate" id="startDate" class="form-control input-sm" placeholder="Start Date">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="text" name="endDate" id="endDate" class="form-control input-sm" placeholder="End Date">
			    					</div>
			    				</div>
			    			</div>
			    			<input type="submit" name="AddProj" value="Add Project" class="btn btn-info btn-block" />
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