package com.chinasoft.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Datedfriend implements Serializable {
	private int datefrirelaid;
	private int userid;
	private int friendid;
	private String datedtime;
	private int datedtype;
	public Datedfriend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Datedfriend(int datefrirelaid, int userid, int friendid,
			String datedtime, int datedtype) {
		super();
		this.datefrirelaid = datefrirelaid;
		this.userid = userid;
		this.friendid = friendid;
		this.datedtime = datedtime;
		this.datedtype = datedtype;
	}
	public int getDatefrirelaid() {
		return datefrirelaid;
	}
	public void setDatefrirelaid(int datefrirelaid) {
		this.datefrirelaid = datefrirelaid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getDatedtime() {
		return datedtime;
	}
	public void setDatedtime(String datedtime) {
		this.datedtime = datedtime;
	}
	public int getDatedtype() {
		return datedtype;
	}
	public void setDatedtype(int datedtype) {
		this.datedtype = datedtype;
	}
	@Override
	public String toString() {
		return "Datedfriend [datefrirelaid=" + datefrirelaid + ", userid="
				+ userid + ", friendid=" + friendid + ", datedtime="
				+ datedtime + ", datedtype=" + datedtype + "]";
	}
	
	

}
