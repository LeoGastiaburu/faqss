package faq.string;


public class Replace {
	public static String replace(String str) {
	    str = str.replaceAll("[\\W]+", "-");
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
