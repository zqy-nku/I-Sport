package com.chinasofti.myproject.po;

import java.util.Date;

public class Activity {
	private int actiid;
	private String actiname; 
	private int regid;
	private String nickname;
	int sportid;
	private String sportname;
	private int actiusercount;
    private Date actibegtime;
    private Date actiendtime;
    private String acticont;
	private String actiplace;
	private int actidianzan;
	private Date actisettime;
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Activity(int actiid, String actiname, int regid, String nickname,
			int sportid, String sportname, int actiusercount, Date actibegtime,
			Date actiendtime, String acticont, String actiplace,
			int actidianzan, Date actisettime) {
		super();
		this.actiid = actiid;
		this.actiname = actiname;
		this.regid = regid;
		this.nickname = nickname;
		this.sportid = sportid;
		this.sportname = sportname;
		this.actiusercount = actiusercount;
		this.actibegtime = actibegtime;
		this.actiendtime = actiendtime;
		this.acticont = acticont;
		this.actiplace = actiplace;
		this.actidianzan = actidianzan;
		this.actisettime = actisettime;
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
	 * @return the regid
	 */
	public int getRegid() {
		return regid;
	}
	/**
	 * @param regid the regid to set
	 */
	public void setRegid(int regid) {
		this.regid = regid;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	 * @return the sportname
	 */
	public String getSportname() {
		return sportname;
	}
	/**
	 * @param sportname the sportname to set
	 */
	public void setSportname(String sportname) {
		this.sportname = sportname;
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
	 * @return the actidianzan
	 */
	public int getActidianzan() {
		return actidianzan;
	}
	/**
	 * @param actidianzan the actidianzan to set
	 */
	public void setActidianzan(int actidianzan) {
		this.actidianzan = actidianzan;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Activity [actiid=" + actiid + ", actiname=" + actiname
				+ ", regid=" + regid + ", nickname=" + nickname + ", sportid="
				+ sportid + ", sportname=" + sportname + ", actiusercount="
				+ actiusercount + ", actibegtime=" + actibegtime
				+ ", actiendtime=" + actiendtime + ", acticont=" + acticont
				+ ", actiplace=" + actiplace + ", actidianzan=" + actidianzan
				+ ", actisettime=" + actisettime + "]";
	}
	
}
	