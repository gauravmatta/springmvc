package com.springimplant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 607162626915397781L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("Hi ");
		ServletContext ctx=getServletContext();
		String strName = ctx.getInitParameter("name");
		out.println(strName);
		String strPhone = ctx.getInitParameter("phone");
		out.println(strPhone);
		
		ServletConfig ctg = getServletConfig();
		String configName= ctg.getInitParameter("name");
		out.println(configName);
	}
}
