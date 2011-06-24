<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Seo"%>
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
String title = resource.getString("contact_us");
String description = title+"."+resource.getString("description");
String keywords = resource.getString("keyword");
String tag = "contact";

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="tag" value="<%=tag %>"/>
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
	<jsp:param name="language" value="<%=language %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<h2><%=resource.getString("menu_contact") %></h2>
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
					<li>
						<%=resource.getString("text_contact") %>
						<br/><br/>
						<form action="/sendmail" method="post" class="send_mail">
							<%=resource.getString("your_name") %> :<br/>
							<input  type="text" name="name"/>
							<%=resource.getString("your_email") %> :<br/>
							<input  type="text" name="email"/>
							<%=resource.getString("message") %> :<br/>
							<textarea name="message"></textarea>
							<button type="submit"><%=resource.getString("send") %></button>
						</form>
					</li>
				</ul>
			</div>
			<div class="br">
				
				<jsp:include page="element/top_right.jsp"></jsp:include>
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