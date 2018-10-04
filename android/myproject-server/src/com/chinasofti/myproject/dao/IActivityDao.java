package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Actihuo;

public interface IActivityDao {
	public abstract List<Actihuo> selectAll();
	public abstract Actihuo selectByActiid(int actiid);
	public abstract List<Actihuo> selectBySportname(String sportname);
	public abstract List<Actihuo> selectByActiname(String actiname);
	

}
