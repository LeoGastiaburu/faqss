package faq.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import faq.data.QnAPersistenceManager;
import faq.language.RunLanguage;
import faq.model.Question;

@SuppressWarnings("serial")
public class ListQuestionServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		resp.setHeader("Vary","Accept-Encoding");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("Hello, world");
		
		Date date_cache = new Date(new Date().getTime()+60*60*1000);
		
		resp.setHeader( "Cache-Control", "public, max-age=300");
		resp.setHeader( "Expires", date_cache.toGMTString() );
		
		String url = req.getRequestURL().toString();
		if(Pattern.matches("^http://www.gardenquestions.com[\\w\\W]*", url))
		{
			url = url.replaceAll("http://www.gardenquestions.com", "http://dev.gardenquestions.com");
			
			resp.setStatus(301);
			resp.setHeader( "Location", url );
			resp.setHeader( "Connection", "close" );
			
		}
		
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens(); 
        String page = "1";
        if(count!=2 && count!=3)
        {
        	
        	resp.getWriter().println("Bad request : "+req.getRequestURI());
        	resp.getWriter().close();
        	return ;
        	
        }
		// skip one token /sites/gooogle.com (remove sites)
        String language = st.nextToken();
        language = RunLanguage.checkLanguage(language);
		req.setAttribute("language", language);
		
		if(count == 3)
		{
			st.nextToken();
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
		req.setAttribute("url", language+"/list-questions");
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(Question.class);
		query.setFilter("lastUpdateDate != null");
		query.setOrdering("lastUpdateDate desc");
		query.setRange((limit*(re_page-1)), (limit*(re_page-1)+limit));
		@SuppressWarnings("unchecked")
		List<Question> listQuestion = (List<Question>) query.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		try {
			req.getRequestDispatcher("/list_question.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
