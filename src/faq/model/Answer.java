package faq.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class Answer {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private Text content;
	@Persistent
	private Key questionKey;
	@Persistent
	private String author;
	@Persistent
	private String aliasAuthor;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAliasAuthor() {
		return aliasAuthor;
	}
	public void setAliasAuthor(String aliasAuthor) {
		this.aliasAuthor = aliasAuthor;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public Text getContent() {
		return content;
	}
	public void setContent(Text content) {
		this.content = content;
	}
	public Key getQuestionKey() {
		return questionKey;
	}
	public void setQuestionKey(Key questionKey) {
		this.questionKey = questionKey;
	}
	
}
