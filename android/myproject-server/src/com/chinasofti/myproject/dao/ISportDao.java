package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Sport;

public interface ISportDao {
	public abstract int insertSport(final Sport sport);
	public abstract int insertSportList(final List<Sport> lstSport);
	public abstract Sport selectByName(final String name);
	public abstract List<Sport> selectAll();
	public abstract int deleteSportById(final int id);
	public abstract int deleteSportByName(final String name);
	public abstract int deleteSportAll();
	public abstract Sport selectBySportid(final int sportid);
	public String selectById(final int id);
	

}