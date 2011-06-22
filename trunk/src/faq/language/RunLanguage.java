package faq.language;

import java.util.Hashtable;

import faq.model.Question;

public class RunLanguage {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String title(Question question,String language) {
		string.put("en", question.getTitle());
//		string.put("es", question.getEsTitle());
//		string.put("de", question.getDeTitle());
//		string.put("fr", question.getFrTitle());
//		string.put("hi", question.getHiTitle());
//		string.put("ja", question.getJaTitle());
//		string.put("ko", question.getKoTitle());
//		string.put("nl", question.getNlTitle());
//		string.put("pl", question.getPlTitle());
//		string.put("pt", question.getPtTitle());
//		string.put("ro", question.getRoTitle());
//		string.put("tr", question.getTrTitle());
//		string.put("ru", question.getRuTitle());
//		string.put("zh", question.getZhTitle());
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String question(Question question,String language) {
		string.put("en", question.getContent().getValue());
//		string.put("es", question.getEsContent().getValue());
//		string.put("de", question.getDeContent().getValue());
//		string.put("fr", question.getFrContent().getValue());
//		string.put("hi", question.getHiContent().getValue());
//		string.put("ja", question.getJaContent().getValue());
//		string.put("ko", question.getKoContent().getValue());
//		string.put("nl", question.getNlContent().getValue());
//		string.put("pl", question.getPlContent().getValue());
//		string.put("pt", question.getPtContent().getValue());
//		string.put("ro", question.getRoContent().getValue());
//		string.put("tr", question.getTrContent().getValue());
//		string.put("ru", question.getRuContent().getValue());
//		string.put("zh", question.getZhContent().getValue());
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String anwer(Question question,String language) {
		string.put("en", question.getContentAnwer().getValue());
//		string.put("es", question.getEsContentAnwer().getValue());
//		string.put("de", question.getDeContentAnwer().getValue());
//		string.put("fr", question.getFrContentAnwer().getValue());
//		string.put("hi", question.getHiContentAnwer().getValue());
//		string.put("ja", question.getJaContentAnwer().getValue());
//		string.put("ko", question.getKoContentAnwer().getValue());
//		string.put("nl", question.getNlContentAnwer().getValue());
//		string.put("pl", question.getPlContentAnwer().getValue());
//		string.put("pt", question.getPtContentAnwer().getValue());
//		string.put("ro", question.getRoContentAnwer().getValue());
//		string.put("tr", question.getTrContentAnwer().getValue());
//		string.put("ru", question.getRuContentAnwer().getValue());
//		string.put("zh", question.getZhContentAnwer().getValue());
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
}
