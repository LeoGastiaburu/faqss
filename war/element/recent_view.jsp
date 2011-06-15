<%@page import="faq.string.Replace"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.cache.CacheManager"%>
<%@page import="javax.cache.CacheException"%>
<%@page import="javax.cache.Cache"%>
<%
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
	<h3>Recent view question</h3>
	<ul class="vr">
<%	
	ArrayList<String> lastView = (ArrayList<String>)cache.get("lastPing");
	for(String faq : lastView) 
	{
%>		
		<li><a href="/question/<%=Replace.replace(faq)%>" title="<%=Replace.remove(faq)%>"><%=faq %></a></li>	
<%
	}
%>
	</ul>
<%
}
%>