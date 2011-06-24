package faq.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import faq.data.QnAPersistenceManager;
import faq.language.Seo;
import faq.model.Question;

@SuppressWarnings("serial")
public class FaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.getWriter().println("Hello, world");
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		resp.setHeader("Vary","Accept-Encoding");
		resp.setCharacterEncoding("utf-8");
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens();
        String language = "en";
		if(count != 0)
		{
			language = st.nextToken();
		}
		
		req.setAttribute("language", language);
		ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setFilter("lastUpdateDate != null");
		query.setOrdering("lastUpdateDate desc");
		query.setRange(0,30);
		@SuppressWarnings("unchecked")
		List<Question> listQuestion = (List<Question>) query.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		req.setAttribute("title", resource.getString("title"));
		req.setAttribute("keyword", resource.getString("keyword"));
		req.setAttribute("description", resource.getString("description"));
		
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
