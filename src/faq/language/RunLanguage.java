package faq.language;

import java.util.Hashtable;

import faq.model.Question;

public class RunLanguage {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String title(Question question,String language) {
		string.put("en", question.getTitle());
		string.put("es", (question.getEsTitle()!=null)?question.getEsTitle():"");
		string.put("de", (question.getDeTitle()!=null)?question.getDeTitle():"");
		string.put("fr", (question.getFrTitle()!=null)?question.getFrTitle():"");
		string.put("hi", (question.getHiTitle()!=null)?question.getHiTitle():"");
		string.put("ja", (question.getJaTitle()!=null)?question.getJaTitle():"");
		string.put("ko", (question.getKoTitle()!=null)?question.getKoTitle():"");
		string.put("nl", (question.getNlTitle()!=null)?question.getNlTitle():"");
		string.put("pl", (question.getPlTitle()!=null)?question.getPlTitle():"");
		string.put("pt", (question.getPtTitle()!=null)?question.getPtTitle():"");
		string.put("ro", (question.getRoTitle()!=null)?question.getRoTitle():"");
		string.put("tr", (question.getTrTitle()!=null)?question.getTrTitle():"");
		string.put("ru", (question.getRuTitle()!=null)?question.getRuTitle():"");
		string.put("zh", (question.getZhTitle()!=null)?question.getZhTitle():"");
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String question(Question question,String language) {
		string.put("en", question.getContent().getValue());
		string.put("es", (question.getEsContent()!=null)?question.getEsContent().getValue():"");
		string.put("de", (question.getDeContent()!=null)?question.getDeContent().getValue():"");
		string.put("fr", (question.getFrContent()!=null)?question.getFrContent().getValue():"");
		string.put("hi", (question.getHiContent()!=null)?question.getHiContent().getValue():"");
		string.put("ja", (question.getJaContent()!=null)?question.getJaContent().getValue():"");
		string.put("ko", (question.getKoContent()!=null)?question.getKoContent().getValue():"");
		string.put("nl", (question.getNlContent()!=null)?question.getNlContent().getValue():"");
		string.put("pl", (question.getPlContent()!=null)?question.getPlContent().getValue():"");
		string.put("pt", (question.getPtContent()!=null)?question.getPtContent().getValue():"");
		string.put("ro", (question.getRoContent()!=null)?question.getRoContent().getValue():"");
		string.put("tr", (question.getTrContent()!=null)?question.getTrContent().getValue():"");
		string.put("ru", (question.getRuContent()!=null)?question.getRuContent().getValue():"");
		string.put("zh", (question.getZhContent()!=null)?question.getZhContent().getValue():"");
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String anwer(Question question,String language) {
		string.put("en", question.getContentAnwer().getValue());
		string.put("es", (question.getEsContentAnwer()!=null)?question.getEsContentAnwer().getValue():"");
		string.put("de", (question.getDeContentAnwer()!=null)?question.getDeContentAnwer().getValue():"");
		string.put("fr", (question.getFrContentAnwer()!=null)?question.getFrContentAnwer().getValue():"");
		string.put("hi", (question.getHiContentAnwer()!=null)?question.getHiContentAnwer().getValue():"");
		string.put("ja", (question.getJaContentAnwer()!=null)?question.getJaContentAnwer().getValue():"");
		string.put("ko", (question.getKoContentAnwer()!=null)?question.getKoContentAnwer().getValue():"");
		string.put("nl", (question.getNlContentAnwer()!=null)?question.getNlContentAnwer().getValue():"");
		string.put("pl", (question.getPlContentAnwer()!=null)?question.getPlContentAnwer().getValue():"");
		string.put("pt", (question.getPtContentAnwer()!=null)?question.getPtContentAnwer().getValue():"");
		string.put("ro", (question.getRoContentAnwer()!=null)?question.getRoContentAnwer().getValue():"");
		string.put("tr", (question.getTrContentAnwer()!=null)?question.getTrContentAnwer().getValue():"");
		string.put("ru", (question.getRuContentAnwer()!=null)?question.getRuContentAnwer().getValue():"");
		string.put("zh", (question.getZhContentAnwer()!=null)?question.getZhContentAnwer().getValue():"");
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
}
