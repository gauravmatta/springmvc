<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
Hello World
<br/>
Message:<br/><textarea rows="5" cols="14" name="complaint" style="font-size: 14pt;" form="complaintForm"></textarea><br/>
<form action="/complaint-manager/submitComplaint" method="post" id="complaintForm">
	Email: <input type="text" name="email"><br/>
	Name: <input type="text" name="name"><br/>
	<input type="submit" value="Submit">
</form>

</body>
</html>