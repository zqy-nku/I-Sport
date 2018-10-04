package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Activity;

public interface IActivityDao {
	public abstract List<Activity> selectAll();
	public abstract Activity selectByActiid(int actiid);
	public abstract List<Activity> selectBySportname(String sportname);
	public abstract List<Activity> selectByActiname(String actiname);
	

}
