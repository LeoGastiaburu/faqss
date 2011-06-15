<%@page import="faq.model.Answer"%>
<%@page import="faq.service.Utils"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%
Question question = (Question)request.getAttribute("faq");
Answer answer = (Answer)request.getAttribute("answer");
String title = (String) request.getAttribute("title");
String description = (String) request.getAttribute("description");
String keywords = (String) request.getAttribute("keyword");

%>
<jsp:include page="layout/header.jsp">
	<jsp:param name="title" value="<%=title %>"/>
	<jsp:param name="description" value="<%=description %>"/>
	<jsp:param name="keywords" value="<%=keywords %>"/>
</jsp:include>
<script language="javascript" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="http://efreedom.com/Javascript/Prettify/Prettify.js"></script>
<script type="text/javascript" language="javascript">$(document).ready(function () { prettyPrint(); });</script>
		<div class="bd">
			<div class="bl">
				<h2><%=question.getTitle() %></h2>
				<div class="clear"></div>
				<%=question.getContent().getValue() %>
				<%=Utils.convert2DomainString(question.getTags()) %> 
				<br/>
				<hr size="1"/>
				<h2>Answer</h2>
				<div class="clear"></div>
				<%
				if(answer != null)
				{
					out.println(answer.getContent().getValue());
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