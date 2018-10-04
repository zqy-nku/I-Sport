package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Offiacti implements Serializable {
	private int offiactiid;
	private String offiactiname;
	private String offiactitime;
	private String offiactiplace;
	private int offiactitype;
	private String offiactisimpintr;
	private int offiactistatus;
	private String offiactires;
	public Offiacti() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offiacti(int offiactiid, String offiactiname, String offiactitime,
			String offiactiplace, int offiactitype, String offiactisimpintr,
			int offiactistatus, String offiactires) {
		super();
		this.offiactiid = offiactiid;
		this.offiactiname = offiactiname;
		this.offiactitime = offiactitime;
		this.offiactiplace = offiactiplace;
		this.offiactitype = offiactitype;
		this.offiactisimpintr = offiactisimpintr;
		this.offiactistatus = offiactistatus;
		this.offiactires = offiactires;
	}
	public int getOffiactiid() {
		return offiactiid;
	}
	public void setOffiactiid(int offiactiid) {
		this.offiactiid = offiactiid;
	}
	public String getOffiactiname() {
		return offiactiname;
	}
	public void setOffiactiname(String offiactiname) {
		this.offiactiname = offiactiname;
	}
	public String getOffiactitime() {
		return offiactitime;
	}
	public void setOffiactitime(String offiactitime) {
		this.offiactitime = offiactitime;
	}
	public String getOffiactiplace() {
		return offiactiplace;
	}
	public void setOffiactiplace(String offiactiplace) {
		this.offiactiplace = offiactiplace;
	}
	public int getOffiactitype() {
		return offiactitype;
	}
	public void setOffiactitype(int offiactitype) {
		this.offiactitype = offiactitype;
	}
	public String getOffiactisimpintr() {
		return offiactisimpintr;
	}
	public void setOffiactisimpintr(String offiactisimpintr) {
		this.offiactisimpintr = offiactisimpintr;
	}
	public int getOffiactistatus() {
		return offiactistatus;
	}
	public void setOffiactistatus(int offiactistatus) {
		this.offiactistatus = offiactistatus;
	}
	public String getOffiactires() {
		return offiactires;
	}
	public void setOffiactires(String offiactires) {
		this.offiactires = offiactires;
	}
	@Override
	public String toString() {
		return "Offiacti [offiactiid=" + offiactiid + ", offiactiname="
				+ offiactiname + ", offiactitime=" + offiactitime
				+ ", offiactiplace=" + offiactiplace + ", offiactitype="
				+ offiactitype + ", offiactisimpintr=" + offiactisimpintr
				+ ", offiactistatus=" + offiactistatus + ", offiactires="
				+ offiactires + "]";
	}
	
	
	

}
