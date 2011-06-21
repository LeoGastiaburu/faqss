<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page import="javax.jdo.Query"%>
<%@page import="faq.data.QnAPersistenceManager"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%
String author = request.getParameter("author");
String alias = request.getParameter("alias");
PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
Query query = psm.newQuery(Question.class);
query.setFilter("aliasAuthorAnwer == '"+alias+"'");
query.setOrdering("date desc");
query.setRange(0,10);
List<Question> listQuestion = (List<Question>)query.execute();
String language = request.getParameter("language"); 
%>
<%
if(listQuestion.size()>0)
{
%>
<h3><%=author %>'s answers</h3>
<ul class="vr">
	<%
	for(int i=0;i<listQuestion.size();i++)
	{
	%>
		<li><a href="/<%=language %>/question/<%=listQuestion.get(i).getAlias()%>" title="<%=Replace.remove(listQuestion.get(i).getTitle())%>"><%=listQuestion.get(i).getTitle() %></a></li>
	<%
	}
	%>
</ul>
<%
}
%>