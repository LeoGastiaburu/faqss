<%@page import="faq.model.Tags"%>
<%@page import="faq.language.RunLanguage"%>
<%@page import="faq.language.Language"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
List<Tags> tags = (List<Tags>)request.getAttribute("tags");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");
String language = (String) request.getAttribute("language");
String tag = "tag";
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
			<h2 class="tt">List tag</h2>
			<p>A tag is a keyword or label that categorizes your question with other, similar questions. Using the right tags makes it easier for others to find and answer your question. </p>
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
<%@ include file='/layout/footer.jsp'%>