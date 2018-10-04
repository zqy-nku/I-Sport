package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Actihuo;
import com.chinasofti.myproject.po.Activityinvitation;



public interface IActivityBiz {
	

	public List<Actihuo> searchActiBySname(String sportname);
	public List<Actihuo> searchActiByAname(String actiname);
	public List<Actihuo> TuiActivity(int userid);
	public List<Actihuo> HotActivity();
	public List<Actihuo> JoinedActivity(int userid);

}
