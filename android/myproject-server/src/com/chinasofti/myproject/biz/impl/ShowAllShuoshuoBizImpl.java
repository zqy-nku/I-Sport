package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.IShowAllShuoshuoBiz;
import com.chinasofti.myproject.dao.IVShuoshuoDao;
import com.chinasofti.myproject.dao.impl.VShuoshuoDaoImpl;
import com.chinasofti.myproject.po.Vshuoshuo;

public class ShowAllShuoshuoBizImpl implements IShowAllShuoshuoBiz {

	private IVShuoshuoDao vShuoshuoDao;
	
	
	
	public ShowAllShuoshuoBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	    this.vShuoshuoDao=new VShuoshuoDaoImpl();
	}



	@Override
	public List<Vshuoshuo> show(int userid) {
		// TODO Auto-generated method stub
		return this.vShuoshuoDao.select(userid);
	}

}
