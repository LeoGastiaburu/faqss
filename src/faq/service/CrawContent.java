package faq.service;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawContent {
	public CrawContent()
	{
		Document doc;
		try {
			doc = Jsoup.connect("http://efreedom.com/Question/1-36/Check-Changes-SQL-Table").get();
			
			String title = doc.select("#questionTitle").html();
			String question = doc.select("#fullQuestionBody").html();
			String answer = doc.select("#fullAnswerBody").html();
			String questionAuthor = doc.select("#hypQuestionAuthor").text();
			String answerAuthor = doc.select("#hypAnswerAuthor").text();
			Elements tags = doc.select(".topicBoxSmall");
			System.out.print(question);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new CrawContent();

	}
}
