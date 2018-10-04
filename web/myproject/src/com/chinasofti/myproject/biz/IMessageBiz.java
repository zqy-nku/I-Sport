package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Message;

public interface IMessageBiz {
	public abstract boolean addMessage(final Message message);
	public abstract List<Message> findByUserFridid(final int userid, final int fid);

}
