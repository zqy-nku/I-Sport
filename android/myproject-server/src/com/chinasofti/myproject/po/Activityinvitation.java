package com.chinasofti.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Activityinvitation implements Serializable {
	private int actiid;
	private int sportid;
	private int userid;
	private String actiname;
	private Date actibegtime;
	private int actiissucc;
	private Date actisettime;
	private int actiusercount;
	private String acticont;
	private String actiplace;
	private Date actiendtime;
	private int actizancount;
	public Activityinvitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Activityinvitation(int actiid, int sportid, int userid,
			String actiname, Date actibegtime, int actiissucc,
			Date actisettime, int actiusercount, String acticont,
			String actiplace, Date actiendtime, int actizancount) {
		super();
		this.actiid = actiid;
		this.sportid = sportid;
		this.userid = userid;
		this.actiname = actiname;
		this.actibegtime = actibegtime;
		this.actiissucc = actiissucc;
		this.actisettime = actisettime;
		this.actiusercount = actiusercount;
		this.acticont = acticont;
		this.actiplace = actiplace;
		this.actiendtime = actiendtime;
		this.actizancount = actizancount;
	}
	/**
	 * @return the actiid
	 */
	public int getActiid() {
		return actiid;
	}
	/**
	 * @param actiid the actiid to set
	 */
	public void setActiid(int actiid) {
		this.actiid = actiid;
	}
	/**
	 * @return the sportid
	 */
	public int getSportid() {
		return sportid;
	}
	/**
	 * @param sportid the sportid to set
	 */
	public void setSportid(int sportid) {
		this.sportid = sportid;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the actiname
	 */
	public String getActiname() {
		return actiname;
	}
	/**
	 * @param actiname the actiname to set
	 */
	public void setActiname(String actiname) {
		this.actiname = actiname;
	}
	/**
	 * @return the actibegtime
	 */
	public Date getActibegtime() {
		return actibegtime;
	}
	/**
	 * @param actibegtime the actibegtime to set
	 */
	public void setActibegtime(Date actibegtime) {
		this.actibegtime = actibegtime;
	}
	/**
	 * @return the actiissucc
	 */
	public int getActiissucc() {
		return actiissucc;
	}
	/**
	 * @param actiissucc the actiissucc to set
	 */
	public void setActiissucc(int actiissucc) {
		this.actiissucc = actiissucc;
	}
	/**
	 * @return the actisettime
	 */
	public Date getActisettime() {
		return actisettime;
	}
	/**
	 * @param actisettime the actisettime to set
	 */
	public void setActisettime(Date actisettime) {
		this.actisettime = actisettime;
	}
	/**
	 * @return the actiusercount
	 */
	public int getActiusercount() {
		return actiusercount;
	}
	/**
	 * @param actiusercount the actiusercount to set
	 */
	public void setActiusercount(int actiusercount) {
		this.actiusercount = actiusercount;
	}
	/**
	 * @return the acticont
	 */
	public String getActicont() {
		return acticont;
	}
	/**
	 * @param acticont the acticont to set
	 */
	public void setActicont(String acticont) {
		this.acticont = acticont;
	}
	/**
	 * @return the actiplace
	 */
	public String getActiplace() {
		return actiplace;
	}
	/**
	 * @param actiplace the actiplace to set
	 */
	public void setActiplace(String actiplace) {
		this.actiplace = actiplace;
	}
	/**
	 * @return the actiendtime
	 */
	public Date getActiendtime() {
		return actiendtime;
	}
	/**
	 * @param actiendtime the actiendtime to set
	 */
	public void setActiendtime(Date actiendtime) {
		this.actiendtime = actiendtime;
	}
	/**
	 * @return the actizancount
	 */
	public int getActizancount() {
		return actizancount;
	}
	/**
	 * @param actizancount the actizancount to set
	 */
	public void setActizancount(int actizancount) {
		this.actizancount = actizancount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Activityinvitation [actiid=" + actiid + ", sportid=" + sportid
				+ ", userid=" + userid + ", actiname=" + actiname
				+ ", actibegtime=" + actibegtime + ", actiissucc=" + actiissucc
				+ ", actisettime=" + actisettime + ", actiusercount="
				+ actiusercount + ", acticont=" + acticont + ", actiplace="
				+ actiplace + ", actiendtime=" + actiendtime
				+ ", actizancount=" + actizancount + "]";
	}
	
}