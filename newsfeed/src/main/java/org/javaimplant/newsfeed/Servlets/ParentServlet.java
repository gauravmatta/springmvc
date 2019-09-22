package org.javaimplant.newsfeed.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class ParentServlet extends HttpServlet {
	protected Logger logger = Logger.getLogger(this.getClass());
	protected RequestDispatcher jsp;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	    String url=config.getInitParameter("jsp");
	    ServletContext context= config.getServletContext();
	    jsp=context.getRequestDispatcher("/WEB-INF/views/"+url+".jsp");
	}
	
	
}
