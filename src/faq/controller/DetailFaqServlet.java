package faq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;

import faq.data.QnAPersistenceManager;
import faq.model.Answer;
import faq.model.Question;

@SuppressWarnings("serial")
public class DetailFaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Link has been deleted or does not exist, please choose another link");
		
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
		st.nextToken();
		String title_url = st.nextToken();
		
		Query query = psm.newQuery(Question.class);
		query.setFilter("alias=='"+title_url+"'");
		@SuppressWarnings("unchecked")
		List<Question> faq = (List<Question>) query.execute();
		
		if(faq.size() > 0)
		{
			Cache cache=null;
	        try {
	            cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
	        } catch (CacheException e) {
	           e.printStackTrace();
	        }
	        if(cache.containsKey("lastPing"))
	        {
	        	@SuppressWarnings("unchecked")
				ArrayList<String> lastPing = (ArrayList<String>)cache.get("lastPing");
	        	if(lastPing.size()>9)
	        	{
	        		lastPing.remove(0);
	        	}
	        	if(!lastPing.contains(faq.get(0).getTitle()))
	        	lastPing.add(faq.get(0).getTitle());
	        	cache.put("lastPing", lastPing);
	        }
	        else
	        {	
	        	ArrayList<String> lastPing = new ArrayList<String>();
	        	if(!lastPing.contains(faq.get(0).getTitle()))
	        	lastPing.add(faq.get(0).getTitle());
	        	cache.put("lastPing", lastPing);
	        }
			
			req.setAttribute("faq", faq.get(0));
			try {
				req.getRequestDispatcher("/detail.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
