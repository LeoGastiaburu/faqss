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
import java.util.Date;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.appengine.api.datastore.Text;

import faq.data.QnAPersistenceManager;
import faq.model.Answer;
import faq.model.Question;
import faq.model.TagQuestion;
import faq.model.Tags;
import faq.string.Replace;


public class CrawContent {
	public CrawContent()
	{
		PersistenceManager psm = QnAPersistenceManager.get().getPersistenceManager();
		Document doc;
		try {
			
			Query query = psm.newQuery(Question.class);
			query.setFilter("lastUpdateDate == null");
			query.setRange(0,1);
			@SuppressWarnings("unchecked")
			List<Question> listQuestion = (List<Question>) query.execute();
			
			if(listQuestion.size() > 0)
			{
				for(int j=0;j<listQuestion.size();j++)
				{
					doc = Jsoup.connect(listQuestion.get(j).getUrl()).get();
					
					String question = doc.select("#fullQuestionBody").html();
					String answer = doc.select("#fullAnswerBody").html();
					String questionAuthor = doc.select("#hypQuestionAuthor").text();
					String answerAuthor = doc.select("#hypAnswerAuthor").text();
					Elements tags = doc.select(".topicBoxSmall");
					Date date = new Date();
		            
		            ArrayList<String> term = new ArrayList<String>();
		            
		            if(tags.size() > 0)
					{
						for(int i=0;i<tags.size();i++)
						{
							 if(!term.contains(tags.get(i).text().toLowerCase())) {
				            	 term.add(tags.get(i).text().toLowerCase());
				             }
						}
					}
		            try {
		            	String message = doc.select("#fullQuestionBody").select("p").text().replaceAll("\\<.*?\\>", "");
						
						URL url = new URL("http://o2tv.vn/tag.php");
			            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			            connection.setReadTimeout(500000);
						connection.setConnectTimeout(1000000);
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
		            	
			            Elements nou = doc.select(".tag");
			   
			            if(nou.size() > 0)
			            {
			            	for(int i = 0;i<nou.size();i++)
			            	{
					            if(!term.contains(nou.get(i).text().toLowerCase())) {
					            	term.add(nou.get(i).text().toLowerCase());
					            }
			            	}
			            }
		            } catch (Exception e) {
						// TODO: handle exception
					}
					int size = term.size();
					if(size > 30)
					{
						size = 30;
					}
					if(term.size() > 0)
					{
						for(int i=0;i<size;i++)
						{
							if(!term.get(i).equals("m") && !term.get(i).equals("t"))
							{
								listQuestion.get(j).addTags(term.get(i));
								
								TagQuestion tagQuestion = new TagQuestion();

								tagQuestion.setAliasTag(Replace.tag(term.get(i)));
								tagQuestion.setAliasQuestion(listQuestion.get(j).getAlias());
								
								psm.makePersistent(tagQuestion);
								
								PersistenceManager psms = QnAPersistenceManager.get().getPersistenceManager();
								Query query_tag = psms.newQuery(Tags.class);
								query_tag.setFilter("alias=='"+Replace.tag(term.get(i))+"'");
								@SuppressWarnings("unchecked")
								List<Tags> check_tag = (List<Tags>) query_tag.execute();
								if(check_tag.size() > 0)
								{
									check_tag.get(0).setCount(check_tag.get(0).getCount()+1);
									psms=JDOHelper.getPersistenceManager(check_tag.get(0));
			     					psms.currentTransaction().begin();
			     					psms.makePersistent(check_tag.get(0));
			     					psms.currentTransaction().commit();
								} else {
									Tags tag = new Tags();
									tag.setName(term.get(i));
									tag.setAlias(Replace.tag(term.get(i)));
									tag.setLastUpdateDate(date);
									tag.setCount(1);
									psms.makePersistent(tag);
								}
							}
						}
					}
					

					listQuestion.get(j).setAuthor(questionAuthor);
					listQuestion.get(j).setAliasAuthor(Replace.replace(questionAuthor));

					Text content = new Text(question);
					listQuestion.get(j).setContent(content);
					
					listQuestion.get(j).setLastUpdateDate(date);
					listQuestion.get(j).setDate(date);
					content = new Text(answer);
					listQuestion.get(j).setContentAnwer(content);	
					listQuestion.get(j).setAuthorAnwer(answerAuthor);
					listQuestion.get(j).setAliasAuthorAnwer(Replace.replace(answerAuthor));
					
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
