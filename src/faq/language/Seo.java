package faq.language;

import java.util.Hashtable;

import faq.model.Question;

public class Seo {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String title(String language) {
		string.put("en", "Garden questions for developer");
		return (string.get(language) != null)?string.get(language):string.get("en");
	}
	public static String keyword(String language) {
		string.put("en", "Garden questions,developer,c#,java,php,ubutu,mysql,sql,google app engine,linux,centos");
		return (string.get(language) != null)?string.get(language):string.get("en");
	}
	public static String description(String language) {
		string.put("en", "Garden questions and answers for programming, software, hardware, computer");
		return (string.get(language) != null)?string.get(language):string.get("en");
	}
}
