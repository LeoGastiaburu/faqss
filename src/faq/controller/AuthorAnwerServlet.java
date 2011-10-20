package faq.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
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
import faq.language.Seo;
import faq.model.Question;

@SuppressWarnings("serial")
public class AuthorAnwerServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		resp.setHeader("Vary","Accept-Encoding");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("Hello, world");
		
		Date date_cache = new Date(new Date().getTime()+60*60*1000);
		
		resp.setHeader( "Cache-Control", "public, max-age=300");
		resp.setHeader( "Expires", date_cache.toGMTString() );
		
		String path = ((HttpServletRequest)req).getRequestURI();
		
		String url = req.getRequestURL().toString();
		if(Pattern.matches("^http://www.gardenquestions.com[\\w\\W]*", url))
		{
			url = url.replaceAll("http://www.gardenquestions.com", "http://dev.gardenquestions.com");
			
			resp.setStatus(301);
			resp.setHeader( "Location", url );
			resp.setHeader( "Connection", "close" );
			
		}
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens(); 
        String page = "1";
        if(count!=3 && count!=4)
        {
        	
        	resp.getWriter().println("Bad request : "+req.getRequestURI());
        	resp.getWriter().close();
        	return ;
        	
        }
		// skip one token /sites/gooogle.com (remove sites)
        String language = st.nextToken();
		st.nextToken();
		language = RunLanguage.checkLanguage(language);
		req.setAttribute("language", language);
		String title_url = st.nextToken();
		
		if(count == 4)
		{
			page = st.nextToken();
		}
		//phan trang
		int limit = 30; 
		
		for (int i = 0; i < page.length(); i++) {
			 if ((page.charAt(i) >= 'A' && page.charAt(i) <= 'Z') || (page.charAt(i) >= 'a' && page.charAt(i) <= 'z')) {
				 resp.sendRedirect("/");
	             break;
	         }
        }
		
		int re_page = Integer.parseInt(page);
		req.setAttribute("page", page);
		req.setAttribute("url", language+"/author-anwer/"+title_url);
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query_anwer = psm.newQuery(Question.class);
		query_anwer.setFilter("aliasAuthorAnwer=='"+title_url+"'");
		query_anwer.setRange((limit*(re_page-1)), (limit*(re_page-1)+limit));
		@SuppressWarnings("unchecked")
		List<Question> listQuestion = (List<Question>) query_anwer.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		req.setAttribute("author", title_url.replaceAll("[\\W]+", " "));
		
		try {
			req.getRequestDispatcher("/author_anwer.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
