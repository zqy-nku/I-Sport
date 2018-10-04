package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.User;

public interface IUserDao {
	public abstract List<User> selectAllUser();
	public abstract User selectUserById(final int userid);
	public abstract int deleteUserById(final int userid);
	public abstract int updateUser(final User user);
	public abstract int insertUser(final User user);
	public abstract String findSportlabel(final int userid);
	public abstract User selectUserByRegid(final int regid);
	public abstract List<User> selectMyfriend(final int userid);
	public abstract List<User> selectOtherUser(final int userid);



}
