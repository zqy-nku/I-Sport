package com.chinasoft.myproject.po;

import java.util.Date;

public class VMessages {

	private int msgid;
	private String photo;
	private String nickname;
	private Date publish;
	private String message;
	public VMessages() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VMessages(int msgid, String photo, String nickname, Date publish,
			String message) {
		super();
		this.msgid = msgid;
		this.photo = photo;
		this.nickname = nickname;
		this.publish = publish;
		this.message = message;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	@Override
	public String toString() {
		return "VMessages [msgid=" + msgid + ", photo=" + photo + ", nickname="
				+ nickname + ", publish=" + publish + ", message=" + message
				+ "]";
	}
	
}
