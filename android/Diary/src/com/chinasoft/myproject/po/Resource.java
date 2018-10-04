package com.chinasoft.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Resource implements Serializable {
	private int resid;
	private int userid;
	private String restype;
	private Date restime;
	private String resdesc;
	private String reslocation;
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resource(int resid, int userid, String restype, Date restime,
			String resdesc, String reslocation) {
		super();
		this.resid = resid;
		this.userid = userid;
		this.restype = restype;
		this.restime = restime;
		this.resdesc = resdesc;
		this.reslocation = reslocation;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRestype() {
		return restype;
	}
	public void setRestype(String restype) {
		this.restype = restype;
	}
	public Date getRestime() {
		return restime;
	}
	public void setRestime(Date restime2) {
		this.restime = restime2;
	}
	public String getResdesc() {
		return resdesc;
	}
	public void setResdesc(String resdesc) {
		this.resdesc = resdesc;
	}
	public String getReslocation() {
		return reslocation;
	}
	public void setReslocation(String reslocation) {
		this.reslocation = reslocation;
	}
	@Override
	public String toString() {
		return "Resource [resid=" + resid + ", userid=" + userid + ", restype="
				+ restype + ", restime=" + restime + ", resdesc=" + resdesc
				+ ", reslocation=" + reslocation + "]";
	}
	
	

}
