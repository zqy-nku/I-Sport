package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Venuecomment;

public interface IVenuecommentDao {
	public abstract List<Venuecomment> selectAllVenuecomment();
	public abstract Venuecomment selectVenuecommentById(final int vencomid);
	public abstract int deleteVenuecommentById(final int vencomid);
	public abstract int updateVenuecomment(final Venuecomment venuecomment);
	public abstract int insertVenuecomment(final Venuecomment venuecomment);
	public abstract List<Venuecomment> selectByVenueid(int venueid);


}
