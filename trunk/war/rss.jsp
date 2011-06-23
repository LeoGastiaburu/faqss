<%@page import="faq.language.RunLanguage"%>
<%@page import="faq.model.Question"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
  	List<Question> listArticles = (List<Question>) request.getAttribute("listArticles");
	String title = (String) request.getAttribute("title");
	String description = (String) request.getAttribute("description");
	String language = (String) request.getAttribute("language");
%>
<?xml version="1.0" encoding="UTF-8"?>
  <rss version="2.0"
    xmlns:dc="http://purl.org/dc/elements/1.1/"
    xmlns:sy="http://purl.org/rss/1.0/modules/syndication/"
    xmlns:admin="http://webns.net/mvcb/"
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:content="http://purl.org/rss/1.0/modules/content/">

    <channel>
    
    <title><![CDATA[ <%=title %>]]></title>
    <link>http://www.gardenquestions.com/<%=language %></link>
    <description><![CDATA[<%=description %>]]></description>
    <dc:language>en-ca</dc:language>
    <dc:creator>google app engine</dc:creator>

    <dc:rights>Copyright 2011</dc:rights>
    <admin:generatorAgent rdf:resource="http://www.gardenquestions.com/" />
    	<%
    		for(int i=0;i<listArticles.size();i++)
    		{
    			Question tmp = listArticles.get(i);
    			String des = RunLanguage.question(tmp,language).replaceAll("\\<.*?\\>", "");
    			if(des.length() > 250)
    			{
    				des = des.substring(0,250);
    			}
    	%>
		       <item>
		          <title><![CDATA[ <%=RunLanguage.title(tmp,language)%> ]]></title>
		          <link>http://www.gardenquestions.com/<%=language %>/question/<%=tmp.getAlias() %></link>
		          <guid><%=RunLanguage.title(tmp,language)%></guid>
		
		          <description><![CDATA[ <%=des %>]]></description>
		      	  <pubDate><%=tmp.getLastUpdateDate().toGMTString() %></pubDate>
		       </item>
       <%
    		}
       %>
	        
	    
    </channel>
</rss>  