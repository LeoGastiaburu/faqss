<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Seo"%>
<%@page import="faq.language.RunLanguage"%>
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
List<Question> listQuestion = (List<Question>)request.getAttribute("listQuestion");
List<Question> listQuestionAnwer = (List<Question>)request.getAttribute("listQuestionAnwer");
String author = (String)request.getAttribute("author");

if(listQuestion.size()>0)
{
	author = listQuestion.get(0).getAuthor();
}
if(listQuestionAnwer.size()>0)
{
	author = listQuestionAnwer.get(0).getAuthorAnwer();
}

String title = resource.getString("author")+" : "+author;
String description = title+"."+resource.getString("description");
String keywords = author+","+resource.getString("keyword");
%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<jsp:include page="element/adv3.jsp"></jsp:include>
				<br/><br/><br/>
				<h2><%=resource.getString("author") %> : <%=author %></h2>
				<div class="adt">
					<!-- AddThis Button BEGIN -->
					<div class="addthis_toolbox addthis_default_style addthis_32x32_style">
					<a class="addthis_button_preferred_1"></a>
					<a class="addthis_button_preferred_2"></a>
					<a class="addthis_button_preferred_3"></a>
					<a class="addthis_button_preferred_4"></a>
					<a class="addthis_button_compact"></a>
					<a class="addthis_counter addthis_bubble_style"></a>
					</div>
					<script type="text/javascript">var addthis_config = {"data_track_clickback":true};</script>
					<script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-4d6f3cdb1d190d60"></script>
					<!-- AddThis Button END -->
				</div>
				<div class="adt so">
					<script type="text/javascript" src="https://apis.google.com/js/plusone.js"></script>
					<g:plusone size="standard" count="true"></g:plusone>
				</div>
				<div class="clear"></div>
				
				<br/>
				<div style="float: left;">
					<jsp:include page="/element/adv2.jsp"></jsp:include>
				</div>
				<div style="float: right;">
					<jsp:include page="/element/adv2.jsp"></jsp:include>
				</div>
				<div class="clear"></div>
				
				<%
				if(listQuestion.size()>0)
				{
				%>
				<hr size="1"/>
				<h4><%=resource.getString("list_question") %>   ( <a href="/<%=language %>/author-question/<%=listQuestion.get(0).getAliasAuthor()%>"><%=resource.getString("view_all") %></a> )</h4>
				<div class="clear"></div>
				<ul class="lq">
					<%
						for(int i=0;i<listQuestion.size();i++)
						{
					%>
							<li>
								<h1><a href="/<%=language %>/question/<%=listQuestion.get(i).getAlias() %>" title="<%=Replace.replace(RunLanguage.title(listQuestion.get(i),language)) %>"><%=RunLanguage.title(listQuestion.get(i),language)%></a></h1>
								<p>
									<%
										String des = RunLanguage.question(listQuestion.get(i),language).replaceAll("\\<.*?\\>", ""); 
										if(des.length() > 200)
										{
											des = des.substring(0,200)+" ...";
										}
										out.println(des);
									%>
								</p>
								<%=Utils.convert2DomainString(listQuestion.get(i).getTags(),language) %> 
							</li>
					<%
						}
					%>
				</ul>
				<%
				}
				%>
				<%
				if(listQuestionAnwer.size()>0)
				{
				%>
				<hr size="1"/>
				<h4><%=resource.getString("list_anwer") %>  ( <a href="/<%=language %>/author-answer/<%=listQuestionAnwer.get(0).getAliasAuthorAnwer()%>"><%=resource.getString("view_all") %></a> )</h4>
				<div class="clear"></div>
				<ul class="lq">
					<%
					
						for(int i=0;i<listQuestionAnwer.size();i++)
						{
					%>
							<li>
								<h1><a href="/<%=language %>/question/<%=listQuestionAnwer.get(i).getAlias() %>" title="<%=Replace.replace(RunLanguage.title(listQuestionAnwer.get(i),language)) %>"><%=RunLanguage.title(listQuestionAnwer.get(i),language) %></a></h1>
								<p>
									<%
										String des = RunLanguage.question(listQuestionAnwer.get(i),language).replaceAll("\\<.*?\\>", ""); 
										if(des.length() > 200)
										{
											des = des.substring(0,200)+" ...";
										}
										out.println(des);
									%>
								</p>
								<%=Utils.convert2DomainString(listQuestionAnwer.get(i).getTags(),language) %> 
							</li>
					<%
						}
					%>
				</ul>
				<%
				}
				%>
			</div>
			<div class="br">
				<jsp:include page="element/language.jsp">
					<jsp:param name="alias" value="<%=Replace.replace(author) %>"/>
					<jsp:param name="url" value="author"/>
				</jsp:include>
				<jsp:include page="element/tag.jsp">
					<jsp:param name="language" value="<%=language %>"/>
				</jsp:include>
				<jsp:include page="element/recent_view.jsp">
					<jsp:param name="language" value="<%=language %>"/>
				</jsp:include>
				<jsp:include page="element/random.jsp">
					<jsp:param name="language" value="<%=language %>"/>
				</jsp:include>

			</div>
			<div class="clear"></div>
		</div>
<jsp:include page="/layout/footer.jsp">
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>	