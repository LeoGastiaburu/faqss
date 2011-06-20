<%@page import="java.util.ArrayList"%>
<%@page import="faq.model.TagQuestion"%>
<%@page import="faq.model.Tags"%>
<%@page import="faq.model.Answer"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
Question question = (Question)request.getAttribute("faq");
List<Tags> listTags = (List<Tags>)request.getAttribute("listTags");
List<TagQuestion> listTagQuestion = (List<TagQuestion>)request.getAttribute("listTagQuestion");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
</jsp:include>
		<div class="bd">
			<div class="bl">
				<h2><%=question.getTitle() %></h2>
				<div class="clear"></div>
				<br/>
				<strong>Question by</strong> <a href="/author/<%=question.getAliasAuthor()%>" class="author"><%=question.getAuthor() %></a>
				<br/><br/>
				<%=question.getContent().getValue() %>
				<%=Utils.convert2DomainString(question.getTags()) %> 
				<br/>
				<hr size="1"/>
				<h2>Answer</h2>
				<div class="clear"></div>
				<br/>
				<strong>Answer by</strong> <a href="/author/<%=question.getAliasAuthorAnwer()%>" class="author"><%=question.getAuthorAnwer() %></a>
				<br/><br/>
				<%
				if(question.getContentAnwer() != null)
				{
					out.println(question.getContentAnwer().getValue());
				}
				%>
				<br/>
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
				<div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#appId=APP_ID&amp;xfbml=1"></script><fb:comments href="http://www.yooarticles.com/article/<%=question.getAlias() %>" width="728"></fb:comments>
			</div>
			<div class="br">
				
				<jsp:include page="element/top_right.jsp"></jsp:include>
				<%
				if(listTags.size()>0)
				{
				%>
				<h3>Tagged</h3>
				<ul class="ret">
					<%
					for(int i=0;i<listTags.size();i++)
					{
					%>
						<li><a href="/tag/<%=listTags.get(i).getAlias()%>" title="<%=Replace.remove(listTags.get(i).getName())%>"><%=listTags.get(i).getName() %></a><span class="it">× <%=listTags.get(i).getCount() %></span></li>
					<%
					}
					%>
				</ul>
				<%
				}
				%>
				<%
				if(listTagQuestion.size()>0)
				{
				%>
				<h3>Related</h3>
				<ul class="vr">
					<%
					ArrayList<String> check = new ArrayList<String>();
					for(int i=0;i<listTagQuestion.size();i++)
					{
						if(!check.contains(listTagQuestion.get(i).getAliasQuestion()))
						{
							check.add(listTagQuestion.get(i).getAliasQuestion());
							if(!listTagQuestion.get(i).getAliasQuestion().equals(question.getAlias()))
							{
					%>
								<li><a href="/question/<%=listTagQuestion.get(i).getAliasQuestion()%>" title="<%=Replace.remove(listTagQuestion.get(i).getTitleQuestion())%>"><%=listTagQuestion.get(i).getTitleQuestion() %></a></li>
					<%
							}
						}
					}
					%>
				</ul>
				<%
				}
				%>
			</div>
			<div class="clear"></div>
		</div>
<script language="javascript" type="text/javascript" src="/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/js/code.js"></script>
<script type="text/javascript" language="javascript">$(document).ready(function () { prettyPrint(); });</script>		
<%@ include file='/layout/footer.jsp'%>