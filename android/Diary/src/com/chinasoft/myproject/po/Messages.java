package com.chinasoft.myproject.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Messages implements Serializable {

	private int msgid;
	private Date publish;
	private String message;
	private int userid;
	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messages(int msgid, Date publish, String message, int userid) {
		super();
		this.msgid = msgid;
		this.publish = publish;
		this.message = message;
		this.userid = userid;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public Date getPublish() {
		return publish;
	}
	public void setPublish(Date publish) {
		this.publish = publish;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Messages [msgid=" + msgid + ", publish=" + publish
				+ ", message=" + message + ", userid=" + userid + "]";
	}
	
}
