<%@page contentType="text/html;charset=UTF-8" language="java"%>
<% request.setCharacterEncoding("utf-8");%>
<%
String alias = request.getParameter("alias");
String url = request.getParameter("url");
%>
<ul class="lgu">
	<li class="en"><a href="/en/<%=url %>/<%=alias %>" title="English">English</a></li>
	<li class="es"><a href="/es/<%=url %>/<%=alias %>" title="español">Español</a></li>
	<li class="de"><a href="/de/<%=url %>/<%=alias %>" title="Deutsch">Deutsch</a></li>
	<li class="fr"><a href="/fr/<%=url %>/<%=alias %>" title="français">Français</a></li>
	<li class="hi"><a href="/hi/<%=url %>/<%=alias %>" title="हिंदी">हिंदी</a></li>
	<li class="ja"><a href="/ja/<%=url %>/<%=alias %>" title="日本">日本</a></li>
	<li class="ko"><a href="/ko/<%=url %>/<%=alias %>" title="한국어">한국어</a></li>
	<li class="nl"><a href="/nl/<%=url %>/<%=alias %>" title="Nederlands">Nederlands</a></li>
	<li class="pl"><a href="/pl/<%=url %>/<%=alias %>" title="polski">Polski</a></li>
	<li class="pt"><a href="/pt/<%=url %>/<%=alias %>" title="português">Português</a></li>
	<li class="ro"><a href="/ro/<%=url %>/<%=alias %>" title="română">Română</a></li>
	<li class="tr"><a href="/tr/<%=url %>/<%=alias %>" title="Türkçe">Türkçe</a></li>
	<li class="ru"><a href="/ru/<%=url %>/<%=alias %>" title="русский">Pусский</a></li>
	<li class="zh"><a href="/zh/<%=url %>/<%=alias %>" title="中文">中文</a></li>
</ul>