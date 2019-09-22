package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class EditNewsItemServlet
 */
public class EditNewsItemServlet extends ParentServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNewsItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("doGet()");
		String idString = request.getParameter("id");
		Long id = Long.parseLong(idString);
		NewsItem newsItem = new NewsItemDAO().find(id);
		request.setAttribute("newsItem", newsItem);
		jsp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// Check if cancel button was pressed.
		String cancelButton = request.getParameter("cancel-button");
		if (cancelButton != null)
		{
			logger.debug("cancel button pressed");
			response.sendRedirect("view-news-item?id=" + id);
			return;
		}
		Map<String, String> errors = validate(request);
		if (!errors.isEmpty())
		{
			logger.debug("validation errors");
			jsp.forward(request,response);
			return;
		}
		NewsItem newsItem = (NewsItem) request.getAttribute("newsItem");
		new NewsItemDAO().update(newsItem);
		response.sendRedirect("view-news-item?id=" + id);
	}
	
	public static Map<String, String> validate(HttpServletRequest request)
	{
		NewsItem newsItem = new NewsItem();
		HashMap<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		request.setAttribute("newsItem", newsItem);
		String idString = request.getParameter("id");
		if (idString != null && idString.length() > 0)
		{
			Long id = new Long(idString);
			newsItem.setId(id);
		}
		
		// title
		String title = request.getParameter("title");
		if (title == null || title.trim().length() == 0)
		{
			errors.put("title", "Title required.");
		}
		newsItem.setTitle(title);
		
		// url
		String url = request.getParameter("url");
		if (url == null || url.trim().length() == 0)
		{
			errors.put("url", "URL required.");
		}
		newsItem.setUrl(url);
		return errors;
	}
}
