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
import faq.model.TagQuestion;
import faq.model.Tags;

@SuppressWarnings("serial")
public class TagServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens(); 
        
        if(count!=3)
        {
        	
        	resp.getWriter().println("Bad request : "+req.getRequestURI());
        	resp.getWriter().close();
        	return ;
        	
        }
		// skip one token /sites/gooogle.com (remove sites)	
        String language = st.nextToken();
		st.nextToken();
		
		req.setAttribute("language", language);
		
		String title_url = st.nextToken();
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Query query = psm.newQuery(TagQuestion.class);
		query.setFilter("aliasTag=='"+title_url+"'");
		query.setRange(0,30);
		@SuppressWarnings("unchecked")
		List<TagQuestion> listQuestion = (List<TagQuestion>) query.execute();
		req.setAttribute("listQuestion", listQuestion);
		
		Query tag = psm.newQuery(Tags.class);
		tag.setFilter("alias=='"+title_url+"'");
		@SuppressWarnings("unchecked")
		List<Tags> tags = (List<Tags>)tag.execute();
		req.setAttribute("tags", tags);
		req.setAttribute("start", title_url.substring(0,1));
		try {
			req.getRequestDispatcher("/tag.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
