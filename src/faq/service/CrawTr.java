package faq.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

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



public class CrawTr {
	public CrawTr()
	{
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Document doc;
		try {
			
			Query query = psm.newQuery(Question.class);
			query.setFilter("trTitle == null");
			query.setRange(0,1);
			@SuppressWarnings("unchecked")
			List<Question> listQuestion = (List<Question>) query.execute();
			
			if(listQuestion.size() > 0)
			{
				for(int j=0;j<listQuestion.size();j++)
				{
					URL dataURL = new URL(listQuestion.get(j).getUrl());
					HttpURLConnection connection1;
					
					BufferedReader reader1;
					String content1 = "";
					
					
					Text content;
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "tr.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");

						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setTrTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setTrContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setTrContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
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
