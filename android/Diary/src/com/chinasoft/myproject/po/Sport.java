package com.chinasoft.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sport implements Serializable {
	private int sportid;
	private String sportname;
	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sport(int sportid, String sportname) {
		super();
		this.sportid = sportid;
		this.sportname = sportname;
	}
	public int getSportid() {
		return sportid;
	}
	public void setSportid(int sportid) {
		this.sportid = sportid;
	}
	public String getSportname() {
		return sportname;
	}
	public void setSportname(String sportname) {
		this.sportname = sportname;
	}
	@Override
	public String toString() {
		return "Sport [sportid=" + sportid + ", sportname=" + sportname + "]";
	}
	
	

}
