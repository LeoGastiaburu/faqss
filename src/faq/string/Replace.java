package faq.string;


public class Replace {
	public static String replace(String str) {
	    str = str.replaceAll("[\\W]+", "-");
	    str = str.replaceAll("^-","");
	    str = str.replaceAll("-$","");
	    str = str.toLowerCase();
	    return str;
    }
	public static String tag(String str) {
		str = str.replaceAll("\\#", "Sharp");
		str = str.replaceAll("\\+", "Plus");
	    str = str.replaceAll("[^.\\w]+", "-");
	    str = str.replaceAll("^-","");
	    str = str.replaceAll("-$","");
	    str = str.toLowerCase();
	    return str;
    }
	public static String remove(String str) {
	    str = str.replaceAll("[\'\"]+", "&quot;");
	    return str;
    }
}
