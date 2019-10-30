package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javaimplant.newsfeed.data.User;
import org.javaimplant.newsfeed.data.UserDAO;

public class ListUsersServlet extends ParentServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet()");	
		List<User> users=new UserDAO().findAll();
		req.setAttribute("users",users);
		jsp.forward(req, resp);
	}

}
