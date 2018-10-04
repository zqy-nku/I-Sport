package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dailytips implements Serializable {
	private int tipid;
	private String tipcontext;
	private String tipresid;
	private int tipstatus;
	public Dailytips() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dailytips(int tipid, String tipcontext, String tipresid,
			int tipstatus) {
		super();
		this.tipid = tipid;
		this.tipcontext = tipcontext;
		this.tipresid = tipresid;
		this.tipstatus = tipstatus;
	}
	public int getTipid() {
		return tipid;
	}
	public void setTipid(int tipid) {
		this.tipid = tipid;
	}
	public String getTipcontext() {
		return tipcontext;
	}
	public void setTipcontext(String tipcontext) {
		this.tipcontext = tipcontext;
	}
	public String getTipresid() {
		return tipresid;
	}
	public void setTipresid(String tipresid) {
		this.tipresid = tipresid;
	}
	public int getTipstatus() {
		return tipstatus;
	}
	public void setTipstatus(int tipstatus) {
		this.tipstatus = tipstatus;
	}
	@Override
	public String toString() {
		return "Dailytips [tipid=" + tipid + ", tipcontext=" + tipcontext
				+ ", tipresid=" + tipresid + ", tipstatus=" + tipstatus + "]";
	}
	
	

}
