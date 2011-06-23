package faq.language;

import java.util.Hashtable;

public class Language {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String lastest(String language) {
		string.put("en", "Latest Question");
		string.put("es", "últimas preguntas");
		string.put("de", "Aktuelle Frage");
		string.put("fr", "Dernières questions");
		string.put("hi", "नवीनतम प्रश्न");
		string.put("ja", "最新の質問");
		string.put("ko", "");
		string.put("nl", "");
		string.put("pl", "");
		string.put("pt", "");
		string.put("ro", "");
		string.put("tr", "");
		string.put("ru", "");
		string.put("zh", "");
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_home(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_question(String language) {		
		string.put("en", "Question");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_tag(String language) {		
		string.put("en", "Tags");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_user(String language) {		
		string.put("en", "Authors");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_contact(String language) {		
		string.put("en", "Contact");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String recent_tag(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String random_question(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String question_by(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String other_tag(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String anwer_by(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String taged(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String related(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String author(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String list_question(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String list_anwer(String language) {		
		string.put("en", "Home page");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
}
