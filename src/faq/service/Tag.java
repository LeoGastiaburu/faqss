package faq.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;




public class Tag {
	public Tag()
	{

		Document doc = null;
		try {

					String message = null;
					try {
						message = URLEncoder.encode("Of course absolute positioning from css and stuff. What i want to do is when i'm on the last article of a category, the next arrow to not disappear, but to link to the first article in the same category. Loop navigation.I was thinking on a filter, but verifying the next piggie thing i wrote, i think i should be shame about my php knowledge. LOL.", "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					URL url = new URL("http://ja.efreedom.com/Question/1-3017636/Mac-OS-X-%E3%81%AE%E3%82%A6%E3%82%A3%E3%83%B3%E3%83%88%E3%82%A6%E3%82%92%E3%82%B5%E3%82%A4%E3%82%B9%E5%A4%89%E6%9B%B4%E3%81%BE%E3%81%9F%E3%81%AF%E7%A7%BB%E5%8B%95%E3%81%99%E3%82%8B%E3%81%A8%E3%81%8D%E3%82%92%E6%A4%9C%E5%87%BA%E3%81%97%E3%81%BE%E3%81%99");
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setDoOutput(true);
		            connection.setRequestMethod("GET");
		           
		            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			           	 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			           	 String content = "";
			           	 while(1==1)
		    			 {
		    				 String str = reader.readLine();
		    				 if(str==null) break;
		    				 content+=str;   				
		    			 }
			           	 doc = Jsoup.parse(content);
		            }
		            
		           

		            System.out.print(doc);
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Tag();

	}
}
