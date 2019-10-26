package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaimplant.newsfeed.data.SecureDigester;
import org.javaimplant.newsfeed.data.User;
import org.javaimplant.newsfeed.data.UserDAO;

public class LoginServlet extends ParentServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("doGet()");
		jsp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("doPost()");
		String username = req.getParameter("username");
		User user = new UserDAO().findByUsername(username);
		if (user == null)
		{
			logger.debug("authentication failed: bad username");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}
		String password = req.getParameter("password");
		if (password == null)
		{
			logger.debug("authentication failed: no password");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}
		String passwordDigest = SecureDigester.digest(password);
		if (!user.getPassword().equals(passwordDigest))
		{
			logger.debug("authentication failed: bad password");
			req.setAttribute("message", "Authentication failed.");
			jsp.forward(req, resp);
			return;
		}
		HttpSession session = req.getSession();
		Long userId = user.getId();
		session.setAttribute("userId", userId);
		logger.debug("authenticated");
		String url = "home";
		resp.sendRedirect(url);
	}
}
