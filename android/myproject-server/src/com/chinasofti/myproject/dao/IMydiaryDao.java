package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Mydiary;

public interface IMydiaryDao {
	public abstract List<Mydiary> selectAllMydiary();
	public abstract Mydiary selectMydiaryById(final int mdiaryid);
	public abstract int deleteMydiaryById(final int mdiaryid);
	public abstract int updateMydiary(final Mydiary mydiary);
	public abstract int insertMydiary(final Mydiary mydiary);
    public abstract List<Mydiary> selectByUserid(final int userid);

}
