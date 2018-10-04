package com.chinasofti.myproject.biz.impl;


import java.util.List;

import com.chinasofti.myproject.biz.ICoachBiz;
import com.chinasofti.myproject.dao.ICoachDao;
import com.chinasofti.myproject.dao.ICoachcommentDao;
import com.chinasofti.myproject.dao.impl.CoachDaoImpl;
import com.chinasofti.myproject.dao.impl.CoachcommentDaoImpl;
import com.chinasofti.myproject.po.Coach;
import com.chinasofti.myproject.po.Coachcomment;

public class CoachBizImpl implements ICoachBiz {

	private ICoachDao coachDao;
	private ICoachcommentDao coachcommentDao;
	
	public CoachBizImpl() {
		super();
		this.coachDao =new CoachDaoImpl();
		this.coachcommentDao=new CoachcommentDaoImpl();
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public Coach selectByName(String coaname) {
		// TODO Auto-generated method stub
	
	    return coachDao.selectByCoaname(coaname);
	}
	@Override
	public List<Coach> selectBySportid(int sportid) {
		// TODO Auto-generated method stub
		return coachDao.selectByCoatypeid(sportid);
	}
	@Override
	public Coach selectById(int coachid) {
		// TODO Auto-generated method stub
		return coachDao.selectCoachById(coachid);
	}
	@Override
	public boolean insertCoachComment(Coachcomment coachcomment) {
		// TODO Auto-generated method stub
		return coachcommentDao.insertCoachcomment(coachcomment)>0?true:false;
	}

	



	
	

}
