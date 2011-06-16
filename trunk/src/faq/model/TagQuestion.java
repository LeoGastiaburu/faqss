package faq.model;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class TagQuestion {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String aliasTag;
	@Persistent
	private ArrayList<String> tags = new ArrayList<String>();
	@Persistent
	private String aliasQuestion;
	@Persistent
	private String titleQuestion;
	@Persistent
	private String desQuestion;
	public void addTags(String tag)
	{
		if(!this.tags.contains(tag))
			this.tags.add(tag);
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public String getDesQuestion() {
		return desQuestion;
	}
	public void setDesQuestion(String desQuestion) {
		this.desQuestion = desQuestion;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getAliasTag() {
		return aliasTag;
	}
	public void setAliasTag(String aliasTag) {
		this.aliasTag = aliasTag;
	}
	public String getAliasQuestion() {
		return aliasQuestion;
	}
	public void setAliasQuestion(String aliasQuestion) {
		this.aliasQuestion = aliasQuestion;
	}
	public String getTitleQuestion() {
		return titleQuestion;
	}
	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}

}
