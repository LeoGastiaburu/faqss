package faq.language;

import java.util.Hashtable;

import faq.model.Question;

public class Seo {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String title(String language) {
		string.put("en", "Garden questions for developer");
		string.put("es", "Preguntas de jardín para desarrolladores");
		string.put("de", "Garden Fragen für Entwickler");
		string.put("fr", "Questions Jardin pour les développeurs");
		string.put("hi", "");
		string.put("ja", "");
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
	public static String keyword(String language) {
		string.put("en", "Garden questions,developer,c#,java,php,ubutu,mysql,sql,google app engine,linux,centos");
		string.put("es", "Preguntas jardín, desarrollador de C #, Java, PHP, ubutu, MySQL, SQL, Google App Engine, linux, centos");
		string.put("de", "Garden Fragen, Entwickler, C #, Java, PHP, ubutu, MySQL, SQL, Google App Engine, Linux, CentOS");
		string.put("fr", "Questions de jardin, développeur, C #, Java, PHP, ubutu, MySQL, SQL, Google App Engine, Linux, CentOS");
		string.put("hi", "");
		string.put("ja", "");
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
	public static String description(String language) {
		string.put("en", "Garden questions and answers for programming, software, hardware, computer");
		string.put("es", "Jardín preguntas y respuestas para la programación, software, hardware, equipo");
		string.put("de", "Garten Fragen und Antworten für die Programmierung, Software, Hardware, Computer");
		string.put("fr", "Jardin des questions et réponses pour la programmation, logiciels, matériel, informatique");
		string.put("hi", "");
		string.put("ja", "");
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
}
