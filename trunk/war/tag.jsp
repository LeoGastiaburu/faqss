<%@page import="faq.model.Tags"%>
<%@page import="faq.model.TagQuestion"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
List<TagQuestion> listQuestion = (List<TagQuestion>)request.getAttribute("listQuestion");
List<Tags> tags = (List<Tags>) request.getAttribute("tags");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");
String start = (String) request.getAttribute("start");
%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<h2>Tag : <% if(tags.size() > 0){out.print(tags.get(0).getName());} %></h2>
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
				<ul class="lq">
					<%
					if(listQuestion.size()>0)
					{
						for(int i=0;i<listQuestion.size();i++)
						{
					%>
							<li>
								<h1><a href="/question/<%=listQuestion.get(i).getAliasQuestion() %>" title="<%=Replace.replace(listQuestion.get(i).getTitleQuestion()) %>"><%=listQuestion.get(i).getTitleQuestion() %></a></h1>
								<p>
									<%
										out.println(listQuestion.get(i).getDesQuestion());
									%>
								</p>
								<%=Utils.convert2DomainString(listQuestion.get(i).getTags()) %>  
							</li>
					<%
						}
					}
					%>
				</ul>
			</div>
			<div class="br">
				
				<jsp:include page="element/top_right.jsp"></jsp:include>
				<jsp:include page="element/other_tag.jsp">
					<jsp:param name="start" value="<%=start %>"/>
				</jsp:include>

			</div>
			<div class="clear"></div>
		</div>
<%@ include file='/layout/footer.jsp'%>