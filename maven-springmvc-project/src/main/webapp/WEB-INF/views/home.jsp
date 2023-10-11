<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Root Home</title>
</head>
<body>
<% 
String name = (String) request.getAttribute("name");
Integer id = (Integer) request.getAttribute("id");
%>
<h1>This is Root Home of user <%=name%></h1>
<h1>Id of user <%=id%></h1>
</body>
</html>