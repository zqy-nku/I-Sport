package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.ISportBiz;
import com.chinasofti.myproject.dao.ISportDao;
import com.chinasofti.myproject.dao.impl.SportDaoImpl;
import com.chinasofti.myproject.po.Sport;

public class SportBizImpl implements ISportBiz {
	private ISportDao sportDao;
	

	public SportBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.sportDao = new SportDaoImpl();
	}


	@Override
	public List<Sport> findAllSport() {
		// TODO Auto-generated method stub
		return this.sportDao.selectAll();
	}


	@Override
	public Sport findSportByName(String sportname) {
		// TODO Auto-generated method stub
		return this.sportDao.selectByName(sportname);
	}


	@Override
	public String findNameById(int id) {
		// TODO Auto-generated method stub
		return this.sportDao.selectById(id);
	}

}
