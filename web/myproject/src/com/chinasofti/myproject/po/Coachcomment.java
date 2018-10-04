package com.chinasofti.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Coachcomment implements Serializable {
	private int coacomid;
	private int coachid;
	private int userid;
	private String coacomcont;
	private String coacomresid;
	private Date coacomtime;
	private int coacomstar;
	public Coachcomment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coachcomment(int coacomid, int coachid, int userid,
			String coacomcont, String coacomresid, Date coacomtime,
			int coacomstar) {
		super();
		this.coacomid = coacomid;
		this.coachid = coachid;
		this.userid = userid;
		this.coacomcont = coacomcont;
		this.coacomresid = coacomresid;
		this.coacomtime = coacomtime;
		this.coacomstar = coacomstar;
	}
	public int getCoacomid() {
		return coacomid;
	}
	public void setCoacomid(int coacomid) {
		this.coacomid = coacomid;
	}
	public int getCoachid() {
		return coachid;
	}
	public void setCoachid(int coachid) {
		this.coachid = coachid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCoacomcont() {
		return coacomcont;
	}
	public void setCoacomcont(String coacomcont) {
		this.coacomcont = coacomcont;
	}
	public String getCoacomresid() {
		return coacomresid;
	}
	public void setCoacomresid(String coacomresid) {
		this.coacomresid = coacomresid;
	}
	public Date getCoacomtime() {
		return coacomtime;
	}
	public void setCoacomtime(Date coacomtime) {
		this.coacomtime = coacomtime;
	}
	public int getCoacomstar() {
		return coacomstar;
	}
	public void setCoacomstar(int coacomstar) {
		this.coacomstar = coacomstar;
	}
	@Override
	public String toString() {
		return "Coachcomment [coacomid=" + coacomid + ", coachid=" + coachid
				+ ", userid=" + userid + ", coacomcont=" + coacomcont
				+ ", coacomresid=" + coacomresid + ", coacomtime=" + coacomtime
				+ ", coacomstar=" + coacomstar + "]";
	}
	
	

}
