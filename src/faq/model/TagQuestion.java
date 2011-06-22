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
	private String aliasQuestion;

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

}
