<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>
<body>
<p>Hello World</p>
<form action="submitComplaint" method="post">
	<input style="height: 200px" type="text" name="complaint"/>
	<input type="text" name="email"/>
	<input type="text" name="name"/>
	<input type="submit" value="Submit">
</form>
</body>
</html>