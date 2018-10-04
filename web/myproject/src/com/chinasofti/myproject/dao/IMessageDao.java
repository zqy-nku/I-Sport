package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Message;

public interface IMessageDao {
	public abstract List<Message> selectAllMessage();
	public abstract Message selectMessageById(final long msgid);
	public abstract int deleteMessageById(final long msgid);
	public abstract int updateMessage(final Message message);
	public abstract int insertMessage(final Message message);
	public abstract List<Message> selectByUserFridid(final int userid,final int fid);

}
