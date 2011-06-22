package faq.model;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class Question {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private Date lastUpdateDate;
	@Persistent
	private Date date;
	@Persistent
	private String title;
	@Persistent
	private String alias;
	@Persistent
	private String url;
	@Persistent
	private String author;
	@Persistent
	private String aliasAuthor;
	@Persistent
	private Text content;
	@Persistent
	private Text contentAnwer;
	@Persistent
	private String authorAnwer;
	@Persistent
	private String aliasAuthorAnwer;
	@Persistent
	private ArrayList<String> tags = new ArrayList<String>();
	@Persistent
	private String esTitle;
	@Persistent
	private String deTitle;
	@Persistent
	private String frTitle;
	@Persistent
	private String hiTitle;
	@Persistent
	private String jaTitle;
	@Persistent
	private String koTitle;
	@Persistent
	private String nlTitle;
	@Persistent
	private String plTitle;
	@Persistent
	private String ptTitle;
	@Persistent
	private String roTitle;
	@Persistent
	private String trTitle;
	@Persistent
	private String ruTitle;
	@Persistent
	private String zhTitle;
	@Persistent
	private Text esContent;
	@Persistent
	private Text deContent;
	@Persistent
	private Text frContent;
	@Persistent
	private Text hiContent;
	@Persistent
	private Text jaContent;
	@Persistent
	private Text koContent;
	@Persistent
	private Text nlContent;
	@Persistent
	private Text plContent;
	@Persistent
	private Text ptContent;
	@Persistent
	private Text roContent;
	@Persistent
	private Text trContent;
	@Persistent
	private Text ruContent;
	@Persistent
	private Text zhContent;
	@Persistent
	private Text esContentAnwer;
	@Persistent
	private Text deContentAnwer;
	@Persistent
	private Text frContentAnwer;
	@Persistent
	private Text hiContentAnwer;
	@Persistent
	private Text jaContentAnwer;
	@Persistent
	private Text koContentAnwer;
	@Persistent
	private Text nlContentAnwer;
	@Persistent
	private Text plContentAnwer;
	@Persistent
	private Text ptContentAnwer;
	@Persistent
	private Text roContentAnwer;
	@Persistent
	private Text trContentAnwer;
	@Persistent
	private Text ruContentAnwer;
	@Persistent
	private Text zhContentAnwer;
	
	public String getEsTitle() {
		return esTitle;
	}
	public void setEsTitle(String esTitle) {
		this.esTitle = esTitle;
	}
	public String getDeTitle() {
		return deTitle;
	}
	public void setDeTitle(String deTitle) {
		this.deTitle = deTitle;
	}
	public String getFrTitle() {
		return frTitle;
	}
	public void setFrTitle(String frTitle) {
		this.frTitle = frTitle;
	}
	public String getHiTitle() {
		return hiTitle;
	}
	public void setHiTitle(String hiTitle) {
		this.hiTitle = hiTitle;
	}
	public String getKoTitle() {
		return koTitle;
	}
	public void setKoTitle(String koTitle) {
		this.koTitle = koTitle;
	}
	public String getNlTitle() {
		return nlTitle;
	}
	public void setNlTitle(String nlTitle) {
		this.nlTitle = nlTitle;
	}
	public String getPlTitle() {
		return plTitle;
	}
	public void setPlTitle(String plTitle) {
		this.plTitle = plTitle;
	}
	public String getPtTitle() {
		return ptTitle;
	}
	public void setPtTitle(String ptTitle) {
		this.ptTitle = ptTitle;
	}
	public String getRoTitle() {
		return roTitle;
	}
	public void setRoTitle(String roTitle) {
		this.roTitle = roTitle;
	}
	public String getTrTitle() {
		return trTitle;
	}
	public void setTrTitle(String trTitle) {
		this.trTitle = trTitle;
	}
	public String getRuTitle() {
		return ruTitle;
	}
	public void setRuTitle(String ruTitle) {
		this.ruTitle = ruTitle;
	}
	public String getZhTitle() {
		return zhTitle;
	}
	public void setZhTitle(String zhTitle) {
		this.zhTitle = zhTitle;
	}
	public Text getEsContent() {
		return esContent;
	}
	public void setEsContent(Text esContent) {
		this.esContent = esContent;
	}
	public Text getDeContent() {
		return deContent;
	}
	public void setDeContent(Text deContent) {
		this.deContent = deContent;
	}
	public Text getFrContent() {
		return frContent;
	}
	public void setFrContent(Text frContent) {
		this.frContent = frContent;
	}
	public Text getHiContent() {
		return hiContent;
	}
	public void setHiContent(Text hiContent) {
		this.hiContent = hiContent;
	}
	public Text getJaContent() {
		return jaContent;
	}
	public void setJaContent(Text jaContent) {
		this.jaContent = jaContent;
	}
	public Text getKoContent() {
		return koContent;
	}
	public void setKoContent(Text koContent) {
		this.koContent = koContent;
	}
	public Text getNlContent() {
		return nlContent;
	}
	public void setNlContent(Text nlContent) {
		this.nlContent = nlContent;
	}
	public Text getPlContent() {
		return plContent;
	}
	public void setPlContent(Text plContent) {
		this.plContent = plContent;
	}
	public Text getPtContent() {
		return ptContent;
	}
	public void setPtContent(Text ptContent) {
		this.ptContent = ptContent;
	}
	public Text getRoContent() {
		return roContent;
	}
	public void setRoContent(Text roContent) {
		this.roContent = roContent;
	}
	public Text getTrContent() {
		return trContent;
	}
	public void setTrContent(Text trContent) {
		this.trContent = trContent;
	}
	public Text getRuContent() {
		return ruContent;
	}
	public void setRuContent(Text ruContent) {
		this.ruContent = ruContent;
	}
	public Text getZhContent() {
		return zhContent;
	}
	public void setZhContent(Text zhContent) {
		this.zhContent = zhContent;
	}
	public Text getEsContentAnwer() {
		return esContentAnwer;
	}
	public void setEsContentAnwer(Text esContentAnwer) {
		this.esContentAnwer = esContentAnwer;
	}
	public Text getDeContentAnwer() {
		return deContentAnwer;
	}
	public void setDeContentAnwer(Text deContentAnwer) {
		this.deContentAnwer = deContentAnwer;
	}
	public Text getFrContentAnwer() {
		return frContentAnwer;
	}
	public void setFrContentAnwer(Text frContentAnwer) {
		this.frContentAnwer = frContentAnwer;
	}
	public Text getHiContentAnwer() {
		return hiContentAnwer;
	}
	public void setHiContentAnwer(Text hiContentAnwer) {
		this.hiContentAnwer = hiContentAnwer;
	}
	public Text getJaContentAnwer() {
		return jaContentAnwer;
	}
	public void setJaContentAnwer(Text jaContentAnwer) {
		this.jaContentAnwer = jaContentAnwer;
	}
	public Text getKoContentAnwer() {
		return koContentAnwer;
	}
	public void setKoContentAnwer(Text koContentAnwer) {
		this.koContentAnwer = koContentAnwer;
	}
	public Text getNlContentAnwer() {
		return nlContentAnwer;
	}
	public void setNlContentAnwer(Text nlContentAnwer) {
		this.nlContentAnwer = nlContentAnwer;
	}
	public Text getPlContentAnwer() {
		return plContentAnwer;
	}
	public void setPlContentAnwer(Text plContentAnwer) {
		this.plContentAnwer = plContentAnwer;
	}
	public Text getPtContentAnwer() {
		return ptContentAnwer;
	}
	public void setPtContentAnwer(Text ptContentAnwer) {
		this.ptContentAnwer = ptContentAnwer;
	}
	public Text getRoContentAnwer() {
		return roContentAnwer;
	}
	public void setRoContentAnwer(Text roContentAnwer) {
		this.roContentAnwer = roContentAnwer;
	}
	public Text getTrContentAnwer() {
		return trContentAnwer;
	}
	public void setTrContentAnwer(Text trContentAnwer) {
		this.trContentAnwer = trContentAnwer;
	}
	public Text getRuContentAnwer() {
		return ruContentAnwer;
	}
	public void setRuContentAnwer(Text ruContentAnwer) {
		this.ruContentAnwer = ruContentAnwer;
	}
	public Text getZhContentAnwer() {
		return zhContentAnwer;
	}
	public void setZhContentAnwer(Text zhContentAnwer) {
		this.zhContentAnwer = zhContentAnwer;
	}
	public String getJaTitle() {
		return jaTitle;
	}
	public void setJaTitle(String jaTitle) {
		this.jaTitle = jaTitle;
	}
	public Text getContentAnwer() {
		return contentAnwer;
	}
	public void setContentAnwer(Text contentAnwer) {
		this.contentAnwer = contentAnwer;
	}
	public String getAuthorAnwer() {
		return authorAnwer;
	}
	public void setAuthorAnwer(String authorAnwer) {
		this.authorAnwer = authorAnwer;
	}
	public String getAliasAuthorAnwer() {
		return aliasAuthorAnwer;
	}
	public void setAliasAuthorAnwer(String aliasAuthorAnwer) {
		this.aliasAuthorAnwer = aliasAuthorAnwer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Text getContent() {
		return content;
	}
	public void setContent(Text content) {
		this.content = content;
	}
	
}
