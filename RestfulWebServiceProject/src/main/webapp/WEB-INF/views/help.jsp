<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import ="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Root Home</title>
</head>
<body>
<h1>This is Root Home of user ${name}</h1>
<h2>Current Time is ${time}</h2>
<h1>
Id of user is ${rollnumber}
Friends are
${friends}
</h1>
<c:forEach var="friend" items="${friends}">
<h3>${friend}</h3>
<h2><c:out value="friend"></c:out></h2>
</c:forEach>
</body>
</html>