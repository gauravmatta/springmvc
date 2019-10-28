package org.javaimplant.newsfeed.Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javaimplant.newsfeed.data.SecureDigester;
import org.javaimplant.newsfeed.data.User;
import org.javaimplant.newsfeed.data.UserDAO;

public class CreateUserServlet extends ParentServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doGet()");
		jsp.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cancelButton = req.getParameter("cancel-button");
		if (cancelButton != null)
		{
			logger.debug("cancel button pressed");
			resp.sendRedirect("create-user");
			return;
		}
		
		Map<String, String> errors = CreateUserServlet.validate(req);
		if (!errors.isEmpty())
		{
			logger.debug("validation errors");
			jsp.forward(req,resp);
			return;
		}
		User user = (User) req.getAttribute("user");
		new UserDAO().create(user);
		resp.sendRedirect("view-user?id=" + user.getId());
	}
	
	public static Map<String, String> validate(HttpServletRequest request)
	{
		User user = new User();
		HashMap<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		request.setAttribute("user", user);
		String idString = request.getParameter("id");
		if (idString != null && idString.length() > 0)
		{
			Long id = Long.parseLong(idString);
			user.setId(id);
		}
		
		String username = request.getParameter("username");
		if (username == null || username.trim().length() == 0)
		{
			errors.put("username", "Username required.");
		}
		user.setUsername(username);
		
		String password = request.getParameter("password");
		if (password == null || password.trim().length() == 0)
		{
			errors.put("password", "Password required.");
		}
		String passwordDigest = SecureDigester.digest(password);
		user.setPassword(passwordDigest);
		return errors;
	}
}
