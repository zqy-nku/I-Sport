package com.chinasofti.myproject.biz;



import java.util.List;

import com.chinasofti.myproject.po.Coach;
import com.chinasofti.myproject.po.Coachcomment;

public interface ICoachBiz {
	public  Coach selectByName(String coaname);
    public List<Coach> selectBySportid(int sportid);
    public Coach selectById(int coachid);
    public boolean insertCoachComment(Coachcomment coachcomment);
}
