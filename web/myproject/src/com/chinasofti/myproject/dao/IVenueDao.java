package com.chinasofti.myproject.dao;

import java.util.List;
import com.chinasofti.myproject.po.Venue;

public interface IVenueDao {
	public abstract int insert(final Venue venue);
	public abstract List<Venue> selectAll();
	public abstract int deleteById(final int venueid);
	public abstract Venue selectById(final int venueid);
	public abstract int update(Venue venue);
	public abstract List<Venue> selectByVenuename(final String venuename);
	public abstract List<Venue> sortByVenPrice(List<Venue> lstVenue);
	public abstract List<Venue> sortByVencomgrade(List<Venue> lstVenue);
	public abstract  List<Venue> selectByVensportid(final int vensportid);


}
