package faq.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@PersistenceCapable
public class Question implements Serializable{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private Date lastUpdateDate;
	@Persistent
	private Date date;
	@Persistent
	private String cron;
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
	private String oneTitle;
	@Persistent
	private String twoTitle;
	@Persistent
	private String threeTitle;
	@Persistent
	private String fourTitle;
	@Persistent
	private String fiveTitle;
	@Persistent
	private String sixTitle;
	@Persistent
	private String sevenTitle;
	@Persistent
	private String eightTitle;
	@Persistent
	private String nineTitle;
	@Persistent
	private String tenTitle;
	@Persistent
	private String elevenTitle;
	@Persistent
	private String twelveTitle;
	@Persistent
	private String thirteenTitle;
	@Persistent
	private String fourteenTitle;
	@Persistent
	private String fifteenTitle;
	@Persistent
	private String sixteenTitle;
	@Persistent
	private String seventeenTitle;
	@Persistent
	private String eighteenTitle;
	@Persistent
	private String nineteenTitle;
	@Persistent
	private String twentyTitle;
	@Persistent
	private String twentyOneTitle;
	@Persistent
	private String twentyTwoTitle;
	@Persistent
	private String twentyThreeTitle;
	@Persistent
	private String twentyFourTitle;
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
	private Text oneContent;
	@Persistent
	private Text twoContent;
	@Persistent
	private Text threeContent;
	@Persistent
	private Text fourContent;
	@Persistent
	private Text fiveContent;
	@Persistent
	private Text sixContent;
	@Persistent
	private Text sevenContent;
	@Persistent
	private Text eightContent;
	@Persistent
	private Text nineContent;
	@Persistent
	private Text tenContent;
	@Persistent
	private Text elevenContent;
	@Persistent
	private Text twelveContent;
	@Persistent
	private Text thirteenContent;
	@Persistent
	private Text fourteenContent;
	@Persistent
	private Text fifteenContent;
	@Persistent
	private Text sixteenContent;
	@Persistent
	private Text seventeenContent;
	@Persistent
	private Text eighteenContent;
	@Persistent
	private Text nineteenContent;
	@Persistent
	private Text twentyContent;
	@Persistent
	private Text twentyOneContent;
	@Persistent
	private Text twentyTwoContent;
	@Persistent
	private Text twentyThreeContent;
	@Persistent
	private Text twentyFourContent;
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
	@Persistent
	private Text oneContentAnwer;
	@Persistent
	private Text twoContentAnwer;
	@Persistent
	private Text threeContentAnwer;
	@Persistent
	private Text fourContentAnwer;
	@Persistent
	private Text fiveContentAnwer;
	@Persistent
	private Text sixContentAnwer;
	@Persistent
	private Text sevenContentAnwer;
	@Persistent
	private Text eightContentAnwer;
	@Persistent
	private Text nineContentAnwer;
	@Persistent
	private Text tenContentAnwer;
	@Persistent
	private Text elevenContentAnwer;
	@Persistent
	private Text twelveContentAnwer;
	@Persistent
	private Text thirteenContentAnwer;
	@Persistent
	private Text fourteenContentAnwer;
	@Persistent
	private Text fifteenContentAnwer;
	@Persistent
	private Text sixteenContentAnwer;
	@Persistent
	private Text seventeenContentAnwer;
	@Persistent
	private Text eighteenContentAnwer;
	@Persistent
	private Text nineteenContentAnwer;
	@Persistent
	private Text twentyContentAnwer;
	@Persistent
	private Text twentyOneContentAnwer;
	@Persistent
	private Text twentyTwoContentAnwer;
	@Persistent
	private Text twentyThreeContentAnwer;
	@Persistent
	private Text twentyFourContentAnwer;
	
	public String getOneTitle() {
		return oneTitle;
	}
	public void setOneTitle(String oneTitle) {
		this.oneTitle = oneTitle;
	}
	public String getTwoTitle() {
		return twoTitle;
	}
	public void setTwoTitle(String twoTitle) {
		this.twoTitle = twoTitle;
	}
	public String getThreeTitle() {
		return threeTitle;
	}
	public void setThreeTitle(String threeTitle) {
		this.threeTitle = threeTitle;
	}
	public String getFourTitle() {
		return fourTitle;
	}
	public void setFourTitle(String fourTitle) {
		this.fourTitle = fourTitle;
	}
	public String getFiveTitle() {
		return fiveTitle;
	}
	public void setFiveTitle(String fiveTitle) {
		this.fiveTitle = fiveTitle;
	}
	public String getSixTitle() {
		return sixTitle;
	}
	public void setSixTitle(String sixTitle) {
		this.sixTitle = sixTitle;
	}
	public String getSevenTitle() {
		return sevenTitle;
	}
	public void setSevenTitle(String sevenTitle) {
		this.sevenTitle = sevenTitle;
	}
	public String getEightTitle() {
		return eightTitle;
	}
	public void setEightTitle(String eightTitle) {
		this.eightTitle = eightTitle;
	}
	public String getNineTitle() {
		return nineTitle;
	}
	public void setNineTitle(String nineTitle) {
		this.nineTitle = nineTitle;
	}
	public String getTenTitle() {
		return tenTitle;
	}
	public void setTenTitle(String tenTitle) {
		this.tenTitle = tenTitle;
	}
	public String getElevenTitle() {
		return elevenTitle;
	}
	public void setElevenTitle(String elevenTitle) {
		this.elevenTitle = elevenTitle;
	}
	public String getTwelveTitle() {
		return twelveTitle;
	}
	public void setTwelveTitle(String twelveTitle) {
		this.twelveTitle = twelveTitle;
	}
	public String getThirteenTitle() {
		return thirteenTitle;
	}
	public void setThirteenTitle(String thirteenTitle) {
		this.thirteenTitle = thirteenTitle;
	}
	public String getFourteenTitle() {
		return fourteenTitle;
	}
	public void setFourteenTitle(String fourteenTitle) {
		this.fourteenTitle = fourteenTitle;
	}
	public String getFifteenTitle() {
		return fifteenTitle;
	}
	public void setFifteenTitle(String fifteenTitle) {
		this.fifteenTitle = fifteenTitle;
	}
	public String getSixteenTitle() {
		return sixteenTitle;
	}
	public void setSixteenTitle(String sixteenTitle) {
		this.sixteenTitle = sixteenTitle;
	}
	public String getSeventeenTitle() {
		return seventeenTitle;
	}
	public void setSeventeenTitle(String seventeenTitle) {
		this.seventeenTitle = seventeenTitle;
	}
	public String getEighteenTitle() {
		return eighteenTitle;
	}
	public void setEighteenTitle(String eighteenTitle) {
		this.eighteenTitle = eighteenTitle;
	}
	public String getNineteenTitle() {
		return nineteenTitle;
	}
	public void setNineteenTitle(String nineteenTitle) {
		this.nineteenTitle = nineteenTitle;
	}
	public String getTwentyTitle() {
		return twentyTitle;
	}
	public void setTwentyTitle(String twentyTitle) {
		this.twentyTitle = twentyTitle;
	}
	public String getTwentyOneTitle() {
		return twentyOneTitle;
	}
	public void setTwentyOneTitle(String twentyOneTitle) {
		this.twentyOneTitle = twentyOneTitle;
	}
	public String getTwentyTwoTitle() {
		return twentyTwoTitle;
	}
	public void setTwentyTwoTitle(String twentyTwoTitle) {
		this.twentyTwoTitle = twentyTwoTitle;
	}
	public String getTwentyThreeTitle() {
		return twentyThreeTitle;
	}
	public void setTwentyThreeTitle(String twentyThreeTitle) {
		this.twentyThreeTitle = twentyThreeTitle;
	}
	public String getTwentyFourTitle() {
		return twentyFourTitle;
	}
	public void setTwentyFourTitle(String twentyFourTitle) {
		this.twentyFourTitle = twentyFourTitle;
	}
	public Text getOneContent() {
		return oneContent;
	}
	public void setOneContent(Text oneContent) {
		this.oneContent = oneContent;
	}
	public Text getTwoContent() {
		return twoContent;
	}
	public void setTwoContent(Text twoContent) {
		this.twoContent = twoContent;
	}
	public Text getThreeContent() {
		return threeContent;
	}
	public void setThreeContent(Text threeContent) {
		this.threeContent = threeContent;
	}
	public Text getFourContent() {
		return fourContent;
	}
	public void setFourContent(Text fourContent) {
		this.fourContent = fourContent;
	}
	public Text getFiveContent() {
		return fiveContent;
	}
	public void setFiveContent(Text fiveContent) {
		this.fiveContent = fiveContent;
	}
	public Text getSixContent() {
		return sixContent;
	}
	public void setSixContent(Text sixContent) {
		this.sixContent = sixContent;
	}
	public Text getSevenContent() {
		return sevenContent;
	}
	public void setSevenContent(Text sevenContent) {
		this.sevenContent = sevenContent;
	}
	public Text getEightContent() {
		return eightContent;
	}
	public void setEightContent(Text eightContent) {
		this.eightContent = eightContent;
	}
	public Text getNineContent() {
		return nineContent;
	}
	public void setNineContent(Text nineContent) {
		this.nineContent = nineContent;
	}
	public Text getTenContent() {
		return tenContent;
	}
	public void setTenContent(Text tenContent) {
		this.tenContent = tenContent;
	}
	public Text getElevenContent() {
		return elevenContent;
	}
	public void setElevenContent(Text elevenContent) {
		this.elevenContent = elevenContent;
	}
	public Text getTwelveContent() {
		return twelveContent;
	}
	public void setTwelveContent(Text twelveContent) {
		this.twelveContent = twelveContent;
	}
	public Text getThirteenContent() {
		return thirteenContent;
	}
	public void setThirteenContent(Text thirteenContent) {
		this.thirteenContent = thirteenContent;
	}
	public Text getFourteenContent() {
		return fourteenContent;
	}
	public void setFourteenContent(Text fourteenContent) {
		this.fourteenContent = fourteenContent;
	}
	public Text getFifteenContent() {
		return fifteenContent;
	}
	public void setFifteenContent(Text fifteenContent) {
		this.fifteenContent = fifteenContent;
	}
	public Text getSixteenContent() {
		return sixteenContent;
	}
	public void setSixteenContent(Text sixteenContent) {
		this.sixteenContent = sixteenContent;
	}
	public Text getSeventeenContent() {
		return seventeenContent;
	}
	public void setSeventeenContent(Text seventeenContent) {
		this.seventeenContent = seventeenContent;
	}
	public Text getEighteenContent() {
		return eighteenContent;
	}
	public void setEighteenContent(Text eighteenContent) {
		this.eighteenContent = eighteenContent;
	}
	public Text getNineteenContent() {
		return nineteenContent;
	}
	public void setNineteenContent(Text nineteenContent) {
		this.nineteenContent = nineteenContent;
	}
	public Text getTwentyContent() {
		return twentyContent;
	}
	public void setTwentyContent(Text twentyContent) {
		this.twentyContent = twentyContent;
	}
	public Text getTwentyOneContent() {
		return twentyOneContent;
	}
	public void setTwentyOneContent(Text twentyOneContent) {
		this.twentyOneContent = twentyOneContent;
	}
	public Text getTwentyTwoContent() {
		return twentyTwoContent;
	}
	public void setTwentyTwoContent(Text twentyTwoContent) {
		this.twentyTwoContent = twentyTwoContent;
	}
	public Text getTwentyThreeContent() {
		return twentyThreeContent;
	}
	public void setTwentyThreeContent(Text twentyThreeContent) {
		this.twentyThreeContent = twentyThreeContent;
	}
	public Text getTwentyFourContent() {
		return twentyFourContent;
	}
	public void setTwentyFourContent(Text twentyFourContent) {
		this.twentyFourContent = twentyFourContent;
	}
	public Text getOneContentAnwer() {
		return oneContentAnwer;
	}
	public void setOneContentAnwer(Text oneContentAnwer) {
		this.oneContentAnwer = oneContentAnwer;
	}
	public Text getTwoContentAnwer() {
		return twoContentAnwer;
	}
	public void setTwoContentAnwer(Text twoContentAnwer) {
		this.twoContentAnwer = twoContentAnwer;
	}
	public Text getThreeContentAnwer() {
		return threeContentAnwer;
	}
	public void setThreeContentAnwer(Text threeContentAnwer) {
		this.threeContentAnwer = threeContentAnwer;
	}
	public Text getFourContentAnwer() {
		return fourContentAnwer;
	}
	public void setFourContentAnwer(Text fourContentAnwer) {
		this.fourContentAnwer = fourContentAnwer;
	}
	public Text getFiveContentAnwer() {
		return fiveContentAnwer;
	}
	public void setFiveContentAnwer(Text fiveContentAnwer) {
		this.fiveContentAnwer = fiveContentAnwer;
	}
	public Text getSixContentAnwer() {
		return sixContentAnwer;
	}
	public void setSixContentAnwer(Text sixContentAnwer) {
		this.sixContentAnwer = sixContentAnwer;
	}
	public Text getSevenContentAnwer() {
		return sevenContentAnwer;
	}
	public void setSevenContentAnwer(Text sevenContentAnwer) {
		this.sevenContentAnwer = sevenContentAnwer;
	}
	public Text getEightContentAnwer() {
		return eightContentAnwer;
	}
	public void setEightContentAnwer(Text eightContentAnwer) {
		this.eightContentAnwer = eightContentAnwer;
	}
	public Text getNineContentAnwer() {
		return nineContentAnwer;
	}
	public void setNineContentAnwer(Text nineContentAnwer) {
		this.nineContentAnwer = nineContentAnwer;
	}
	public Text getTenContentAnwer() {
		return tenContentAnwer;
	}
	public void setTenContentAnwer(Text tenContentAnwer) {
		this.tenContentAnwer = tenContentAnwer;
	}
	public Text getElevenContentAnwer() {
		return elevenContentAnwer;
	}
	public void setElevenContentAnwer(Text elevenContentAnwer) {
		this.elevenContentAnwer = elevenContentAnwer;
	}
	public Text getTwelveContentAnwer() {
		return twelveContentAnwer;
	}
	public void setTwelveContentAnwer(Text twelveContentAnwer) {
		this.twelveContentAnwer = twelveContentAnwer;
	}
	public Text getThirteenContentAnwer() {
		return thirteenContentAnwer;
	}
	public void setThirteenContentAnwer(Text thirteenContentAnwer) {
		this.thirteenContentAnwer = thirteenContentAnwer;
	}
	public Text getFourteenContentAnwer() {
		return fourteenContentAnwer;
	}
	public void setFourteenContentAnwer(Text fourteenContentAnwer) {
		this.fourteenContentAnwer = fourteenContentAnwer;
	}
	public Text getFifteenContentAnwer() {
		return fifteenContentAnwer;
	}
	public void setFifteenContentAnwer(Text fifteenContentAnwer) {
		this.fifteenContentAnwer = fifteenContentAnwer;
	}
	public Text getSixteenContentAnwer() {
		return sixteenContentAnwer;
	}
	public void setSixteenContentAnwer(Text sixteenContentAnwer) {
		this.sixteenContentAnwer = sixteenContentAnwer;
	}
	public Text getSeventeenContentAnwer() {
		return seventeenContentAnwer;
	}
	public void setSeventeenContentAnwer(Text seventeenContentAnwer) {
		this.seventeenContentAnwer = seventeenContentAnwer;
	}
	public Text getEighteenContentAnwer() {
		return eighteenContentAnwer;
	}
	public void setEighteenContentAnwer(Text eighteenContentAnwer) {
		this.eighteenContentAnwer = eighteenContentAnwer;
	}
	public Text getNineteenContentAnwer() {
		return nineteenContentAnwer;
	}
	public void setNineteenContentAnwer(Text nineteenContentAnwer) {
		this.nineteenContentAnwer = nineteenContentAnwer;
	}
	public Text getTwentyContentAnwer() {
		return twentyContentAnwer;
	}
	public void setTwentyContentAnwer(Text twentyContentAnwer) {
		this.twentyContentAnwer = twentyContentAnwer;
	}
	public Text getTwentyOneContentAnwer() {
		return twentyOneContentAnwer;
	}
	public void setTwentyOneContentAnwer(Text twentyOneContentAnwer) {
		this.twentyOneContentAnwer = twentyOneContentAnwer;
	}
	public Text getTwentyTwoContentAnwer() {
		return twentyTwoContentAnwer;
	}
	public void setTwentyTwoContentAnwer(Text twentyTwoContentAnwer) {
		this.twentyTwoContentAnwer = twentyTwoContentAnwer;
	}
	public Text getTwentyThreeContentAnwer() {
		return twentyThreeContentAnwer;
	}
	public void setTwentyThreeContentAnwer(Text twentyThreeContentAnwer) {
		this.twentyThreeContentAnwer = twentyThreeContentAnwer;
	}
	public Text getTwentyFourContentAnwer() {
		return twentyFourContentAnwer;
	}
	public void setTwentyFourContentAnwer(Text twentyFourContentAnwer) {
		this.twentyFourContentAnwer = twentyFourContentAnwer;
	}
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
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	
}
