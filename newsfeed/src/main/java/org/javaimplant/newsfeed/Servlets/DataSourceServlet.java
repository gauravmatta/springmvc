package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;

public class DataSourceServlet extends HttpServlet {
	
	private Logger logger=Logger.getLogger(this.getClass());
	private static DataSource dataSource;
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	public static void setDataSource(DataSource dataSource) {
		DataSourceServlet.dataSource = dataSource;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SyndFeed feed=new SyndFeedImpl();
		feed.setFeedType("rss_2.0");
		feed.setTitle("My Local News Feed");
		feed.setLink("http://localhost:8080/publisher/");
		feed.setDescription("This feed was created using ROME.");
		List<SyndEntry> entries=new ArrayList<SyndEntry>();
		try {
			Connection connection=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
