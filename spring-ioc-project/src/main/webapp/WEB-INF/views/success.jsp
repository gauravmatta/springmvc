<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${student}</h1>
<h1>Name is ${student.name}</h1>
<h1>Id is ${student.id}</h1>
<h1>DOB is ${student.dob}</h1>
<h1>Courses are ${student.course}</h1>
<h1>Gender is ${student.gender}</h1>
<h1>Type is ${student.studenttype}</h1>
<hr>
<h1>Address Street is ${student.address.street}</h1>
<h1>Address Street is ${student.address.city}</h1>
</body>
</html>