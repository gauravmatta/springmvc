<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.time.LocalDateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Home Page</title>
</head>
<body>
<% 
String name = (String) request.getAttribute("name");
Integer rollnumber = (Integer) request.getAttribute("rollnumber");
LocalDateTime time = (LocalDateTime) request.getAttribute("time");
%>
<h1>This is Index Page</h1>
<h2>This is Root Home of user <%=name%></h2>
<h2>Roll Number is : <%=rollnumber %></h2>
<h3>Current Time is <%= time %></h3>
</body>
</html>