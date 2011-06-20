<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");
String tag = "contact";
%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="tag" value="<%=tag %>"/>
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
</jsp:include>

		<div class="bd">
			<div class="bl">
				<h2>Contact</h2>
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
						If you have any questions, or comments and suggestions, please use the form below to contact us. Or you can mail to contact [at] yooarticles.com .
						<br/><br/>
						<form action="/sendmail" method="post" class="send_mail">
							Your name :<br/>
							<input  type="text" name="name"/>
							Your email :<br/>
							<input  type="text" name="email"/>
							Message :<br/>
							<textarea name="message"></textarea>
							<button type="submit">Send</button>
						</form>
					</li>
				</ul>
			</div>
			<div class="br">
				
				<jsp:include page="element/top_right.jsp"></jsp:include>
				<jsp:include page="element/recent_view.jsp"></jsp:include>
				<jsp:include page="element/random.jsp"></jsp:include>

			</div>
			<div class="clear"></div>
		</div>
<%@ include file='/layout/footer.jsp'%>