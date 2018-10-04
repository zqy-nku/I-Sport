package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.VDiary;

public interface IShowAllDiaryBiz {
	
	public abstract List<VDiary> show(int userid);

}
