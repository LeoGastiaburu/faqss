<%@page import="faq.language.RunLanguage"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="faq.language.Language"%>
<%@page import="faq.string.Replace"%>
<%@page import="java.util.List"%>
<%@page import="faq.model.Question"%>
<%@page import="javax.jdo.Query"%>
<%@page import="faq.data.QnAPersistenceManager"%>
<%@page import="javax.jdo.PersistenceManager"%>
<%
PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
Query query = psm.newQuery(Question.class);
query.setFilter("date != null");
query.setOrdering("date desc");
query.setRange(0,10);
List<Question> listQuestion = (List<Question>)query.execute();
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>
<%
if(listQuestion.size()>0)
{
%>
<h3><%=resource.getString("random_question") %></h3>
<ul class="vr">
	<%
	for(int i=0;i<listQuestion.size();i++)
	{
	%>
		<li><a href="/<%=language %>/question/<%=listQuestion.get(i).getAlias()%>" title="<%=Replace.remove(RunLanguage.title(listQuestion.get(i),language))%>"><%=RunLanguage.title(listQuestion.get(i),language) %></a></li>
	<%
	}
	%>
</ul>
<%
}
%>