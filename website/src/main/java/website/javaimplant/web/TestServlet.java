package website.javaimplant.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now=new Date();
		PrintWriter writer=resp.getWriter();
		writer.println("<html><body>");
		writer.println(now.toString());
		writer.println("</body></html>");		
	}

}
