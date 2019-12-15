package newsfeed.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.javaimplant.newsfeed.data.NewsItem;
import org.javaimplant.newsfeed.data.NewsItemDAO;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class PublishNewsItemService extends HttpServlet 
{

	private static final long serialVersionUID = -8982996443652960758L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		logger.debug("doPost()");
		// Read the XML request document.
		BufferedReader br = req.getReader();
		SAXBuilder builder = new SAXBuilder();
		Document requestDocument = null;
		try
		{
			requestDocument = builder.build(br);
		}
		catch(JDOMException e)
		{
			throw new RuntimeException(e);
		}
		// Extract title and link from request.
		Element item = requestDocument.getRootElement();
		Element titleElement = item.getChild("title");
		String title = titleElement.getText();
		Element linkElement = item.getChild("link");
		String link = linkElement.getText();
		// Create a news item from submitted data.
		NewsItem newsItem = new NewsItem();
		newsItem.setTitle(title);
		newsItem.setUrl(link);
		new NewsItemDAO().create(newsItem);
		// Create response document with id of newly
		// created news item.
		Element idElement = new Element("id");
		idElement.addContent(newsItem.getId().toString());
		Document responseDocument = new Document(idElement);
		StringWriter sw = new StringWriter();
		XMLOutputter outputter = new XMLOutputter();
		outputter.output(responseDocument, sw);
		String responseDocumentString = sw.toString();
		// Return response document.
		byte[] responseBytes = responseDocumentString.getBytes("UTF-8");
		resp.setContentLength(responseBytes.length);
		resp.setContentType("text/xml");
		OutputStream os = resp.getOutputStream();
		os.write(responseBytes);
		os.flush();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}