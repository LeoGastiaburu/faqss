<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Language"%>
<%
String tag = request.getParameter("tag");
if(tag == null)
{
	tag = "home";	
}
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="<%=language %>" dir="ltr">
	<head>
		<title><%=request.getParameter("title") %> - gardenquestions.com</title>
		<meta name="description" content="<%=request.getParameter("description").replaceAll("[\"\']+","") %>"/>
		<meta name="Keywords" content="<%=request.getParameter("keywords").replaceAll("[\"\']+","") %>"/>	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta id="metaLanguage" http-equiv="Content-Language" content="<%=language %>" />
		<link rel='stylesheet' type='text/css' href='/css/faq.css' />
		
	</head>
	<body>
		<div class="tl">
			<jsp:include page="/element/flag.jsp"></jsp:include>
		</div>
		<div class="hd">
			<a href="/<%=language %>" class="lg"><img src="/images/logwo.jpg" alt="logo"/></a>
			<ul class="menu">
				<li><a href="/<%=language %>" title="Home" <%=(tag.equals("home"))?"class=\"at\"":"" %>><%=resource.getString("menu_home") %></a></li>
				<li><a href="/<%=language %>/list-questions" title="question" <%=(tag.equals("question"))?"class=\"at\"":"" %>><%=resource.getString("menu_question")%></a></li>
				<li><a href="/<%=language %>/list-tags" title="tags" <%=(tag.equals("tag"))?"class=\"at\"":"" %>><%=resource.getString("menu_tag") %></a></li>
				<li><a href="/<%=language %>/list-authors" title="users" <%=(tag.equals("user"))?"class=\"at\"":"" %>><%=resource.getString("menu_user") %></a></li>
				<li><a href="/<%=language %>/contact" title="contact" <%=(tag.equals("contact"))?"class=\"at\"":"" %>><%=resource.getString("menu_contact") %></a></li>
				<li><a href="/<%=language %>/sitemap" title="site map" target="_blank">Site map</a></li>
				<li><a href="/<%=language %>/rss" title="rss" target="_blank">Rss</a></li>	
			</ul>
			<div class="clear"></div>
		</div>