package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Activity;
import com.chinasofti.myproject.po.Activityinvitation;



public interface IActivityBiz {
	
	public List<Activity> showAJacti(int userid);
	public List<Activity> searchActiBySname(String sportname);
	public List<Activity> searchActiByAname(String actiname);
	public List<Activity> TuiActivity(int userid);
	public List<Activity> HotActivity();
	public List<Activity> JoinedActivity(int userid);

}
