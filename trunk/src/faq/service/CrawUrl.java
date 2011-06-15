package faq.service;

import java.io.IOException;

import javax.jdo.PersistenceManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import faq.data.QnAPersistenceManager;
import faq.model.Question;
import faq.string.Replace;



public class CrawUrl {

	public CrawUrl()
	{
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Document doc;
		try {
			String url = "http://efreedom.com/Questions/0/";
			doc = Jsoup.connect(url).get();
			
			Elements titles = doc.select(".topicTitle a"); 
			
			if(titles.size()>0)
			{
				for(int i=0;i<titles.size();i++)
				{
					Question questionInsert = new Question();
					
					String title = titles.get(i).text();
					
					questionInsert.setTitle(title);
					questionInsert.setAlias(Replace.replace(title));
					questionInsert.setUrl("http://efreedom.com"+titles.get(i).attr("href"));
					
					psm.makePersistent(questionInsert);
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CrawUrl();

	}
}
