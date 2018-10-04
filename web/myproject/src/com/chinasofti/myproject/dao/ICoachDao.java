package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Coach;

public interface ICoachDao {
	
	public abstract int insertCoach(final Coach coach);
	public abstract List<Coach> selectAllCoach();
	public abstract int deleteCoachById(final int coachid);
	public abstract Coach selectCoachById(final int coachid);
	public abstract int updateCoach(final Coach coach);
	public abstract Coach selectByCoaname(final String coaname);
	public abstract List<Coach> selectByCoagender(final String coagender);
	public abstract List<Coach> selectByCoatypeid(final int coatypeid);

}
