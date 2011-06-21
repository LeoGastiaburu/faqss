package faq.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
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
        String language = st.nextToken();
		
		req.setAttribute("language", language);
		
		req.setAttribute("seo_title", "Contact us");
		req.setAttribute("title", "Contact us");
		req.setAttribute("description", "Contact us .Showsiteinfo - A Free SEO tool that provides free website analysis, traffic details, rankings, contact email ,similar site, same owner site , same ip site, optimization and promotion reports.");
		req.setAttribute("keyword", "Domain name information,  Server information, Web site analysis, website traffic details, Website backlinks website IP, website ranking info");
		
		try {
			req.getRequestDispatcher("/contact.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

