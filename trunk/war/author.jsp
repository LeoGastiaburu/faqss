<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
List<Question> listQuestion = (List<Question>)request.getAttribute("listQuestion");
List<Question> listQuestionAnwer = (List<Question>)request.getAttribute("listQuestionAnwer");
String author = (String)request.getAttribute("author");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");

if(listQuestion.size()>0)
{
	author = listQuestion.get(0).getAuthor();
}
if(listQuestionAnwer.size()>0)
{
	author = listQuestionAnwer.get(0).getAuthorAnwer();
}

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<h2>Author : <%=author %></h2>
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
				<%
				if(listQuestion.size()>0)
				{
				%>
				<hr size="1"/>
				<h4>List questions   ( <a href="/author-question/<%=listQuestion.get(0).getAliasAuthor()%>">View all</a> )</h4>
				<div class="clear"></div>
				<ul class="lq">
					<%
						for(int i=0;i<listQuestion.size();i++)
						{
					%>
							<li>
								<h1><a href="/question/<%=listQuestion.get(i).getAlias() %>" title="<%=Replace.replace(listQuestion.get(i).getTitle()) %>"><%=listQuestion.get(i).getTitle() %></a></h1>
								<p>
									<%
										String des = listQuestion.get(i).getContent().getValue().replaceAll("\\<.*?\\>", ""); 
										if(des.length() > 200)
										{
											des = des.substring(0,200)+" ...";
										}
										out.println(des);
									%>
								</p>
								<%=Utils.convert2DomainString(listQuestion.get(i).getTags()) %> 
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
				<h4>List anwers  ( <a href="/author-anwer/<%=listQuestionAnwer.get(0).getAliasAuthorAnwer()%>">View all</a> )</h4>
				<div class="clear"></div>
				<ul class="lq">
					<%
					
						for(int i=0;i<listQuestionAnwer.size();i++)
						{
					%>
							<li>
								<h1><a href="/question/<%=listQuestionAnwer.get(i).getAlias() %>" title="<%=Replace.replace(listQuestionAnwer.get(i).getTitle()) %>"><%=listQuestionAnwer.get(i).getTitle() %></a></h1>
								<p>
									<%
										String des = listQuestionAnwer.get(i).getContent().getValue().replaceAll("\\<.*?\\>", ""); 
										if(des.length() > 200)
										{
											des = des.substring(0,200)+" ...";
										}
										out.println(des);
									%>
								</p>
								<%=Utils.convert2DomainString(listQuestionAnwer.get(i).getTags()) %> 
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
				
				<jsp:include page="element/top_right.jsp"></jsp:include>
				<jsp:include page="element/tag.jsp"></jsp:include>
				<jsp:include page="element/recent_view.jsp"></jsp:include>
				<jsp:include page="element/random.jsp"></jsp:include>

			</div>
			<div class="clear"></div>
		</div>
<%@ include file='/layout/footer.jsp'%>