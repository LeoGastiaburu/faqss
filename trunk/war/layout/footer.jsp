
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>

		<div class="ft">
			<%=resource.getString("footer") %>
		</div>
	</body>
</html>		