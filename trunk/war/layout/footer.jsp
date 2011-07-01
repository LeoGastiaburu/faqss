
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>

		<div class="ft">
			<%=resource.getString("footer") %>
			<br/><br/>
           	Featured sites : 
           	<a href="http://www.childsgame.net/">Childsgame.net</a> | 
           	<a href="http://www.yooarticles.com/">Yooarticles.com</a> |
           	<a href="http://prapi.net/">Prapi.net</a> |
			<a href="http://www.bogay.net/">Bogay.net</a> |
			<a href="http://showsiteinfo.appspot.com/">Showsiteinfo.appspot.com</a> 
		</div>
	</body>
</html>		