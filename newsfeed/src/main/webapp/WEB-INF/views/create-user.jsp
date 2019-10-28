<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<jsp:useBean id="errors" scope="request" type="java.util.Map" class="java.util.HashMap" />
<%@ include file="top.inc" %>
<%@ include file="middle.inc" %>
<form method="post">
<table>
<tr>
<td>Username</td>
<td><input type="text" name="username" value="${User.username}" size="50" />
<%
if (errors.containsKey("username")) {
out.println("<span class=\"error\">" + errors.get("username") + "</span>");
}
%>
</td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password" value="${User.password}" size="50" />
<%
if (errors.containsKey("password")) {
out.println("<span class=\"error\">" + errors.get("password") + "</span>");
}
%>
</td>
</tr>
<tr>
<td>
<input type="submit" name="submit-button" value="Submit" />
<input type="submit" name="cancel-button" value="Cancel" />
</td>
</tr>
</table>
<input type="hidden" name="id" value="${User.id}" />
</form>
<%@ include file="bottom.inc" %>