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
import faq.model.Tags;

@SuppressWarnings("serial")
public class ListTagServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
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
		
		Query query = psm.newQuery(Tags.class);
		query.setRange(0,30);
		@SuppressWarnings("unchecked")
		List<Tags> tags = (List<Tags>) query.execute();
		req.setAttribute("tags", tags);
		
		try {
			req.getRequestDispatcher("/list_tag.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
