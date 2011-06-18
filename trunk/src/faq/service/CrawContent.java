package faq.service;


import java.io.IOException;

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
			query.setRange(0,2);
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
					
					if(tags.size() > 0)
					{
						for(int i=0;i<tags.size();i++)
						{
							listQuestion.get(j).addTags(tags.get(i).text());
							
							TagQuestion tagQuestion = new TagQuestion();
							for(int k=0;k<tags.size();k++)
							{
								tagQuestion.addTags(tags.get(k).text());
							}
							tagQuestion.setAliasTag(Replace.replace(tags.get(i).text()));
							tagQuestion.setAliasQuestion(listQuestion.get(j).getAlias());
							tagQuestion.setTitleQuestion(listQuestion.get(j).getTitle());
							
							String desQuestion = "";
							if(question.replaceAll("\\<.*?\\>", "").length() > 200)
							{
								desQuestion = question.replaceAll("\\<.*?\\>", "").substring(0,200);
							} else {
								desQuestion = question.replaceAll("\\<.*?\\>", "");
							}
							
							tagQuestion.setDesQuestion(desQuestion);
							psm.makePersistent(tagQuestion);
							
							PersistenceManager psms = QnAPersistenceManager.get().getPersistenceManager();
							Query query_tag = psms.newQuery(Tags.class);
							query_tag.setFilter("alias=='"+Replace.replace(tags.get(i).text())+"'");
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
								tag.setName(tags.get(i).text());
								tag.setAlias(Replace.replace(tags.get(i).text()));
								tag.setLastUpdateDate(date);
								tag.setCount(1);
								psms.makePersistent(tag);
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
					
					
					
		//			String message = null;
		//			try {
		//				message = URLEncoder.encode("Android-based phones as well as on Android-based Tablets.", "UTF-8");
		//			} catch (UnsupportedEncodingException e1) {
		//				// TODO Auto-generated catch block
		//				e1.printStackTrace();
		//			}
		//			
		//			URL url = new URL("http://nlpdotnet.com/Services/Tagger.aspx");
		//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		//            connection.setDoOutput(true);
		//            connection.setRequestMethod("POST");
		//            connection.setRequestProperty("Content-Type", "multipart/form-data"); 
		//            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		//           
		//            writer.write("__VIEWSTATE=/wEPDwULLTE2Njk3ODM0MzYPZBYCZg9kFgJmD2QWAgIDDxYCHgdlbmN0eXBlBRNtdWx0aXBhcnQvZm9ybS1kYXRhFgICCw9kFgICBQ9kFgICBw8PFgIeBFRleHQFW0FuZHJvaWQtYmFzZWQvTk4NCnBob25lcy9OTlMNCmFzL1JCDQp3ZWxsL1JCDQphcy9JTg0Kb24vSU4NCkFuZHJvaWQtYmFzZWQvTk4NClRhYmxldHMvTk5TDQpkZBgBBR5fX0NvbnRyb2xzUmVxdWlyZVBvc3RCYWNrS2V5X18WBAU3Y3RsMDAkY3RsMDAkQ3BoTWFpbiRDcGhMZWN0dXJlQ29udGVudCRjaGVja0JveE9wdGlvbnMkMAU3Y3RsMDAkY3RsMDAkQ3BoTWFpbiRDcGhMZWN0dXJlQ29udGVudCRjaGVja0JveE9wdGlvbnMkMQU3Y3RsMDAkY3RsMDAkQ3BoTWFpbiRDcGhMZWN0dXJlQ29udGVudCRjaGVja0JveE9wdGlvbnMkMgU3Y3RsMDAkY3RsMDAkQ3BoTWFpbiRDcGhMZWN0dXJlQ29udGVudCRjaGVja0JveE9wdGlvbnMkMiMbT+AVTECBGeBl67sFVWxt2DoY");
		//            writer.write("&__EVENTVALIDATION=/wEWCgKGm+qrDwLtzfHTDgKjwOzBDgLGmYcsAq+wj4AGAq/tp5MHApSEiv4MAvma7OgCAonS7NYLAsvL5rkI7+4ZX400kz7q9b3blMBHB6fUQOk=");
		//            writer.write("&ctl00$ctl00$CphMain$CphLectureContent$checkBoxOptions$2=on");
		//            writer.write("&ctl00$ctl00$CphMain$CphLectureContent$txtbxInput="+message);
		//            writer.close();
		//            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
		//	           	 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		//	           	 String content = "";
		//	           	 while(1==1)
		//	    			 {
		//	    				 String str = reader.readLine();
		//	    				 if(str==null) break;
		//	    				 content+=str;   				
		//	    			 }
		//	           	 doc = Jsoup.parse(content);
		//            }
		//            System.out.print(doc.select("#ctl00_ctl00_CphMain_CphLectureContent_txtbxOutput"));
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
