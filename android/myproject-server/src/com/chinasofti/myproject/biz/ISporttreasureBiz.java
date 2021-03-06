package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Sporttreasure;

public interface ISporttreasureBiz {
	public abstract List<Sporttreasure> findAll();
	public abstract List<Sporttreasure> findTreasBySportid(final int sportid);
	public abstract List<Sporttreasure> findTreasByKeyword(final String keyword);
	public abstract Sporttreasure findTreasByTreasId(final int treasid);
	public abstract boolean updateTreas(final Sporttreasure treas);
}
