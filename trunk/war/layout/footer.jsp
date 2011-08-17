
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
           	<a href="http://www.childsgame.net/" target="_blank">Childsgame</a> | 
           	<a href="http://www.yooarticles.com/" target="_blank">Submit your Articles in YooArticles</a> |
           	<a href="http://prapi.net/" target="_blank">PrApi</a> |
			<a href="http://www.bogay.net/" target="_blank">View information your compan</a> |
			<a href="http://showsiteinfo.appspot.com/" target="_blank">View Westpac in showsiteinfo</a> <br/>
			<a href="http://www.domaintips.net/" target="_blank">View Westpac in domaintips</a>
		</div>
	</body>
</html>		