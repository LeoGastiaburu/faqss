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
import faq.model.Author;
import faq.model.Tags;

@SuppressWarnings("serial")
public class ListAuthorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		
		String path = ((HttpServletRequest)req).getRequestURI();
		
		StringTokenizer st = new StringTokenizer( path,"/");
        int count = st.countTokens(); 
        String page = "1";
        if(count!=2&&count!=3)
        {
        	
        	resp.getWriter().println("Bad request : "+req.getRequestURI());
        	resp.getWriter().close();
        	return ;
        	
        }
		// skip one token /sites/gooogle.com (remove sites)
        String language = st.nextToken();
		
		req.setAttribute("language", language);
		
		if(count == 3)
		{
			st.nextToken();
			page = st.nextToken();
		}
		//phan trang
		int limit = 40; 
		
		for (int i = 0; i < page.length(); i++) {
			 if ((page.charAt(i) >= 'A' && page.charAt(i) <= 'Z') || (page.charAt(i) >= 'a' && page.charAt(i) <= 'z')) {
				 resp.sendRedirect("/");
	             break;
	         }
       }
		
		int re_page = Integer.parseInt(page);
		req.setAttribute("page", page);
		req.setAttribute("url", language+"/list-users");
		
		Query query = psm.newQuery(Author.class);
		query.setRange((limit*(re_page-1)), (limit*(re_page-1)+limit));
		@SuppressWarnings("unchecked")
		List<Author> authors = (List<Author>) query.execute();
		req.setAttribute("authors", authors);
		
		try {
			req.getRequestDispatcher("/list_author.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
