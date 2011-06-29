<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Seo"%>
<%@page import="faq.language.RunLanguage"%>
<%@page import="faq.model.Tags"%>
<%@page import="faq.model.TagQuestion"%>
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
List<Tags> tags = (List<Tags>) request.getAttribute("tags");
String start = (String) request.getAttribute("start");
String url = (String) request.getAttribute("url");
String cur_page = (String) request.getAttribute("page");
String tag = "";
if(tags.size() > 0)
{
	tag = tags.get(0).getName();
}
String title = resource.getString("page")+" "+cur_page+" - "+resource.getString("tag")+" : "+tag;
String description = title+resource.getString("description");
String keywords = tag+","+resource.getString("keyword");

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<h2><%=resource.getString("tag") %> : <% if(tags.size() > 0){out.print(tags.get(0).getName());} %></h2>
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
								<h1><a href="/<%=language %>/question/<%=listQuestion.get(i).getAlias() %>" title="<%=Replace.replace(RunLanguage.title(listQuestion.get(i),language)) %>"><%=RunLanguage.title(listQuestion.get(i),language) %></a></h1>
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
					}
					%>
					<li class="paginate">
						<jsp:include page="paginate.jsp">
							<jsp:param name="cur_page" value="<%=cur_page %>"/>
							<jsp:param name="url" value="<%=url %>"/>
							<jsp:param name="number_game" value="<%=listQuestion.size() %>"/>
						</jsp:include>
					</li>
				</ul>
			</div>
			<div class="br">
				
				<jsp:include page="element/language.jsp">
					<jsp:param name="alias" value="<%=Replace.tag(tag) %>"/>
					<jsp:param name="url" value="tag"/>
				</jsp:include>
				<jsp:include page="element/other_tag.jsp">
					<jsp:param name="start" value="<%=start %>"/>
					<jsp:param name="language" value="<%=language %>"/>
				</jsp:include>

			</div>
			<div class="clear"></div>
		</div>
<jsp:include page="/layout/footer.jsp">
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>	