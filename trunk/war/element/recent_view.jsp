<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.cache.CacheManager"%>
<%@page import="javax.cache.CacheException"%>
<%@page import="javax.cache.Cache"%>
<%
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
Cache cache=null;

try {
    cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
} catch (CacheException e) {
   e.printStackTrace();
   
}
%>
<%
if(cache!=null&&cache.containsKey("lastPing"))
{
%>
	<h3><%=resource.getString("recent_view_question") %></h3>
	<ul class="vr">
<%	
	ArrayList<String> lastView = (ArrayList<String>)cache.get("lastPing");
	for(String faq : lastView) 
	{
%>		
		<li><a href="/<%=language %>/question/<%=Replace.replace(faq)%>" title="<%=Replace.remove(faq)%>"><%=faq %></a></li>	
<%
	}
%>
	</ul>
<%
}
%>