package org.javaimplant.newsfeed.Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

public class HomeServlet extends HttpServlet {
	
	private Logger logger=Logger.getLogger(this.getClass());
	private RequestDispatcher homeJsp;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("Retrieving yahoo news feed");
		String url = "http://rss.news.yahoo.com/rss/tech";
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		try {
			 CloseableHttpClient httpClient = HttpClients.createDefault();
			 BufferedReader reader = getResponseRSS(httpClient,url);
			 syndFeed = syndFeedInput.build(reader);
			 reader.close();
			 httpClient.close();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Forwarding to home.jsp");
		req.setAttribute("syndFeed", syndFeed);
		homeJsp.forward(req, resp);
	}
	
	private static BufferedReader getResponseRSS(CloseableHttpClient httpClient, String dataSource) throws IOException {

	    HttpGet httpGet = new HttpGet(dataSource);
	    CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
	    BufferedReader reader;
	    if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
	        reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
	    } else {
	        reader = null;
	    }

	    return reader;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		BasicConfigurator.configure();
	}

}
