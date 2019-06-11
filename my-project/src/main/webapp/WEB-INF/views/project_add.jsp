<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:forEach items="${errorList}" var="error">
	        <c:out value="${error}"/>
	</c:forEach>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl" htmlEscape="true"/>
			<form:form method="POST" action="${formUrl}" modelAttribute="project">
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input path="name" id="project-name" cssClass="form-control"/>
					<form:errors path="name"/>
				</div>
				
				<div class="form-group">
					<label for="project_type">Type</label>
					<form:select path="type" cssClass="selectpicker" items="${types}"></form:select>
				</div>
			
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input id="sponsor-name" path="sponsor.name" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input id="sponsor-phone" path="sponsor.phone" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input id="sponsor-email" path="sponsor.email" cssClass="form-control"/>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input path="authorizedFunds" id="funds" cssClass="form-control"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input path="authorizedHours" id="hours" cssClass="form-control"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<form:textarea path="description" id="description" cssClass="form-control" rows="3"/>
					<form:errors path="description"/>
				</div>
				
				<div class="form-group">
					<label for="poc">POC</label>
					<form:input id="poc" path="pointsOfContact[0]" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="poc2">POC 2</label>
					<form:input id="poc2" path="pointsOfContact[1]" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="poc3">POC 3</label>
					<form:input id="poc3" path="pointsOfContact[2]" cssClass="form-control"/>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox path="special" id="special" />
				</div>
	
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>