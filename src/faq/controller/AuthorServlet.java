package faq.controller;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.data.QnAPersistenceManager;
import faq.model.Question;
import faq.model.Tags;

@SuppressWarnings("serial")
public class AuthorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens(); 
        
        if(count!=2)
        {
        	
        	resp.getWriter().println("Bad request : "+req.getRequestURI());
        	resp.getWriter().close();
        	return ;
        	
        }
		// skip one token /sites/gooogle.com (remove sites)
		st.nextToken();
		String title_url = st.nextToken();
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setFilter("aliasAuthor=='"+title_url+"'");
		query.setRange(0,15);
		@SuppressWarnings("unchecked")
		List<Question> listQuestion = (List<Question>) query.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		Query query_anwer = psm.newQuery(Question.class);
		query_anwer.setFilter("aliasAuthorAnwer=='"+title_url+"'");
		query_anwer.setRange(0,15);
		@SuppressWarnings("unchecked")
		List<Question> listQuestionAnwer = (List<Question>) query_anwer.execute();
		req.setAttribute("listQuestionAnwer", listQuestionAnwer);
		
		req.setAttribute("author", title_url.replaceAll("[\\W]+", " "));
		
		try {
			req.getRequestDispatcher("/author.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
