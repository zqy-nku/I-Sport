package com.chinasofti.myproject.po;

public class Peruser {
	private int userid;
	private String nickname;
	private String userpho;
	private String sportlabel;
	private String gender;
	public Peruser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Peruser(int userid, String nickname, String userpho,
			String sportlabel, String gender) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.userpho = userpho;
		this.sportlabel = sportlabel;
		this.gender = gender;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Peruser [userid=" + userid + ", nickname=" + nickname
				+ ", userpho=" + userpho + ", sportlabel=" + sportlabel
				+ ", gender=" + gender + "]";
	}


	
}
