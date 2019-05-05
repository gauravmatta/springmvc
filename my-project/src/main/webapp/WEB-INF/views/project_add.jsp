<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl" htmlEscape="true"/>
			<form:form method="POST" action="${formUrl}" modelAttribute="project">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name"  class="form-control" name="name"/>
				</div>
				
				<div class="form-group">
					<label for="project_type">Type</label>
					<select name="type" class="selectpicker">
						<option></option>
						<option value="single">Single Year</option>
						<option value="multi">Multi-Year</option>
					</select>
				</div>
			
				<div class="form-group">
					<label for="sponsor">Sponsor</label>
					<input id="sponsor" type="text" 
							class="form-control" name="sponsor"/>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<input id="funds" type="text"
						class="form-control" name="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<input id="hours" type="text"
						class="form-control" name="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<textarea name="description" class="form-control" rows="3"></textarea>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<input id="special" name="special" type="checkbox"/>
				</div>
	
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>