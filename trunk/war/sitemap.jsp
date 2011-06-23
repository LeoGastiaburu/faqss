<%
String language = (String) request.getAttribute("language");
%>
<%@page import="faq.model.Question"%>
<%@ page contentType="text/xml;charset=UTF-8" language="java"%>
<%@page import="java.util.List"%>
<?xml version="1.0" encoding="UTF-8"?>
<urlset
      xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9
            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">
  <url>
  <loc>http://www.gardenquestions.com/<%=language%></loc>
</url>
<%
List<Question> listArticles= (List<Question> )request.getAttribute("listArticles");

for(Question article : listArticles)
{
%>
  <url>
  <loc>http://www.gardenquestions.com/<%=language%>/question/<%=article.getAlias()%></loc>
</url>

<%

}
%>

</urlset>