package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Peruser;

public interface IPeruserDao {
	public abstract Peruser selectById(final int userid);
	public abstract List<Peruser> selectAll();
	public abstract List<Peruser> selectByName(final String nickname);

}
