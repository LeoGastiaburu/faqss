<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Tags"%>
<%@page import="javax.jdo.Query"%>
<%@page import="faq.data.QnAPersistenceManager"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%
PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
Query query = psm.newQuery(Tags.class);
query.setOrdering("lastUpdateDate desc");
query.setRange(0,30);
List<Tags> listTags = (List<Tags>) query.execute();
%>
<%
if(listTags.size()>0)
{
%>
<h3>Recent tags</h3>
<ul class="ret">
	<%
	for(int i=0;i<listTags.size();i++)
	{
	%>
		<li><a href="/tag/<%=listTags.get(i).getAlias()%>" title="<%=Replace.remove(listTags.get(i).getName())%>"><%=listTags.get(i).getName() %></a><span class="it">� <%=listTags.get(i).getCount() %></span></li>
	<%
	}
	%>
</ul>
<%
}
%>