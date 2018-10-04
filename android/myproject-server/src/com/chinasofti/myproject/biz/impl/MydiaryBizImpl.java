package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.IMydiaryBiz;
import com.chinasofti.myproject.dao.IMydiaryDao;
import com.chinasofti.myproject.dao.impl.MydiaryDaoImpl;
import com.chinasofti.myproject.po.Mydiary;

public class MydiaryBizImpl implements IMydiaryBiz {
 
	private IMydiaryDao mydiaryDao;
	
	public MydiaryBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	this.mydiaryDao=new MydiaryDaoImpl();
	}
	

	@Override
	public boolean writediary(Mydiary mydiary) {
		// TODO Auto-generated method stub
		return this.mydiaryDao.insertMydiary(mydiary)>0?true:false;
	}

}
