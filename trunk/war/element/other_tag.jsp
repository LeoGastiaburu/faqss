<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Tags"%>
<%@page import="javax.jdo.Query"%>
<%@page import="faq.data.QnAPersistenceManager"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%
String start = request.getParameter("start"); 
String language = request.getParameter("language"); 
PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
Query query = psm.newQuery(Tags.class);
query.setOrdering("date asc");
query.setRange(0,50);
List<Tags> listTags = (List<Tags>) query.execute();
%>
<%
if(listTags.size()>0)
{
%>
<h3>Other tags</h3>
<ul class="ret">
	<%
	for(int i=0;i<listTags.size();i++)
	{
	%>
		<li><a href="/tag/<%=language %>/<%=listTags.get(i).getAlias()%>" title="<%=Replace.remove(listTags.get(i).getName())%>"><%=listTags.get(i).getName() %></a><span class="it">× <%=listTags.get(i).getCount() %></span></li>
	<%
	}
	%>
</ul>
<%
}
%>