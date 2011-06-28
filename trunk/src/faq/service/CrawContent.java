package faq.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

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
import faq.model.Author;
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
					URL dataURL = new URL(listQuestion.get(j).getUrl());
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
					
					
//					doc = Jsoup.connect(listQuestion.get(j).getUrl()).get();
					
					String question = doc.select("#fullQuestionBody").html();
					String answer = doc.select("#fullAnswerBody").html();
					String questionAuthor = doc.select("#hypQuestionAuthor").text();
					String answerAuthor = doc.select("#hypAnswerAuthor").text();
					Elements tags = doc.select(".topicBoxSmall");
					Date date = new Date();
					
					Text content;
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
				           	 String content2 = "";
				           	 while(1==1)
			    			 {
			    				 String str = reader.readLine();
			    				 if(str==null) break;
			    				 content2+=str;   				
			    			 }
				           	 doc = Jsoup.parse(content2);
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
					
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "de.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setDeTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setDeContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setDeContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "es.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setEsTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setEsContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setEsContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "fr.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setFrTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setFrContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setFrContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "hi.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setHiTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setHiContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setHiContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "ja.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);
						System.out.print(doc);
						listQuestion.get(j).setJaTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setJaContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setJaContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "ko.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setKoTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setKoContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setKoContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "nl.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setNlTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setNlContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setNlContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "pl.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setPlTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setPlContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setPlContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "pt.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setPtTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setPtContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setPtContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "ro.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setRoTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setRoContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setRoContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "ru.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);

						listQuestion.get(j).setRuTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setRuContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setRuContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "tr.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
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
					try {
						dataURL = new URL(listQuestion.get(j).getUrl().replaceAll("efreedom.com", "zh.efreedom.com"));
						connection1 = (HttpURLConnection) dataURL.openConnection();
						connection1.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
						connection1.setReadTimeout(500000);
						connection1.setConnectTimeout(1000000);
						
						reader1 = new BufferedReader(new InputStreamReader(connection1.getInputStream(), Charset.forName("utf-8")));
						content1 = "";
						while(1==1)
						{
							String str = reader1.readLine();
							if(str==null) break;
							content1+=str;
							
						}
						doc = Jsoup.parse(content1);
						
						listQuestion.get(j).setZhTitle(doc.select("#questionTitle").html());
						content = new Text(doc.select("#fullQuestionBody").html());
						listQuestion.get(j).setZhContent(content);
						content = new Text(doc.select("#fullAnswerBody").html());
						listQuestion.get(j).setZhContentAnwer(content);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					PersistenceManager psm1 = QnAPersistenceManager.get().getPersistenceManager();
					Query query2 = psm1.newQuery(Author.class);
					query2.setFilter("alias=='"+Replace.replace(questionAuthor)+"'");
					@SuppressWarnings("unchecked")
					List<Author> checkQuestionAuthor = (List<Author>) query2.execute();
					if(checkQuestionAuthor.size() > 0)
					{
						checkQuestionAuthor.get(0).setCountQuestion(checkQuestionAuthor.get(0).getCountQuestion()+1);
						psm1=JDOHelper.getPersistenceManager(checkQuestionAuthor.get(0));
     					psm1.currentTransaction().begin();
     					psm1.makePersistent(checkQuestionAuthor.get(0));
     					psm1.currentTransaction().commit();
					} else {
						Author author = new Author();
						author.setName(questionAuthor);
						author.setAlias(Replace.replace(questionAuthor));
						author.setCountQuestion(1);
						psm1.makePersistent(author);
					}
					
					PersistenceManager psm2 = QnAPersistenceManager.get().getPersistenceManager();
					Query query3 = psm2.newQuery(Author.class);
					query3.setFilter("alias=='"+Replace.replace(answerAuthor)+"'");
					@SuppressWarnings("unchecked")
					List<Author> checkAnwerAuthor = (List<Author>) query3.execute();
					if(checkAnwerAuthor.size() > 0)
					{
						checkAnwerAuthor.get(0).setCountQuestion(checkAnwerAuthor.get(0).getCountQuestion()+1);
						psm2=JDOHelper.getPersistenceManager(checkAnwerAuthor.get(0));
     					psm2.currentTransaction().begin();
     					psm2.makePersistent(checkAnwerAuthor.get(0));
     					psm2.currentTransaction().commit();
					} else {
						Author author = new Author();
						author.setName(answerAuthor);
						author.setAlias(Replace.replace(answerAuthor));
						author.setCountAnswer(1);
						psm2.makePersistent(author);
					}
		            
					
					listQuestion.get(j).setAuthor(questionAuthor);
					listQuestion.get(j).setAliasAuthor(Replace.replace(questionAuthor));

					content = new Text(question);
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
