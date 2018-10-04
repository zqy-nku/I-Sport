package com.chinasoft.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Venuecomment implements Serializable {
	private int vencomid;
	private int venueid;
	private int userid;
	private String vencomcont;
	private int vencomstar;
	private String vencomresid;
	private Date vencomtime;
	public Venuecomment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venuecomment(int vencomid, int venueid, int userid,
			String vencomcont, int vencomstar, String vencomresid,
			Date vencomtime) {
		super();
		this.vencomid = vencomid;
		this.venueid = venueid;
		this.userid = userid;
		this.vencomcont = vencomcont;
		this.vencomstar = vencomstar;
		this.vencomresid = vencomresid;
		this.vencomtime = vencomtime;
	}
	public int getVencomid() {
		return vencomid;
	}
	public void setVencomid(int vencomid) {
		this.vencomid = vencomid;
	}
	public int getVenueid() {
		return venueid;
	}
	public void setVenueid(int venueid) {
		this.venueid = venueid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getVencomcont() {
		return vencomcont;
	}
	public void setVencomcont(String vencomcont) {
		this.vencomcont = vencomcont;
	}
	public int getVencomstar() {
		return vencomstar;
	}
	public void setVencomstar(int vencomstar) {
		this.vencomstar = vencomstar;
	}
	public String getVencomresid() {
		return vencomresid;
	}
	public void setVencomresid(String vencomresid) {
		this.vencomresid = vencomresid;
	}
	public Date getVencomtime() {
		return vencomtime;
	}
	public void setVencomtime(Date vencomtime) {
		this.vencomtime = vencomtime;
	}
	@Override
	public String toString() {
		return "Venuecomment [vencomid=" + vencomid + ", venueid=" + venueid
				+ ", userid=" + userid + ", vencomcont=" + vencomcont
				+ ", vencomstar=" + vencomstar + ", vencomresid=" + vencomresid
				+ ", vencomtime=" + vencomtime + "]";
	}
	
	

}
