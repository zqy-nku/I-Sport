package com.chinasoft.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friendrelation implements Serializable {
	private int relatid;
	private int userid;
	private int fid;
	public Friendrelation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friendrelation(int relatid, int userid, int fid) {
		super();
		this.relatid = relatid;
		this.userid = userid;
		this.fid = fid;
	}
	public int getRelatid() {
		return relatid;
	}
	public void setRelatid(int relatid) {
		this.relatid = relatid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	@Override
	public String toString() {
		return "Friendrelation [relatid=" + relatid + ", userid=" + userid
				+ ", fid=" + fid + "]";
	}
	
	

}
