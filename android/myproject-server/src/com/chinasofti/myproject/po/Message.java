package com.chinasofti.myproject.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private long msgid;
	private int userid;
	private int touserid;
	private String msgtime;
	private String msgcontext;
	private String msgresid;
	private int msgstatus;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(long msgid, int userid, int touserid, String msgtime,
			String msgcontext, String msgresid, int msgstatus) {
		super();
		this.msgid = msgid;
		this.userid = userid;
		this.touserid = touserid;
		this.msgtime = msgtime;
		this.msgcontext = msgcontext;
		this.msgresid = msgresid;
		this.msgstatus = msgstatus;
	}
	public long getMsgid() {
		return msgid;
	}
	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTouserid() {
		return touserid;
	}
	public void setTouserid(int touserid) {
		this.touserid = touserid;
	}
	public String getMsgtime() {
		return msgtime;
	}
	public void setMsgtime(String msgtime) {
		this.msgtime = msgtime;
	}
	public String getMsgcontext() {
		return msgcontext;
	}
	public void setMsgcontext(String msgcontext) {
		this.msgcontext = msgcontext;
	}
	public String getMsgresid() {
		return msgresid;
	}
	public void setMsgresid(String msgresid) {
		this.msgresid = msgresid;
	}
	public int getMsgstatus() {
		return msgstatus;
	}
	public void setMsgstatus(int msgstatus) {
		this.msgstatus = msgstatus;
	}
	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", userid=" + userid + ", touserid="
				+ touserid + ", msgtime=" + msgtime + ", msgcontext="
				+ msgcontext + ", msgresid=" + msgresid + ", msgstatus="
				+ msgstatus + "]";
	}

	

}
