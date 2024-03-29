package faq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;

import faq.data.QnAPersistenceManager;
import faq.language.RunLanguage;
import faq.language.Seo;
import faq.model.Question;
import faq.model.TagQuestion;
import faq.model.Tags;
import faq.string.Replace;

@SuppressWarnings("serial")
public class DetailFaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setHeader("Content-Type","text/html; charset=utf-8");
		resp.setHeader("Vary","Accept-Encoding");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().println("さんの質問");
		resp.getWriter().println("Link has been deleted or does not exist, please choose another link");
		
		Date date_cache = new Date(new Date().getTime()+24*60*60*1000);
		
		resp.setHeader( "Cache-Control", "public, max-age=3000");
		resp.setHeader( "Expires", date_cache.toGMTString() );
		
		
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		
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
        
        if(count!=3)
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
		
		Query query = psm.newQuery(Question.class);
		query.setFilter("alias=='"+title_url+"'");
		@SuppressWarnings("unchecked")
		List<Question> faq = (List<Question>) query.execute();
		
		if(faq.size() > 0)
		{
			String where = "";
			String where_two = "";
			String keyword = "";
			for(Object jString : faq.get(0).getTags())
			{
				keyword += jString.toString()+",";
				if(where.equals(""))
				{
					where = "alias=='"+Replace.replace(jString.toString())+"'";
				} else {
					where = where + "|| alias=='"+Replace.replace(jString.toString())+"'";
				}
			}
			if(where.equals(""))
			{
				where = "alias==null";
			}

			Query query_tag = psm.newQuery(Tags.class);
			query_tag.setFilter(where);
			@SuppressWarnings("unchecked")
			List<Tags> listTags = (List<Tags>) query_tag.execute();
			req.setAttribute("listTags", listTags);
			
			Query query_question = psm.newQuery(Question.class);
			query_question.setFilter("aliasAuthor == '"+faq.get(0).getAliasAuthor()+"' && alias != '"+faq.get(0).getAlias()+"'");
			query_question.setRange(0,30);
			@SuppressWarnings("unchecked")
			List<Question> listTagQuestion = (List<Question>) query_question.execute();
			req.setAttribute("listTagQuestion", listTagQuestion);
			
			Query query2 = psm.newQuery(Question.class);
			query2.setFilter("lastUpdateDate");
			query2.setFilter("lastUpdateDate < date");
			query2.declareParameters("java.util.Date date");
			query2.setOrdering("lastUpdateDate desc");
			query2.setRange(0, 15);
			Date date = faq.get(0).getLastUpdateDate(); 
			@SuppressWarnings("unchecked")
			List<Question> list=  (List<Question>)query2.execute(date);
			req.setAttribute("list", list);
			
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
	        String des = RunLanguage.question(faq.get(0),language).replaceAll("\\<.*?\\>", "").replaceAll("[^\\w!@#$%^&*-=+:;?.,/\\\\]+", " "); 
			if(des.length() > 200)
			{
				des = des.substring(0,200)+" ...";
			}
	        req.setAttribute("title", RunLanguage.title(faq.get(0), language));
			req.setAttribute("keyword", keyword);
			req.setAttribute("description", des);
	        
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
