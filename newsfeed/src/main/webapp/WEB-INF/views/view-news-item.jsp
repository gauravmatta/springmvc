<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="top.inc" %>
<a href="edit-news-item?id=${newsItem.id}">Edit</a>
<a href="delete-news-item?id=${newsItem.id}">Delete</a>
<%@ include file="middle.inc" %>
<table>
<tr>
<td>Title:</td>
<td> ${newsItem.title} </td>
</tr>
<tr>
<td>Url:</td>
<td>
<a href="${newsItem.url}">${newsItem.url}</a>
</td>
</tr>
</table>
<%@ include file="bottom.inc" %>