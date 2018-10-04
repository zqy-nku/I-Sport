package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.IShowAllDiaryBiz;
import com.chinasofti.myproject.dao.IVDiaryDao;
import com.chinasofti.myproject.dao.impl.VDiaryDaoImpl;
import com.chinasofti.myproject.po.VDiary;

public class ShowAllDiaryBizImpl implements IShowAllDiaryBiz {
    
	private IVDiaryDao vDiaryDao;
	
	
	
	public ShowAllDiaryBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.vDiaryDao=new VDiaryDaoImpl();
	}



	@Override
	public List<VDiary> show(int userid) {
		// TODO Auto-generated method stub
		
		return this.vDiaryDao.select(userid);
	}
	

}
