package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.javaimplant.newsfeed.data.NewsItem;
import org.javaimplant.newsfeed.data.NewsItemDAO;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class NewsFeedServlet extends HttpServlet {
	
	private Logger logger=Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SyndFeed feed=new SyndFeedImpl();
		feed.setFeedType("rss_2.0");
		feed.setTitle("My Local News Feed");
		feed.setLink("http://localhost:8080/publisher/");
		feed.setDescription("This feed was created using ROME.");
		List<SyndEntry> entries=new ArrayList<SyndEntry>();
		List<NewsItem> newsItems = new NewsItemDAO().findAll();
		Iterator<NewsItem> it = newsItems.iterator();
		while (it.hasNext()) {
			NewsItem ni=(NewsItem) it.next();
			String title=ni.getTitle();
			String url = ni.getUrl();
			Date pubdate=ni.getPubDate();
			SyndEntry entry = new SyndEntryImpl();
			entry.setTitle(title);
			entry.setLink(url);
			entry.setPublishedDate(pubdate);
			entries.add(entry);
		}
		resp.setContentType("text/xml");
		feed.setEntries(entries);
		Writer writer = resp.getWriter();
		SyndFeedOutput output = new SyndFeedOutput();
		try 
		{
			output.output(feed, writer);
		} 
		catch (FeedException e) 
		{
			logger.error("", e);
		}
	}
}
