package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.IResourceBiz;
import com.chinasofti.myproject.dao.IResourceDao;
import com.chinasofti.myproject.dao.impl.ResourceDaoImpl;
import com.chinasofti.myproject.po.Resource;

public class ResourceBizImpl implements IResourceBiz {
	private IResourceDao resourceDao;
	
	

	public ResourceBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.resourceDao = new ResourceDaoImpl();
	}



	@Override
	public boolean sendphoto(Resource resource) {
		// TODO Auto-generated method stub
		return this.resourceDao.insertResource(resource)>0?true:false;
	}

}
