package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	
	private int regid;
	private String account;
	private String password;
	private String nickname;
	private String regtime;
	private String regaddr;
	private String reggender;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(int regid, String account, String password, String nickname,
			String regtime, String regaddr, String reggender) {
		super();
		this.regid = regid;
		this.account = account;
		this.password = password;
		this.nickname = nickname;
		this.regtime = regtime;
		this.regaddr = regaddr;
		this.reggender = reggender;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getRegaddr() {
		return regaddr;
	}
	public void setRegaddr(String regaddr) {
		this.regaddr = regaddr;
	}
	public String getReggender() {
		return reggender;
	}
	public void setReggender(String reggender) {
		this.reggender = reggender;
	}
	@Override
	public String toString() {
		return "Person [regid=" + regid + ", account=" + account
				+ ", password=" + password + ", nickname=" + nickname
				+ ", regtime=" + regtime + ", regaddr=" + regaddr
				+ ", reggender=" + reggender + "]";
	}
	
	

}
