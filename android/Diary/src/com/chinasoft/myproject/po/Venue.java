package com.chinasoft.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Venue implements Serializable {
	private int venueid;
	private String venuename;
	private float vencomgrade;
	private String vencontext;
	private String venplace;
	private float venprice;
	private int vensportid;
	private String venimage;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venue(int venueid, String venuename, float vencomgrade,
			String vencontext, String venplace, float venprice, int vensportid,
			String venimage) {
		super();
		this.venueid = venueid;
		this.venuename = venuename;
		this.vencomgrade = vencomgrade;
		this.vencontext = vencontext;
		this.venplace = venplace;
		this.venprice = venprice;
		this.vensportid = vensportid;
		this.venimage = venimage;
	}
	/**
	 * @return the venueid
	 */
	public int getVenueid() {
		return venueid;
	}
	/**
	 * @param venueid the venueid to set
	 */
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}
	/**
	 * @return the venuename
	 */
	public String getVenuename() {
		return venuename;
	}
	/**
	 * @param venuename the venuename to set
	 */
	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}
	/**
	 * @return the vencomgrade
	 */
	public float getVencomgrade() {
		return vencomgrade;
	}
	/**
	 * @param vencomgrade the vencomgrade to set
	 */
	public void setVencomgrade(float vencomgrade) {
		this.vencomgrade = vencomgrade;
	}
	/**
	 * @return the vencontext
	 */
	public String getVencontext() {
		return vencontext;
	}
	/**
	 * @param vencontext the vencontext to set
	 */
	public void setVencontext(String vencontext) {
		this.vencontext = vencontext;
	}
	/**
	 * @return the venplace
	 */
	public String getVenplace() {
		return venplace;
	}
	/**
	 * @param venplace the venplace to set
	 */
	public void setVenplace(String venplace) {
		this.venplace = venplace;
	}
	/**
	 * @return the venprice
	 */
	public float getVenprice() {
		return venprice;
	}
	/**
	 * @param venprice the venprice to set
	 */
	public void setVenprice(float venprice) {
		this.venprice = venprice;
	}
	/**
	 * @return the vensportid
	 */
	public int getVensportid() {
		return vensportid;
	}
	/**
	 * @param vensportid the vensportid to set
	 */
	public void setVensportid(int vensportid) {
		this.vensportid = vensportid;
	}
	/**
	 * @return the venimage
	 */
	public String getVenimage() {
		return venimage;
	}
	/**
	 * @param venimage the venimage to set
	 */
	public void setVenimage(String venimage) {
		this.venimage = venimage;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Venue [venueid=" + venueid + ", venuename=" + venuename
				+ ", vencomgrade=" + vencomgrade + ", vencontext=" + vencontext
				+ ", venplace=" + venplace + ", venprice=" + venprice
				+ ", vensportid=" + vensportid + ", venimage=" + venimage + "]";
	}

	
}
	