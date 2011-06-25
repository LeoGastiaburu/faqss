<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Seo"%>
<%@page import="java.util.Random"%>
<%@page import="faq.model.Author"%>
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
List<Author> authors = (List<Author>)request.getAttribute("authors");
String title = resource.getString("page")+" "+cur_page+" - "+resource.getString("list_author");
String description = title+Seo.description(language);
String keywords = Seo.keyword(language);
String tag = "user";

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
	<jsp:param name="tag" value="<%=tag %>"/>
</jsp:include>

		<div class="bd">
			<h2 class="tt"><%=resource.getString("list_author")%></h2>
			<p>A tag is a keyword or label that categorizes your question with other, similar questions. Using the right tags makes it easier for others to find and answer your question. </p>
			<ul class="lat">
				<%
				Random generator = new Random();
				
				if(authors.size()>0)
				{
					for(int i=0;i<authors.size();i++)
					{
						int rand = generator.nextInt(32);
				%>
						<li>
							<img alt="author" src="/images/author<%=rand+1 %>.png"/>
							<a href="/<%=language%>/author/<%=authors.get(i).getAlias()%>"><%=authors.get(i).getName() %></a>
							<%=resource.getString("menu_question")%> :  <span class="it"><a href="/<%=language%>/author-question/<%=authors.get(i).getAlias()%>"><%=authors.get(i).getCountQuestion() %></a></span><br/>
							<%=resource.getString("answer")%> :  <span class="it"><a href="/<%=language%>/author-answer/<%=authors.get(i).getAlias()%>"><%=authors.get(i).getCountAnswer() %></a></span>
						</li>
				<%
					}
				}
				%>
				<li class="paginate">
					<jsp:include page="author_paginate.jsp">
						<jsp:param name="cur_page" value="<%=cur_page %>"/>
						<jsp:param name="url" value="<%=url %>"/>
						<jsp:param name="number_game" value="<%=authors.size() %>"/>
					</jsp:include>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
<jsp:include page="/layout/footer.jsp">
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>	