package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.IDailytipsBiz;
import com.chinasofti.myproject.dao.IDailytipsDao;
import com.chinasofti.myproject.dao.impl.DailytipsDaoImpl;
import com.chinasofti.myproject.po.Dailytips;

public class DailytipsBizImpl implements IDailytipsBiz {
	private IDailytipsDao dailytipsDao;

	public DailytipsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dailytipsDao = new DailytipsDaoImpl();
	}

	@Override
	public Dailytips findByRand() {
		// TODO Auto-generated method stub
		return this.dailytipsDao.selectByRand();
	}

}
