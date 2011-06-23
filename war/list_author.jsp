<%@page import="java.util.Random"%>
<%@page import="faq.model.Author"%>
<%@page import="faq.model.Tags"%>
<%@page import="faq.language.RunLanguage"%>
<%@page import="faq.language.Language"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
List<Author> authors = (List<Author>)request.getAttribute("authors");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");
String language = (String) request.getAttribute("language");
String tag = "user";
String url = (String) request.getAttribute("url");
String cur_page = (String) request.getAttribute("page");
%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
	<jsp:param name="tag" value="<%=tag %>"/>
</jsp:include>

		<div class="bd">
			<h2 class="tt">List author</h2>
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
							Questions :  <span class="it"><%=authors.get(i).getCountQuestion() %></span><br/>
							Anwers :  <span class="it"><%=authors.get(i).getCountAnswer() %></span>
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
<%@ include file='/layout/footer.jsp'%>