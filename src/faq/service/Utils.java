package faq.service;

import java.util.List;

public class Utils {

	public static String convert2DomainString(List list)
	{
		
		String str="";
		int k=0;
		for(Object jString : list)
		{
			str+="<a href=\"/tag/"+jString+"\" class='tag'>"+jString+"</a> ";
			k++;
			if(k >= 14)break;	
		}
		return str;
	}
	
}
