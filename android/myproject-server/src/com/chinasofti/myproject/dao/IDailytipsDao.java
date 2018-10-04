package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Dailytips;


public interface IDailytipsDao {
	public abstract int insert(final Dailytips dailytip);
	public abstract List<Dailytips> selectAll();
	public abstract int deleteById(final int tipid);
	public abstract Dailytips selectById(final int tipid);
	public abstract Dailytips selectByRand();
	public abstract int update(Dailytips dailytip );

}
