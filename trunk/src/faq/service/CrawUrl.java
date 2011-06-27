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
import org.jsoup.select.Elements;

import faq.data.QnAPersistenceManager;
import faq.model.Craw;
import faq.model.Question;
import faq.string.Replace;



public class CrawUrl {

	public CrawUrl()
	{
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Document doc;
		try {
			Query query = psm.newQuery(Craw.class);
			List<Craw> craw = (List<Craw>) query.execute();
			int p = 0;
			if(craw.size()<=0)
			{
				Craw page = new Craw();
				page.setPage(0);
				psm.makePersistent(page);
			} else {
				p = craw.get(0).getPage();
				craw.get(0).setPage(craw.get(0).getPage()+1);
				psm=JDOHelper.getPersistenceManager(craw.get(0));
				psm.currentTransaction().begin();
				psm.makePersistent(craw.get(0));
				psm.currentTransaction().commit();
			}
			
			String url = "http://efreedom.com/Questions/"+p;
			
			URL dataURL = new URL(url);
			HttpURLConnection connection1 = (HttpURLConnection) dataURL.openConnection();
			connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
			
			connection1.setReadTimeout(500000);
			connection1.setConnectTimeout(1000000);
			
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
			String content1 = "";
			while(1==1)
			{
				String str = reader1.readLine();
				if(str==null) break;
				content1+=str;
				
			}
			doc = Jsoup.parse(content1);
			
//			doc = Jsoup.connect(url).get();
			
			Elements titles = doc.select(".topicTitle a"); 
			
			if(titles.size()>0)
			{
				for(int i=0;i<titles.size();i++)
				{
					String title = titles.get(i).text();
					Query query2 = psm.newQuery(Question.class);
					query2.setFilter("alias=='"+Replace.replace(title)+"'");
					@SuppressWarnings("unchecked")
					List<Question> check = (List<Question>)query2.execute();
					if(check.size()<=0)
					{
						Question questionInsert = new Question();
						
						questionInsert.setTitle(title);
						questionInsert.setAlias(Replace.replace(title));
						questionInsert.setUrl("http://efreedom.com"+titles.get(i).attr("href"));
						
						psm.makePersistent(questionInsert);
					}
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
