<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="top.inc" %>
<a href="edit-user?id=${user.id}">Edit</a>
<a href="delete-user?id=${user.id}">Delete</a>
<%@ include file="middle.inc" %>
<table>
<tr>
<td>User Name :</td>
<td> ${user.username} </td>
</tr>
</table>
<%@ include file="bottom.inc" %>