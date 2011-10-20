<%@page import="net.sf.jsr107cache.CacheException"%>
<%@page import="java.util.Collections"%>
<%@page import="net.sf.jsr107cache.CacheManager"%>
<%@page import="net.sf.jsr107cache.Cache"%>
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
Cache cache = null;
try {
    cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
} catch (CacheException e) {
   e.printStackTrace();
   
}
Question question = null;
if(cache.containsKey("new"))
{
	question = (Question)cache.get("new");
%>
<%
if(question != null)
{
%>
<h3>New Question</h3>
<ul class="vr">
		<li><a href="/en/question/<%=question.getAlias()%>" ><%=(question.getTitle()!=null)?question.getTitle():"" %></a></li>
		<li><a href="/es/question/<%=question.getAlias()%>" ><%=(question.getEsTitle()!=null)?question.getEsTitle():"" %></a></li>
		<li><a href="/de/question/<%=question.getAlias()%>" ><%=(question.getDeTitle()!=null)?question.getDeTitle():"" %></a></li>
		<li><a href="/fr/question/<%=question.getAlias()%>" ><%=(question.getFrTitle()!=null)?question.getFrTitle():"" %></a></li>
		<li><a href="/hi/question/<%=question.getAlias()%>" ><%=(question.getHiTitle()!=null)?question.getHiTitle():"" %></a></li>
		<li><a href="/ja/question/<%=question.getAlias()%>" ><%=(question.getJaTitle()!=null)?question.getJaTitle():"" %></a></li>
		<li><a href="/ko/question/<%=question.getAlias()%>" ><%=(question.getKoTitle()!=null)?question.getKoTitle():"" %></a></li>
		<li><a href="/nl/question/<%=question.getAlias()%>" ><%=(question.getNlTitle()!=null)?question.getNlTitle():"" %></a></li>
		<li><a href="/pl/question/<%=question.getAlias()%>" ><%=(question.getPlTitle()!=null)?question.getPlTitle():"" %></a></li>
		<li><a href="/pt/question/<%=question.getAlias()%>" ><%=(question.getPtTitle()!=null)?question.getPtTitle():"" %></a></li>
		<li><a href="/ro/question/<%=question.getAlias()%>" ><%=(question.getRoTitle()!=null)?question.getRoTitle():"" %></a></li>
		<li><a href="/tr/question/<%=question.getAlias()%>" ><%=(question.getTrTitle()!=null)?question.getTrTitle():"" %></a></li>
		<li><a href="/ru/question/<%=question.getAlias()%>" ><%=(question.getRuTitle()!=null)?question.getRuTitle():"" %></a></li>
		<li><a href="/zh/question/<%=question.getAlias()%>" ><%=(question.getZhTitle()!=null)?question.getZhTitle():"" %></a></li>
</ul>
<%
}
}
%>