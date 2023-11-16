<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
}
</style>
</head>

<body>
${complaints}
	<table>
		<tr>
			<td>Id</td>
			<td>Sender Name</td>
			<td>Message</td>
			<td>Sender Email</td>
		</tr>

		<c:forEach items="${complaints}" var="complaint">
			<tr>
				<td><c:out value="${complaint.id}" /></td>
				<td><c:out value="${complaint.senderName}" /></td>
				<td><c:out value="${complaint.message}" /></td>
				<td><c:out value="${complaint.senderEmail}" /></td>




			</tr>

		</c:forEach>
	</table>



</body>
</html>