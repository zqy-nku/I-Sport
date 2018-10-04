package com.chinasoft.myproject.po;

import java.util.Date;

public class Vshuoshuo {
	private int staid;
	private int userid;
	private String nickname;
	private String sportlabel;
	private String userpho;
	private String stacontext;
	private Date stapubtime;
	
	
	
	public Vshuoshuo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vshuoshuo(int staid, int userid, String nickname, String sportlabel,
			String userpho, String stacontext, Date stapubtime) {
		super();
		this.staid = staid;
		this.userid = userid;
		this.nickname = nickname;
		this.sportlabel = sportlabel;
		this.userpho = userpho;
		this.stacontext = stacontext;
		this.stapubtime = stapubtime;
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



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getSportlabel() {
		return sportlabel;
	}



	public void setSportlabel(String sportlabel) {
		this.sportlabel = sportlabel;
	}



	public String getUserpho() {
		return userpho;
	}



	public void setUserpho(String userpho) {
		this.userpho = userpho;
	}



	public String getStacontext() {
		return stacontext;
	}



	public void setStacontext(String stacontext) {
		this.stacontext = stacontext;
	}



	public Date getStapubtime() {
		return stapubtime;
	}



	public void setStapubtime(Date stapubtime) {
		this.stapubtime = stapubtime;
	}



	@Override
	public String toString() {
		return "Vshuoshuo [staid=" + staid + ", userid=" + userid
				+ ", nickname=" + nickname + ", sportlabel=" + sportlabel
				+ ", userpho=" + userpho + ", stacontext=" + stacontext
				+ ", stapubtime=" + stapubtime + "]";
	}
	
	
	

}
