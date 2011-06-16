package faq.controller;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.data.QnAPersistenceManager;
import faq.model.Tags;

@SuppressWarnings("serial")
public class ListTagServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		
		Query query = psm.newQuery(Tags.class);
		query.setRange(0,30);
		@SuppressWarnings("unchecked")
		List<Tags> tags = (List<Tags>) query.execute();
		req.setAttribute("tags", tags);
	}
}
