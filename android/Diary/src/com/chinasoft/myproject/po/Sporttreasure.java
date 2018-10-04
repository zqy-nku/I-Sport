package com.chinasoft.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sporttreasure implements Serializable {
	private int treasid;
	private int sportid;
	private String treaauthname;
	private String treasname;
	private String treaspubtime;
	private int treascollecount;
	private int treasviewcount;
	private String treascont;
	private String trearespath;
	public Sporttreasure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sporttreasure(int treasid, int sportid, String treaauthname,
			String treasname, String treaspubtime, int treascollecount,
			int treasviewcount, String treascont, String trearespath) {
		super();
		this.treasid = treasid;
		this.sportid = sportid;
		this.treaauthname = treaauthname;
		this.treasname = treasname;
		this.treaspubtime = treaspubtime;
		this.treascollecount = treascollecount;
		this.treasviewcount = treasviewcount;
		this.treascont = treascont;
		this.trearespath = trearespath;
	}
	public int getTreasid() {
		return treasid;
	}
	public void setTreasid(int treasid) {
		this.treasid = treasid;
	}
	public int getSportid() {
		return sportid;
	}
	public void setSportid(int sportid) {
		this.sportid = sportid;
	}
	public String getTreaauthname() {
		return treaauthname;
	}
	public void setTreaauthname(String treaauthname) {
		this.treaauthname = treaauthname;
	}
	public String getTreasname() {
		return treasname;
	}
	public void setTreasname(String treasname) {
		this.treasname = treasname;
	}
	public String getTreaspubtime() {
		return treaspubtime;
	}
	public void setTreaspubtime(String treaspubtime) {
		this.treaspubtime = treaspubtime;
	}
	public int getTreascollecount() {
		return treascollecount;
	}
	public void setTreascollecount(int treascollecount) {
		this.treascollecount = treascollecount;
	}
	public int getTreasviewcount() {
		return treasviewcount;
	}
	public void setTreasviewcount(int treasviewcount) {
		this.treasviewcount = treasviewcount;
	}
	public String getTreascont() {
		return treascont;
	}
	public void setTreascont(String treascont) {
		this.treascont = treascont;
	}
	public String getTrearespath() {
		return trearespath;
	}
	public void setTrearespath(String trearespath) {
		this.trearespath = trearespath;
	}
	@Override
	public String toString() {
		return "Sporttreasure [treasid=" + treasid + ", sportid=" + sportid
				+ ", treaauthname=" + treaauthname + ", treasname=" + treasname
				+ ", treaspubtime=" + treaspubtime + ", treascollecount="
				+ treascollecount + ", treasviewcount=" + treasviewcount
				+ ", treascont=" + treascont + ", trearespath=" + trearespath
				+ "]";
	}
	
	

}
