package org.javaimplant.newsfeed.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.javaimplant.newsfeed.data.User;
import org.javaimplant.newsfeed.data.UserDAO;

public class SecurityFilter implements Filter {
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("doFilter()");
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		
		if (servletPath.equals("/login"))
		{
			chain.doFilter(req, resp);
			return;
		}
		
		if (servletPath.equals("/news.rss")) 
		{
			chain.doFilter(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if (userId != null)
		{
			User userinfo=new UserDAO().find(userId);
			if ((servletPath.equals("/list-users") || servletPath.equals("/view-user") || servletPath.equals("/create-user")) && userinfo.getUsername().equals("admin"))
			{
				chain.doFilter(req, resp);
				return;
			}
			chain.doFilter(req, resp);
			return;
		}
		session.invalidate();
		resp.sendRedirect("login");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}	
}
