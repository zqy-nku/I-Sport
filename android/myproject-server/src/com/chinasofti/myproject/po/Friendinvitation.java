package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friendinvitation implements Serializable {
	private int inviid;
	private int userid;
	private int sportid;
	private String invibegtime;
	private String inviendtime;
	private String invicont;
	private String invipubtime;
	private String partuserid;
	private int partusercount;
	private String inviplace;
	public Friendinvitation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friendinvitation(int inviid, int userid, int sportid,
			String invibegtime, String inviendtime, String invicont,
			String invipubtime, String partuserid, int partusercount,
			String inviplace) {
		super();
		this.inviid = inviid;
		this.userid = userid;
		this.sportid = sportid;
		this.invibegtime = invibegtime;
		this.inviendtime = inviendtime;
		this.invicont = invicont;
		this.invipubtime = invipubtime;
		this.partuserid = partuserid;
		this.partusercount = partusercount;
		this.inviplace = inviplace;
	}
	public int getInviid() {
		return inviid;
	}
	public void setInviid(int inviid) {
		this.inviid = inviid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSportid() {
		return sportid;
	}
	public void setSportid(int sportid) {
		this.sportid = sportid;
	}
	public String getInvibegtime() {
		return invibegtime;
	}
	public void setInvibegtime(String invibegtime) {
		this.invibegtime = invibegtime;
	}
	public String getInviendtime() {
		return inviendtime;
	}
	public void setInviendtime(String inviendtime) {
		this.inviendtime = inviendtime;
	}
	public String getInvicont() {
		return invicont;
	}
	public void setInvicont(String invicont) {
		this.invicont = invicont;
	}
	public String getInvipubtime() {
		return invipubtime;
	}
	public void setInvipubtime(String invipubtime) {
		this.invipubtime = invipubtime;
	}
	public String getPartuserid() {
		return partuserid;
	}
	public void setPartuserid(String partuserid) {
		this.partuserid = partuserid;
	}
	public int getPartusercount() {
		return partusercount;
	}
	public void setPartusercount(int partusercount) {
		this.partusercount = partusercount;
	}
	public String getInviplace() {
		return inviplace;
	}
	public void setInviplace(String inviplace) {
		this.inviplace = inviplace;
	}
	@Override
	public String toString() {
		return "Friendinvitation [inviid=" + inviid + ", userid=" + userid
				+ ", sportid=" + sportid + ", invibegtime=" + invibegtime
				+ ", inviendtime=" + inviendtime + ", invicont=" + invicont
				+ ", invipubtime=" + invipubtime + ", partuserid=" + partuserid
				+ ", partusercount=" + partusercount + ", inviplace="
				+ inviplace + "]";
	}
	
	

}
