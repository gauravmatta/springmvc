<%@ page import="java.util.Iterator" %>
<%@ page import="org.javaimplant.newsfeed.data.User" %>
<jsp:useBean id="users" scope="request" type="java.util.List" />
<%@ include file="top.inc" %>
<a href="create-news-item">Create News Item</a>
<%@ include file="middle.inc" %>
<ul>
<%
Iterator it = users.iterator();
while (it.hasNext())
{
User user = (User) it.next();
%>
<li>
<a href="view-user?id=<%=user.getId()%>"><%=user.getUsername()%></a>
</li>
<% } %>
</ul>
<%@ include file="bottom.inc" %>