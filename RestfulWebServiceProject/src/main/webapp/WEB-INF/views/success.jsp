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
<h1>${Header}</h1>
<h1 style="color: green;">${savemsg}</h1>
<h2>${Desc}</h2>
<hr>
<h1>${maHeader}</h1>
<h2>${maDesc}</h2>
<hr>
<h1> Welcome , ${username}</h1>
<h1> Your Email is , ${useremail}</h1>
<h1> Your Password is , ${userPassword}</h1>
<h1> Welcome , ${user.username}</h1>
<h1> Your Email is , ${user.email}</h1>
<h1> Your Password is , ${user.password}</h1>
</body>
</html>