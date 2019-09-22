<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<jsp:useBean id="ItemNotFound" scope="request" type="java.lang.String" class="java.lang.String" />
<%
String INF=(String)session.getAttribute("ItemNotFound");
if (INF != null) 
{
	out.println(INF);
}
%>
<%@ include file="top.inc" %>
<%@ include file="middle.inc" %>
<h1>Welcome</h1>
<p>
This is the publisher application.
It allows you to publish and manage a news feed.
</p>
<%@ include file="bottom.inc" %>