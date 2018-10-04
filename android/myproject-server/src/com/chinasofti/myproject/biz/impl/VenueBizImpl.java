package com.chinasofti.myproject.biz.impl;

import java.util.List;

import com.chinasofti.myproject.biz.IVenueBiz;
import com.chinasofti.myproject.dao.IVenueDao;
import com.chinasofti.myproject.dao.IVenuecommentDao;
import com.chinasofti.myproject.dao.impl.VenueDaoImpl;
import com.chinasofti.myproject.dao.impl.VenuecommentDaoImpl;
import com.chinasofti.myproject.po.Venue;
import com.chinasofti.myproject.po.Venuecomment;

public class VenueBizImpl implements IVenueBiz {
	private IVenueDao venueDao;
	private IVenuecommentDao venuecommentDao;

	public VenueBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.venueDao=new VenueDaoImpl();
		this.venuecommentDao=new VenuecommentDaoImpl();
	}


	@Override
	public List<Venue> selectBySportid(int sportid) {
		// TODO Auto-generated method stub
		return venueDao.selectByVensportid(sportid);
	}


	@Override
	public Venue selectById(int venueid) {
		// TODO Auto-generated method stub
		return venueDao.selectById(venueid);
	}


	@Override
	public boolean InsertVenueComment(Venuecomment vc) {
		// TODO Auto-generated method stub
		return venuecommentDao.insertVenuecomment(vc)>0?true:false;
	}

}
