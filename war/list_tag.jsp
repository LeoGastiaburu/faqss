<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Seo"%>
<%@page import="faq.model.Tags"%>
<%@page import="faq.language.RunLanguage"%>
<%@page import="faq.language.Language"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<% request.setCharacterEncoding("utf-8");%>
<% 
response.setHeader("Content-Type","text/html; charset=utf-8");
response.setHeader("Vary","Accept-Encoding");
response.setCharacterEncoding("utf-8");
String language = (String) request.getAttribute("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>
<%
String url = (String) request.getAttribute("url");
String cur_page = (String) request.getAttribute("page");
List<Tags> tags = (List<Tags>)request.getAttribute("tags");
String title = resource.getString("page")+" "+cur_page+" - "+resource.getString("list_tag");
String description = title+resource.getString("description");
String keywords = resource.getString("keyword");
String tag = "tag";

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
	<jsp:param name="tag" value="<%=tag %>"/>
</jsp:include>

		<div class="bd">
			<h2 class="tt"><%=resource.getString("list_tag") %></h2>
			<p><%=resource.getString("text_tag") %></p>
			<ul class="lt">
				<%
				if(tags.size()>0)
				{
					for(int i=0;i<tags.size();i++)
					{
				%>
						<li><a href="/<%=language%>/tag/<%=tags.get(i).getAlias()%>"><%=tags.get(i).getName() %></a><span class="it">× <%=tags.get(i).getCount() %></span></li>
				<%
					}
				}
				%>
				<li class="paginate">
					<jsp:include page="re_paginate.jsp">
						<jsp:param name="cur_page" value="<%=cur_page %>"/>
						<jsp:param name="url" value="<%=url %>"/>
						<jsp:param name="number_game" value="<%=tags.size() %>"/>
					</jsp:include>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
<jsp:include page="/layout/footer.jsp">
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>	