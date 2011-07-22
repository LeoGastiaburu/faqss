package faq.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.data.QnAPersistenceManager;
import faq.language.RunLanguage;
import faq.model.Question;


@SuppressWarnings("serial")
public class RssServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		resp.setHeader("Vary","Accept-Encoding");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("Hello, world");
		
		String url = req.getRequestURL().toString();
		if(Pattern.matches("^http://demoquestions.appspot.com[\\w\\W]*", url))
		{
			url = url.replaceAll("http://demoquestions.appspot.com", "http://www.gardenquestions.com");
			
			resp.setStatus(301);
			resp.setHeader( "Location", url );
			resp.setHeader( "Connection", "close" );
			
		}
		
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
		
		Query query_article = psm.newQuery(Question.class);
		query_article.setOrdering("lastUpdateDate desc");
		query_article.setRange(0, 30);
		@SuppressWarnings({ "unchecked" })
		List<Question> listArticles = (List<Question>) query_article.execute();
		
		req.setAttribute("listArticles", listArticles);
		ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
		req.setAttribute("title", resource.getString("title"));
		req.setAttribute("keyword", resource.getString("keyword"));
		
		
		try {
			req.getRequestDispatcher("/rss.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
