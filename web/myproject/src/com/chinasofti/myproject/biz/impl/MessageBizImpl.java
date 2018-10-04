package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.IMessageBiz;
import com.chinasofti.myproject.dao.IMessageDao;
import com.chinasofti.myproject.dao.impl.MessageDaoImpl;
import com.chinasofti.myproject.po.Message;

public class MessageBizImpl implements IMessageBiz {
	private IMessageDao messageDao;

	public MessageBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.messageDao = new MessageDaoImpl();
	}

	@Override
	public boolean addMessage(Message message) {
		// TODO Auto-generated method stub
		return this.messageDao.insertMessage(message)>0?true:false;
	}

	@Override
	public List<Message> findByUserFridid(int userid, int fid) {
		// TODO Auto-generated method stub
		return this.messageDao.selectByUserFridid(userid, fid);
	}

}
