package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Vshuoshuo;


public interface IVShuoshuoDao {
	
	 public abstract List<Vshuoshuo> select(int userid);

}
