package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Sport;

public interface ISportBiz {
	public abstract List<Sport> findAllSport();
	public abstract Sport findSportByName(final String sportname);
	public abstract String findNameById(final int id);

}
