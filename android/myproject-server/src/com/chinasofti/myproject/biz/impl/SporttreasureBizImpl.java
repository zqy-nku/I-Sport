package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.ISporttreasureBiz;
import com.chinasofti.myproject.dao.ISporttreasureDao;
import com.chinasofti.myproject.dao.impl.SportDaoImpl;
import com.chinasofti.myproject.dao.impl.SporttreasureDaoImpl;
import com.chinasofti.myproject.po.Sporttreasure;

public class SporttreasureBizImpl implements ISporttreasureBiz {
	private ISporttreasureDao sporttreasureDao;
	

	public SporttreasureBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.sporttreasureDao = new SporttreasureDaoImpl();
	}


	@Override
	public List<Sporttreasure> findAll() {
		// TODO Auto-generated method stub
		return this.sporttreasureDao.selectAll();
	}

	@Override
	public List<Sporttreasure> findTreasBySportid(int sportid) {
		// TODO Auto-generated method stub
		return this.sporttreasureDao.selectBySportid(sportid);
	}


	@Override
	public List<Sporttreasure> findTreasByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return this.sporttreasureDao.selectByKeyword(keyword);
	}


	@Override
	public Sporttreasure findTreasByTreasId(int treasid) {
		// TODO Auto-generated method stub
		return this.sporttreasureDao.selectById(treasid);
	}


	@Override
	public boolean updateTreas(Sporttreasure treas) {
		// TODO Auto-generated method stub
		return this.sporttreasureDao.updateSporttreasure(treas)>0?true:false;
	}

}
