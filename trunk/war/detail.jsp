<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Language"%>
<%@page import="faq.language.RunLanguage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="faq.model.TagQuestion"%>
<%@page import="faq.model.Tags"%>
<%@page import="faq.model.Answer"%>
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
Question question = (Question)request.getAttribute("faq");
List<Tags> listTags = (List<Tags>)request.getAttribute("listTags");
List<Question> listTagQuestion = (List<Question>)request.getAttribute("listTagQuestion");
List<Question> list = (List<Question>)request.getAttribute("list");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");
%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>
		<div class="bd">
			<div class="bl dtt">
				<jsp:include page="element/adv1.jsp"></jsp:include>
				<h2><%=RunLanguage.title(question,language) %></h2>
				<div class="clear"></div>
				<br/>
				<strong><%=resource.getString("question_by") %></strong> <a href="/<%=language %>/author/<%=question.getAliasAuthor()%>" class="author"><%=question.getAuthor() %></a>
				<br/><br/>
				<jsp:include page="element/adv5.jsp"></jsp:include>
				<br/>
				
				<%=RunLanguage.question(question,language) %><br/>				
			
				<script type="text/javascript"> ch_client = "habogay"; ch_width = 728; ch_height = 90; ch_type = "mpu"; ch_sid = "Chitika Default"; ch_backfill = 1; ch_color_site_link = "#0000CC"; ch_color_title = "#0000CC"; ch_color_border = "#FFFFFF"; ch_color_text = "#000000"; ch_color_bg = "#FFFFFF"; </script> <script src="http://scripts.chitika.net/eminimalls/amm.js" type="text/javascript"> </script><br/>
				
				<div class="clear"></div>
				<%=Utils.showAlltag(question.getTags(),language) %> 
				<br/>
				<hr size="1"/>
				<h2><%=resource.getString("answer") %></h2>
				<div class="clear"></div>
				<br/>
				<strong><%=resource.getString("anwer_by") %></strong> <a href="/<%=language %>/author/<%=question.getAliasAuthorAnwer()%>" class="author"><%=question.getAuthorAnwer() %></a>
				<br/><br/>
				<jsp:include page="element/adv5.jsp"></jsp:include>
				<br/><br/>
				<%=RunLanguage.anwer(question,language)%><br/>	
				<script type="text/javascript"> ch_client = "habogay"; ch_width = 728; ch_height = 90; ch_type = "mpu"; ch_sid = "Chitika Default"; ch_backfill = 1; ch_color_site_link = "#0000CC"; ch_color_title = "#0000CC"; ch_color_border = "#FFFFFF"; ch_color_text = "#000000"; ch_color_bg = "#FFFFFF"; </script> <script src="http://scripts.chitika.net/eminimalls/amm.js" type="text/javascript"> </script><br/><br/>			
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
				<div id="fb-root"></div><script src="http://connect.facebook.net/en_US/all.js#appId=APP_ID&amp;xfbml=1"></script><fb:comments href="http://www.gardenquestions.com/<%=language %>/question/<%=question.getAlias()%>" width="728"></fb:comments>
				
				<ul class="oln">
					<%
					if(list.size() > 0)
					{
						for(int i=0;i<list.size();i++)
						{
					%>
						<li>
							<h1><a href="/<%=language %>/question/<%=list.get(i).getAlias() %>" title="<%=Replace.replace(RunLanguage.title(list.get(i),language)) %>"><%=RunLanguage.title(list.get(i),language) %></a></h1>
							<p>
								<%
									String des = RunLanguage.question(list.get(i),language).replaceAll("\\<.*?\\>", ""); 
									if(des.length() > 200)
									{
										des = des.substring(0,200)+" ...";
									}
									out.println(des);
								%>
							</p>
						</li>
					<%
						}
					}
					%>
				</ul>	
			</div>
			<div class="br">
				<script type="text/javascript"> ch_client = "habogay"; ch_width = 200; ch_height = 250; ch_type = "mpu"; ch_sid = "Chitika Default"; ch_backfill = 1; ch_color_site_link = "#0000CC"; ch_color_title = "#0000CC"; ch_color_border = "#FFFFFF"; ch_color_text = "#000000"; ch_color_bg = "#FFFFFF"; </script> <script src="http://scripts.chitika.net/eminimalls/amm.js" type="text/javascript"> </script><br/><br/>
				<jsp:include page="element/detail.jsp">
					<jsp:param name="alias" value="<%=question.getAlias() %>"/>
				</jsp:include>
				<%
				if(listTags.size()>0)
				{
				%>
				<h3><%=resource.getString("taged") %></h3>
				<ul class="ret">
					<%
					for(int i=0;i<listTags.size();i++)
					{
					%>
						<li><a href="/<%=language %>/tag/<%=listTags.get(i).getAlias()%>" title="<%=Replace.remove(listTags.get(i).getName())%>"><%=listTags.get(i).getName() %></a><span class="it"> x <%=listTags.get(i).getCount() %></span></li>
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
				<h3><%=resource.getString("list_question") %></h3>
				<ul class="vr">
					<%
					ArrayList<String> check = new ArrayList<String>();
					for(int i=0;i<listTagQuestion.size();i++)
					{
					%>
						<li><a href="/<%=language %>/question/<%=listTagQuestion.get(i).getAlias()%>" title="<%=Replace.remove(RunLanguage.title(listTagQuestion.get(i),language))%>"><%=RunLanguage.title(listTagQuestion.get(i),language) %></a></li>
					<%
					}
					%>
				</ul>
				<%
				}
				%>
				<jsp:include page="element/new.jsp">
					<jsp:param name="language" value="<%=language %>"/>
				</jsp:include>
			</div>
			<div class="clear"></div>
		</div>
<script language="javascript" type="text/javascript" src="/js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="/js/code.js"></script>
<script type="text/javascript" language="javascript">$(document).ready(function () { prettyPrint(); });</script>		
<jsp:include page="/layout/footer.jsp">
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>	