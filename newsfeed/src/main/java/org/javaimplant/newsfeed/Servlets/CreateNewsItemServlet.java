package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

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

/**
 * Servlet implementation class CreateNewsItemServlet
 */
public class CreateNewsItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;
	
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher("/WEB-INF/views/edit-news-item.jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet()");
		jsp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check if cancel button was pressed.
		String cancelButton = request.getParameter("cancel-button");
		if (cancelButton != null)
		{
			logger.debug("cancel button pressed");
			response.sendRedirect("list-news-items");
			return;
		}
		
		Map<String, String> errors = EditNewsItemServlet.validate(request);
		if (!errors.isEmpty())
		{
			logger.debug("validation errors");
			jsp.forward(request,response);
			return;
		}
		NewsItem newsItem = (NewsItem) request.getAttribute("newsItem");
		new NewsItemDAO().create(newsItem);
		response.sendRedirect("view-news-item?id=" + newsItem.getId());
	}

}
