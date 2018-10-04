package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Coachcomment;



public interface ICoachcommentDao {
	public abstract int insertCoachcomment(final Coachcomment coachcomment);
	public abstract List<Coachcomment> selectAllCoachcomment();
	public abstract int deleteCoachcommentById(final int coacomid);
	public abstract Coachcomment selectCoachcommentById(final int coacomid);
	public abstract int updateCoachcomment(final Coachcomment coachcomment);
	public abstract List<Coachcomment> selectByCoaid(int coachid);

}
