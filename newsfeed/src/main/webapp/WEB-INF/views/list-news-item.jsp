<%@ page import="java.util.Iterator" %>
<%@ page import="org.javaimplant.newsfeed.data.NewsItem" %>
<jsp:useBean id="newsItems" scope="request" type="java.util.List" />
<%@ include file="top.inc" %>
<a href="create-news-item">Create News Item</a>
<%@ include file="middle.inc" %>
<ul>
<%
Iterator it = newsItems.iterator();
while (it.hasNext())
{
NewsItem newsItem = (NewsItem) it.next();
%>
<li>
<a href="view-news-item?id=<%=newsItem.getId()%>"><%=newsItem.getTitle()%></a>
</li>
<% } %>
</ul>
<%@ include file="bottom.inc" %>