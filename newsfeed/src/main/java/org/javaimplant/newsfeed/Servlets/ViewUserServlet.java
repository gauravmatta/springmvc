package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javaimplant.newsfeed.data.User;
import org.javaimplant.newsfeed.data.UserDAO;

public class ViewUserServlet extends ParentServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet()");
		String idString = req.getParameter("id");
		Long id = Long.parseLong(idString);
		User user = new UserDAO().find(id);
		if(user!=null)
		{
			req.setAttribute("user",user);
			jsp.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("list-users");
		}
	}

}
