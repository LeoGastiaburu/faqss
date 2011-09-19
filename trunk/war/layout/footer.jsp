
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-5862823-5']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
		<div class="ft">
			<%=resource.getString("footer") %>
			<br/><br/>
           	Featured sites : 
           	<a href="http://www.childsgame.net/" target="_blank">Childsgame</a> | 
           	<a href="http://www.yooarticles.com/" target="_blank">Submit your Articles in YooArticles</a> |
           	<a href="http://prapi.net/" target="_blank">PrApi</a> |
			<a href="http://www.bogay.net/" target="_blank">View information your company</a> |
			<a href="http://www.showsiteinfo.appspot.com/" target="_blank">View infomation site in showsiteinfo</a> <br/>
			<a href="http://www.domaintips.net/" target="_blank">View infomation site in domaintips</a>
			<br/>  
			<img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" />
		</div>
	</body>
</html>		