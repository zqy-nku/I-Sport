package com.chinasofti.myproject.biz;

import java.util.List;

import com.chinasofti.myproject.po.Friendrelation;
import com.chinasofti.myproject.po.Peruser;
import com.chinasofti.myproject.po.Sporttreasure;
import com.chinasofti.myproject.po.User;

public interface IUserBiz {
	public abstract String findSportlabel(int userid);
	public abstract boolean updateUser(final User user);
	public abstract User findByRegid(final int regid);
	public abstract boolean addUser(final User user);
	public abstract List<String> showMylabel(final int userid);
	public abstract List<Sporttreasure> showMyCollect(final int userid);
	public abstract List<Peruser> tuiFriend(final int userid,int offset,int pageSize);
	public abstract List<Peruser> allFriend(final int userid,int offset,int pageSize);
	public abstract List<Peruser> datedFriend(final int userid);
	public abstract boolean addFriend(Friendrelation friendrelation);
	public abstract List<Peruser> sameFriend(final int userid,final int fid,int offset,int pageSize);
	public abstract boolean praise(int userid,int pra);
	public abstract boolean delFriend(final int uid,final int fid);
	public abstract List<Peruser> recomFriend(final int userid);
	public abstract List<Peruser> findMyfriend(final int userid);

}





