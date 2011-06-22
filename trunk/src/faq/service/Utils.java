package faq.service;

import java.util.List;

import faq.string.Replace;

public class Utils {

	public static String convert2DomainString(List list,String language)
	{
		
		String str="";
		int k=0;
		for(Object jString : list)
		{
			str+="<a href=\"/"+language+"/tag/"+Replace.tag(jString.toString())+"\" class='tags'>"+jString+"</a> ";
			k++;
			if(k >= 7)break;	
		}
		return str;
	}
	public static String showAlltag(List list,String language)
	{
		
		String str="";
		for(Object jString : list)
		{
			str+="<a href=\"/"+language+"/tag/"+Replace.tag(jString.toString())+"\" class='tags'>"+jString+"</a> ";	
		}
		return str;
	}
}
