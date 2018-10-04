package com.chinasoft.myproject.po;

import java.util.Date;

public class VDiary {
	
	private int mdiaryid;
	private int userid;
	private String userpho;
	private String sportlabel;
	private Date mdiarytime;
	private String mdiaryname;
	private String mdiarycont;
	public VDiary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VDiary(int mdiaryid, int userid, String userpho, String sportlabel,
			Date mdiarytime, String mdiaryname, String mdiarycont) {
		super();
		this.mdiaryid = mdiaryid;
		this.userid = userid;
		this.userpho = userpho;
		this.sportlabel = sportlabel;
		this.mdiarytime = mdiarytime;
		this.mdiaryname = mdiaryname;
		this.mdiarycont = mdiarycont;
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

	public String getUserpho() {
		return userpho;
	}

	public void setUserpho(String userpho) {
		this.userpho = userpho;
	}

	public String getSportlabel() {
		return sportlabel;
	}

	public void setSportlabel(String sportlabel) {
		this.sportlabel = sportlabel;
	}

	public Date getMdiarytime() {
		return mdiarytime;
	}

	public void setMdiarytime(Date mdiarytime) {
		this.mdiarytime = mdiarytime;
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

	@Override
	public String toString() {
		return "VDiary [mdiaryid=" + mdiaryid + ", userid=" + userid
				+ ", userpho=" + userpho + ", sportlabel=" + sportlabel
				+ ", mdiarytime=" + mdiarytime + ", mdiaryname=" + mdiaryname
				+ ", mdiarycont=" + mdiarycont + "]";
	}
	
}
