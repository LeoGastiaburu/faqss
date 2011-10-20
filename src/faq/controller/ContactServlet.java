package faq.controller;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.language.RunLanguage;

@SuppressWarnings("serial")
public class ContactServlet extends HttpServlet {
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

