<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:forEach var="c" items="${complaints}" varStatus="loopCounter">
			<c:out value="${loopCounter.count}"/>
         	<c:out value = "${c.message}"/><p>
      </c:forEach>
</body>
</html>