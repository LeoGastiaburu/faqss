<%@page contentType="text/html;charset=UTF-8" language="java"%>
<% request.setCharacterEncoding("utf-8");%>
<%
String alias = request.getParameter("alias");
%>
<ul class="lgu">
	<li class="en"><a href="/en/question/<%=alias %>" title="English">English</a></li>
	<li class="es"><a href="/es/question/<%=alias %>" title="español">Español</a></li>
	<li class="de"><a href="/de/question/<%=alias %>" title="Deutsch">Deutsch</a></li>
	<li class="fr"><a href="/fr/question/<%=alias %>" title="français">Français</a></li>
	<li class="hi"><a href="/hi/question/<%=alias %>" title="हिंदी">हिंदी</a></li>
	<li class="ja"><a href="/ja/question/<%=alias %>" title="日本">日本</a></li>
	<li class="ko"><a href="/ko/question/<%=alias %>" title="한국어">한국어</a></li>
	<li class="nl"><a href="/nl/question/<%=alias %>" title="Nederlands">Nederlands</a></li>
	<li class="pl"><a href="/pl/question/<%=alias %>" title="polski">Polski</a></li>
	<li class="pt"><a href="/pt/question/<%=alias %>" title="português">Português</a></li>
	<li class="ro"><a href="/ro/question/<%=alias %>" title="română">Română</a></li>
	<li class="tr"><a href="/tr/question/<%=alias %>" title="Türkçe">Türkçe</a></li>
	<li class="ru"><a href="/ru/question/<%=alias %>" title="русский">Pусский</a></li>
	<li class="zh"><a href="/zh/question/<%=alias %>" title="中文">中文</a></li>
</ul>