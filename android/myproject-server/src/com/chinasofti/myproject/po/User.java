package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int userid;
	private int regid;
	private String spordec;
	private float spornum;
	private int rank;
	private int integ;
	private String sportlabel;
	private int isaccepmsg;
	private String collestatusid;
	private String colletreasid;
	private int userstatus;
	private String userpho;
	private String mark;
	private String actiid;
	private String zanactiid;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, int regid, String spordec, float spornum, int rank,
			int integ, String sportlabel, int isaccepmsg, String collestatusid,
			String colletreasid, int userstatus, String userpho, String mark,
			String actiid, String zanactiid) {
		super();
		this.userid = userid;
		this.regid = regid;
		this.spordec = spordec;
		this.spornum = spornum;
		this.rank = rank;
		this.integ = integ;
		this.sportlabel = sportlabel;
		this.isaccepmsg = isaccepmsg;
		this.collestatusid = collestatusid;
		this.colletreasid = colletreasid;
		this.userstatus = userstatus;
		this.userpho = userpho;
		this.mark = mark;
		this.actiid = actiid;
		this.zanactiid = zanactiid;
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
	 * @return the spordec
	 */
	public String getSpordec() {
		return spordec;
	}
	/**
	 * @param spordec the spordec to set
	 */
	public void setSpordec(String spordec) {
		this.spordec = spordec;
	}
	/**
	 * @return the spornum
	 */
	public float getSpornum() {
		return spornum;
	}
	/**
	 * @param spornum the spornum to set
	 */
	public void setSpornum(float spornum) {
		this.spornum = spornum;
	}
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * @return the integ
	 */
	public int getInteg() {
		return integ;
	}
	/**
	 * @param integ the integ to set
	 */
	public void setInteg(int integ) {
		this.integ = integ;
	}
	/**
	 * @return the sportlabel
	 */
	public String getSportlabel() {
		return sportlabel;
	}
	/**
	 * @param sportlabel the sportlabel to set
	 */
	public void setSportlabel(String sportlabel) {
		this.sportlabel = sportlabel;
	}
	/**
	 * @return the isaccepmsg
	 */
	public int getIsaccepmsg() {
		return isaccepmsg;
	}
	/**
	 * @param isaccepmsg the isaccepmsg to set
	 */
	public void setIsaccepmsg(int isaccepmsg) {
		this.isaccepmsg = isaccepmsg;
	}
	/**
	 * @return the collestatusid
	 */
	public String getCollestatusid() {
		return collestatusid;
	}
	/**
	 * @param collestatusid the collestatusid to set
	 */
	public void setCollestatusid(String collestatusid) {
		this.collestatusid = collestatusid;
	}
	/**
	 * @return the colletreasid
	 */
	public String getColletreasid() {
		return colletreasid;
	}
	/**
	 * @param colletreasid the colletreasid to set
	 */
	public void setColletreasid(String colletreasid) {
		this.colletreasid = colletreasid;
	}
	/**
	 * @return the userstatus
	 */
	public int getUserstatus() {
		return userstatus;
	}
	/**
	 * @param userstatus the userstatus to set
	 */
	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}
	/**
	 * @return the userpho
	 */
	public String getUserpho() {
		return userpho;
	}
	/**
	 * @param userpho the userpho to set
	 */
	public void setUserpho(String userpho) {
		this.userpho = userpho;
	}
	/**
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}
	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	/**
	 * @return the actiid
	 */
	public String getActiid() {
		return actiid;
	}
	/**
	 * @param actiid the actiid to set
	 */
	public void setActiid(String actiid) {
		this.actiid = actiid;
	}
	/**
	 * @return the zanactiid
	 */
	public String getZanactiid() {
		return zanactiid;
	}
	/**
	 * @param zanactiid the zanactiid to set
	 */
	public void setZanactiid(String zanactiid) {
		this.zanactiid = zanactiid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userid=" + userid + ", regid=" + regid + ", spordec="
				+ spordec + ", spornum=" + spornum + ", rank=" + rank
				+ ", integ=" + integ + ", sportlabel=" + sportlabel
				+ ", isaccepmsg=" + isaccepmsg + ", collestatusid="
				+ collestatusid + ", colletreasid=" + colletreasid
				+ ", userstatus=" + userstatus + ", userpho=" + userpho
				+ ", mark=" + mark + ", actiid=" + actiid + ", zanactiid="
				+ zanactiid + "]";
	}
	
}