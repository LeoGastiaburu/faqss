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
import faq.language.RunLanguage;
import faq.model.Question;


public class SitemapServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		
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
        String language = st.nextToken();
        language = RunLanguage.checkLanguage(language);
		req.setAttribute("language", language);
		
		Query query = psm.newQuery(Question.class);
		query.setOrdering("date desc");
		query.setRange(0,500);
		@SuppressWarnings("unchecked")
		List<Question> listArticles = (List<Question>) query.execute();
		req.setAttribute("listArticles", listArticles);
		
		try {
			req.getRequestDispatcher("/sitemap.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
