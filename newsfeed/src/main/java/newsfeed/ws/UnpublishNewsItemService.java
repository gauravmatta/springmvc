package newsfeed.ws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.javaimplant.newsfeed.data.NewsItem;
import org.javaimplant.newsfeed.data.NewsItemDAO;

public class UnpublishNewsItemService extends HttpServlet {
	private Logger logger = Logger.getLogger(this.getClass());
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.debug("doGet()");
		String id = req.getParameter("id");
		NewsItemDAO newsItemDAO = new NewsItemDAO();
		NewsItem newsItem = newsItemDAO.find(Long.parseLong(id));
		if (newsItem != null)
		{
			newsItemDAO.delete(newsItem);
		}
	}
}
