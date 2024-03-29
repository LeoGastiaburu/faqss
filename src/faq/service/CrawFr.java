package faq.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import java.nio.charset.Charset;


import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.appengine.api.datastore.Text;

import faq.data.QnAPersistenceManager;

import faq.model.Question;



public class CrawFr {
	public CrawFr()
	{
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Document doc;
		try {
			
			Query query = psm.newQuery(Question.class);
			query.setFilter("frTitle == ''");
			query.setOrdering("lastUpdateDate desc");
			query.setRange(0,1);
			@SuppressWarnings("unchecked")
			List<Question> listQuestion = (List<Question>) query.execute();
			
			if(listQuestion.size() > 0)
			{
				for(int j=0;j<listQuestion.size();j++)
				{
					String appId = "BB377A70C091DCD1C1F2C7EE5EE7D5A85F59D43C";
					String from = "en";
					String to = "fr";
					
					String str = listQuestion.get(j).getTitle();
					str = java.net.URLEncoder.encode(str.toString(), "ISO-8859-1");

					URL dataURL = new URL("http://api.microsofttranslator.com/v2/Http.svc/Translate?appId="+appId+"&text="+str+"&from="+from+"&to="+to);
					HttpURLConnection connection = (HttpURLConnection) dataURL.openConnection();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
					String content = "";
					str = "";
					while(1==1)
					{
						str = reader.readLine();
						if(str==null) break;
						content+=str;
						
					}
					doc = Jsoup.parse(content);
					
					String title = doc.select("string").text();
					
					listQuestion.get(j).setFrTitle(title);
					
			        str = listQuestion.get(j).getContent().getValue();

			        try {
			            URL url = new URL("http://o2tv.vn/translate.php");
			            connection = (HttpURLConnection) url.openConnection();
			            connection.setDoOutput(true);
			            connection.setRequestMethod("POST");
			            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded "); 
			            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			            writer.write("name="+str);
			            writer.write("&language=fr");
			            writer.close();
			    
			            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			            	 reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
			            	 content = "";
			            	 str = "";
			            	 while(1==1)
			     			 {
			     				 str = reader.readLine();
			     				 if(str==null) break;
			     				 content+=str;   				
			     			 }
			            	 doc = Jsoup.parse(content);
			            	 
			            	 listQuestion.get(j).setFrContent(new Text(doc.select("#content").html()));
			            } else {
			                // Server returned HTTP error code.
			            }
			        } catch (MalformedURLException e) {
			            // ...
			        } catch (IOException e) {
			            // ...
			        }
		
			        str = listQuestion.get(j).getContentAnwer().getValue();

			        try {
			            URL url = new URL("http://o2tv.vn/translate.php");
			            connection = (HttpURLConnection) url.openConnection();
			            connection.setDoOutput(true);
			            connection.setRequestMethod("POST");
			            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded "); 
			            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			            writer.write("name="+str);
			            writer.write("&language=fr");
			            writer.close();
			    
			            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			            	 reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
			            	 content = "";
			            	 str = "";
			            	 while(1==1)
			     			 {
			     				 str = reader.readLine();
			     				 if(str==null) break;
			     				 content+=str;   				
			     			 }
			            	 doc = Jsoup.parse(content);
			            	 
			            	 listQuestion.get(j).setFrContentAnwer(new Text(doc.select("#content").html()));
			            } else {
			                // Server returned HTTP error code.
			            }
			        } catch (MalformedURLException e) {
			            // ...
			        } catch (IOException e) {
			            // ...
			        }
			        
					psm=JDOHelper.getPersistenceManager(listQuestion.get(j));
 					psm.currentTransaction().begin();
 					psm.makePersistent(listQuestion.get(j));
 					psm.currentTransaction().commit();

				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new CrawContent();

	}
}
