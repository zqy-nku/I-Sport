package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Sporttreasure;

public interface ISporttreasureDao {
	public abstract Sporttreasure selectById(final int id);
	public abstract List<Sporttreasure> selectAll();
	public abstract List<Sporttreasure> selectBySportid(final int id);
	public abstract List<Sporttreasure> selectByTreasureName(final String treasurename);
	public abstract List<Sporttreasure> selectByKeyword(final String keyword);
	public abstract int insertSporttreasure(final Sporttreasure sporttreasure);
	public abstract int deleteById(final int id);
	public abstract int updateSporttreasure(final Sporttreasure sporttreasure);
	

}
