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


@SuppressWarnings("serial")
public class RssServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
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
		
		req.setAttribute("language", language);
		
		Query query_article = psm.newQuery(Question.class);
		query_article.setOrdering("lastUpdateDate desc");
		query_article.setRange(0, 30);
		@SuppressWarnings({ "unchecked" })
		List<Question> listArticles = (List<Question>) query_article.execute();
		
		req.setAttribute("listArticles", listArticles);
		
		req.setAttribute("title", "Submit free articles - Submit press release online free of charge");
		req.setAttribute("description", "Free articles provided by yooarticles.com - your free articles directory. Find free online articles for your website, eZine or newsletters. Submit your Articles for free syndication and publication.");
		
		try {
			req.getRequestDispatcher("/rss.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
