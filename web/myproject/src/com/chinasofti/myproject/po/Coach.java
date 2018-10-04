package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Coach implements Serializable {
	private int coachid;
	private String coaname;
	private String coagender;
	private int coatypeid;
	private String coaphon;
	private float coamark;
	private String coacontext;
	private String coaimage;
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coach(int coachid, String coaname, String coagender, int coatypeid,
			String coaphon, float coamark, String coacontext, String coaimage) {
		super();
		this.coachid = coachid;
		this.coaname = coaname;
		this.coagender = coagender;
		this.coatypeid = coatypeid;
		this.coaphon = coaphon;
		this.coamark = coamark;
		this.coacontext = coacontext;
		this.coaimage = coaimage;
	}
	/**
	 * @return the coachid
	 */
	public int getCoachid() {
		return coachid;
	}
	/**
	 * @param coachid the coachid to set
	 */
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	/**
	 * @return the coaname
	 */
	public String getCoaname() {
		return coaname;
	}
	/**
	 * @param coaname the coaname to set
	 */
	public void setCoaname(String coaname) {
		this.coaname = coaname;
	}
	/**
	 * @return the coagender
	 */
	public String getCoagender() {
		return coagender;
	}
	/**
	 * @param coagender the coagender to set
	 */
	public void setCoagender(String coagender) {
		this.coagender = coagender;
	}
	/**
	 * @return the coatypeid
	 */
	public int getCoatypeid() {
		return coatypeid;
	}
	/**
	 * @param coatypeid the coatypeid to set
	 */
	public void setCoatypeid(int coatypeid) {
		this.coatypeid = coatypeid;
	}
	/**
	 * @return the coaphon
	 */
	public String getCoaphon() {
		return coaphon;
	}
	/**
	 * @param coaphon the coaphon to set
	 */
	public void setCoaphon(String coaphon) {
		this.coaphon = coaphon;
	}
	/**
	 * @return the coamark
	 */
	public float getCoamark() {
		return coamark;
	}
	/**
	 * @param coamark the coamark to set
	 */
	public void setCoamark(float coamark) {
		this.coamark = coamark;
	}
	/**
	 * @return the coacontext
	 */
	public String getCoacontext() {
		return coacontext;
	}
	/**
	 * @param coacontext the coacontext to set
	 */
	public void setCoacontext(String coacontext) {
		this.coacontext = coacontext;
	}
	/**
	 * @return the coaimage
	 */
	public String getCoaimage() {
		return coaimage;
	}
	/**
	 * @param coaimage the coaimage to set
	 */
	public void setCoaimage(String coaimage) {
		this.coaimage = coaimage;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coach [coachid=" + coachid + ", coaname=" + coaname
				+ ", coagender=" + coagender + ", coatypeid=" + coatypeid
				+ ", coaphon=" + coaphon + ", coamark=" + coamark
				+ ", coacontext=" + coacontext + ", coaimage=" + coaimage + "]";
	}
	
	
	

}
