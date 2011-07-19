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
query.setOrdering("lastUpdateDate desc");
query.setRange(0,1);
List<Question> listQuestion = (List<Question>)query.execute();
String language = request.getParameter("language");
ResourceBundle resource = ResourceBundle.getBundle("language", new Locale(language));
%>
<%
if(listQuestion.size()>0)
{
%>
<h3>New Question</h3>
<ul class="vr">
	<%
	for(int i=0;i<listQuestion.size();i++)
	{
	%>
		<li><a href="/en/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getTitle()!=null)?listQuestion.get(i).getTitle():"" %></a></li>
		<li><a href="/es/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getEsTitle()!=null)?listQuestion.get(i).getEsTitle():"" %></a></li>
		<li><a href="/de/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getDeTitle()!=null)?listQuestion.get(i).getDeTitle():"" %></a></li>
		<li><a href="/fr/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getFrTitle()!=null)?listQuestion.get(i).getFrTitle():"" %></a></li>
		<li><a href="/hi/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getHiTitle()!=null)?listQuestion.get(i).getHiTitle():"" %></a></li>
		<li><a href="/ja/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getJaTitle()!=null)?listQuestion.get(i).getJaTitle():"" %></a></li>
		<li><a href="/ko/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getKoTitle()!=null)?listQuestion.get(i).getKoTitle():"" %></a></li>
		<li><a href="/nl/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getNlTitle()!=null)?listQuestion.get(i).getNlTitle():"" %></a></li>
		<li><a href="/pl/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getPlTitle()!=null)?listQuestion.get(i).getPlTitle():"" %></a></li>
		<li><a href="/pt/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getPtTitle()!=null)?listQuestion.get(i).getPtTitle():"" %></a></li>
		<li><a href="/ro/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getRoTitle()!=null)?listQuestion.get(i).getRoTitle():"" %></a></li>
		<li><a href="/tr/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getTrTitle()!=null)?listQuestion.get(i).getTrTitle():"" %></a></li>
		<li><a href="/ru/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getRuTitle()!=null)?listQuestion.get(i).getRuTitle():"" %></a></li>
		<li><a href="/zh/question/<%=listQuestion.get(i).getAlias()%>" ><%=(listQuestion.get(i).getZhTitle()!=null)?listQuestion.get(i).getZhTitle():"" %></a></li>
	<%
	}
	%>
</ul>
<%
}
%>