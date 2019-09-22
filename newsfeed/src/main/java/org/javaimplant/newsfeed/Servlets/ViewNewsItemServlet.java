package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.javaimplant.newsfeed.data.NewsItem;
import org.javaimplant.newsfeed.data.NewsItemDAO;

public class ViewNewsItemServlet extends ParentServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet()");
		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString);
		NewsItem newsItem = new NewsItemDAO().find(id);
		if(newsItem!=null)
		{
			req.setAttribute("newsItem",newsItem);
			jsp.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("list-news-items");
		}
	}
}
