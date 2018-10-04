package com.chinasofti.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Mydiary implements Serializable {
	private int mdiaryid;
	private int userid;
	private Date mdiarytime;
	private String mdiaryname;
	private String mdiarycont;
	private int mdiarystatus;
	private String mdiaryresid;
	public Mydiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mydiary(int mdiaryid, int userid, Date mdiarytime,
			String mdiaryname, String mdiarycont, int mdiarystatus,
			String mdiaryresid) {
		super();
		this.mdiaryid = mdiaryid;
		this.userid = userid;
		this.mdiarytime = mdiarytime;
		this.mdiaryname = mdiaryname;
		this.mdiarycont = mdiarycont;
		this.mdiarystatus = mdiarystatus;
		this.mdiaryresid = mdiaryresid;
	}
	public int getMdiaryid() {
		return mdiaryid;
	}
	public void setMdiaryid(int mdiaryid) {
		this.mdiaryid = mdiaryid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getMdiarytime() {
		return mdiarytime;
	}
	public void setMdiarytime(Date datetime) {
		this.mdiarytime = datetime;
	}
	public String getMdiaryname() {
		return mdiaryname;
	}
	public void setMdiaryname(String mdiaryname) {
		this.mdiaryname = mdiaryname;
	}
	public String getMdiarycont() {
		return mdiarycont;
	}
	public void setMdiarycont(String mdiarycont) {
		this.mdiarycont = mdiarycont;
	}
	public int getMdiarystatus() {
		return mdiarystatus;
	}
	public void setMdiarystatus(int mdiarystatus) {
		this.mdiarystatus = mdiarystatus;
	}
	public String getMdiaryresid() {
		return mdiaryresid;
	}
	public void setMdiaryresid(String mdiaryresid) {
		this.mdiaryresid = mdiaryresid;
	}
	@Override
	public String toString() {
		return "Mydiary [mdiaryid=" + mdiaryid + ", userid=" + userid
				+ ", mdiarytime=" + mdiarytime + ", mdiaryname=" + mdiaryname
				+ ", mdiarycont=" + mdiarycont + ", mdiarystatus="
				+ mdiarystatus + ", mdiaryresid=" + mdiaryresid + "]";
	}
	
	
	

}
