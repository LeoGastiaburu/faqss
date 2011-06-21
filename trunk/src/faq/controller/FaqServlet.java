package faq.controller;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import faq.data.QnAPersistenceManager;
import faq.model.Question;

@SuppressWarnings("serial")
public class FaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens();
        String language = "en";
		if(count != 0)
		{
			language = st.nextToken();
		}
		
		req.setAttribute("language", language);
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setFilter("lastUpdateDate != null");
		query.setOrdering("lastUpdateDate desc");
		query.setRange(0,30);
		@SuppressWarnings("unchecked")
		List<Question> listQuestion = (List<Question>) query.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
