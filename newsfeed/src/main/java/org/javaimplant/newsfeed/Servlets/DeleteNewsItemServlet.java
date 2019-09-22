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

public class DeleteNewsItemServlet extends ParentServlet {	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet()");
		jsp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = req.getParameter("id");
		// Check if cancel button was pressed.
		String cancelButton = req.getParameter("cancel-button");
		if (cancelButton != null)
		{
			logger.debug("cancel button pressed");
			resp.sendRedirect("view-news-item?id=" + idString);
			return;
		}
		NewsItemDAO newsItemDAO = new NewsItemDAO();
		Long id = Long.parseLong(idString);
		NewsItem newsItem = newsItemDAO.find(id);
		new NewsItemDAO().delete(newsItem);
		resp.sendRedirect("list-news-items");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/views/delete-news-item.jsp");
	}
	
	
}
