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
					
					URL url = new URL("http://o2tv.vn/tag.php");
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setDoOutput(true);
		            connection.setRequestMethod("POST");
		            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		           
		            writer.write("str="+message.replaceAll("[\\W]+", " "));
		            writer.close();
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
		            
		           

		            System.out.print(doc.select(".tag"));
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Tag();

	}
}
