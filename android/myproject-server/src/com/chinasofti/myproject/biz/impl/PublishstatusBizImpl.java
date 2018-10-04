package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.IPublishstatusBiz;
import com.chinasofti.myproject.dao.IPublishstatusDao;
import com.chinasofti.myproject.dao.impl.PublishstatusDaoImpl;
import com.chinasofti.myproject.po.Publishstatus;

public class PublishstatusBizImpl implements IPublishstatusBiz {
	
	private IPublishstatusDao publishstatusDao;
	

	public PublishstatusBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.publishstatusDao= new PublishstatusDaoImpl();
	}


	@Override
	public boolean writeshuoshuo(Publishstatus publishstatus) {
		// TODO Auto-generated method stub
		return this.publishstatusDao.insertPublishstatus(publishstatus)>0?true:false;
	}

}
