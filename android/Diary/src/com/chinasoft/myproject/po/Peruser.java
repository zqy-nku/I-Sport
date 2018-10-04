package com.chinasoft.myproject.po;

public class Peruser {
	private int userid;
	private String account;
	private String nickname;
	private String gender;
	private String colletreasid;
	private String zanactiid;
	private String actiid;
	private String userpho;
	private String sportlabel;

	public Peruser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Peruser(int userid, String account, String nickname, String gender,
			String colletreasid, String zanactiid, String actiid,
			String userpho, String sportlabel) {
		super();
		this.userid = userid;
		this.account = account;
		this.nickname = nickname;
		this.gender = gender;
		this.colletreasid = colletreasid;
		this.zanactiid = zanactiid;
		this.actiid = actiid;
		this.userpho = userpho;
		this.sportlabel = sportlabel;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColletreasid() {
		return colletreasid;
	}

	public void setColletreasid(String colletreasid) {
		this.colletreasid = colletreasid;
	}

	public String getZanactiid() {
		return zanactiid;
	}

	public void setZanactiid(String zanactiid) {
		this.zanactiid = zanactiid;
	}

	public String getActiid() {
		return actiid;
	}

	public void setActiid(String actiid) {
		this.actiid = actiid;
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

	@Override
	public String toString() {
		return "Peruser [userid=" + userid + ", account=" + account
				+ ", nickname=" + nickname + ", gender=" + gender
				+ ", colletreasid=" + colletreasid + ", zanactiid=" + zanactiid
				+ ", actiid=" + actiid + ", userpho=" + userpho
				+ ", sportlabel=" + sportlabel + "]";
	}
	

	
}
