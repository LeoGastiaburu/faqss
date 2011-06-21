<%
String tag = request.getParameter("tag");
if(tag == null)
{
	tag = "home";	
}
String language = request.getParameter("language");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><%=request.getParameter("title") %> - yooarticles.com</title>
		<meta name="description" content="<%=request.getParameter("description").replaceAll("[\"\']+","") %>"/>
		<meta name="Keywords" content="<%=request.getParameter("keywords").replaceAll("[\"\']+","") %>"/>	
		<link rel='stylesheet' type='text/css' href='/css/faq.css' />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
	<body>
		<div class="tl"></div>
		<div class="hd">
			<a href="/<%=language %>" class="lg"><img src="/images/logwo.jpg" alt="logo"/></a>
			<ul class="menu">
				<li><a href="/<%=language %>" title="Home" <%=(tag.equals("home"))?"class=\"at\"":"" %>>Home page</a></li>
				<li><a href="/list-questions/<%=language %>" title="question" <%=(tag.equals("question"))?"class=\"at\"":"" %>>Questions</a></li>
				<li><a href="/list-tags/<%=language %>" title="tags" <%=(tag.equals("tag"))?"class=\"at\"":"" %>>Tags</a></li>
				<li><a href="/list-users/<%=language %>" title="users" <%=(tag.equals("user"))?"class=\"at\"":"" %>>Users</a></li>
				<li><a href="/contact/<%=language %>" title="contact" <%=(tag.equals("contact"))?"class=\"at\"":"" %>>Contact</a></li>
				<li><a href="/sitemap/<%=language %>" title="site map" target="_blank">Site map</a></li>
				<li><a href="/rss/<%=language %>" title="rss" target="_blank">Rss</a></li>	
			</ul>
			<div class="clear"></div>
		</div>