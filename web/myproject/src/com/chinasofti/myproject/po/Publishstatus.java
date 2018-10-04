package com.chinasofti.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Publishstatus implements Serializable {
	private int staid;
	private int userid;
	private int followid;
	private String stacontext;
	private int staviewcount;
	private int starepcount;
	private int stapracount;
	private String staresid;
	private Date stapubtime;
	private int stastatus;
	public Publishstatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Publishstatus(int staid, int userid, int followid,
			String stacontext, int staviewcount, int starepcount,
			int stapracount, String staresid, Date stapubtime, int stastatus) {
		super();
		this.staid = staid;
		this.userid = userid;
		this.followid = followid;
		this.stacontext = stacontext;
		this.staviewcount = staviewcount;
		this.starepcount = starepcount;
		this.stapracount = stapracount;
		this.staresid = staresid;
		this.stapubtime = stapubtime;
		this.stastatus = stastatus;
	}
	public int getStaid() {
		return staid;
	}
	public void setStaid(int staid) {
		this.staid = staid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFollowid() {
		return followid;
	}
	public void setFollowid(int followid) {
		this.followid = followid;
	}
	public String getStacontext() {
		return stacontext;
	}
	public void setStacontext(String stacontext) {
		this.stacontext = stacontext;
	}
	public int getStaviewcount() {
		return staviewcount;
	}
	public void setStaviewcount(int staviewcount) {
		this.staviewcount = staviewcount;
	}
	public int getStarepcount() {
		return starepcount;
	}
	public void setStarepcount(int starepcount) {
		this.starepcount = starepcount;
	}
	public int getStapracount() {
		return stapracount;
	}
	public void setStapracount(int stapracount) {
		this.stapracount = stapracount;
	}
	public String getStaresid() {
		return staresid;
	}
	public void setStaresid(String staresid) {
		this.staresid = staresid;
	}
	public Date getStapubtime() {
		return stapubtime;
	}
	public void setStapubtime(Date stapubtime2) {
		this.stapubtime = stapubtime2;
	}
	public int getStastatus() {
		return stastatus;
	}
	public void setStastatus(int stastatus) {
		this.stastatus = stastatus;
	}
	@Override
	public String toString() {
		return "Publishstatus [staid=" + staid + ", userid=" + userid
				+ ", followid=" + followid + ", stacontext=" + stacontext
				+ ", staviewcount=" + staviewcount + ", starepcount="
				+ starepcount + ", stapracount=" + stapracount + ", staresid="
				+ staresid + ", stapubtime=" + stapubtime + ", stastatus="
				+ stastatus + "]";
	}
	
	

}
