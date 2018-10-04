package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Offiacti;

public interface IOffiactiDao {

	public abstract int insertOffiacti(final Offiacti offiacti);
	public abstract int deleteOffiactiById(final int offiactiid);
	public abstract Offiacti selectOffiactiById(final int offiactiid);
	public abstract int updateOffiacti(final Offiacti offiacti);
	public abstract List<Offiacti> selectAllOffiacti();
	public abstract List<Offiacti> selectByOffiactiname(final String offiactiname);
	public abstract List<Offiacti> selectByOffiactitype(final int offiactitype);
}
