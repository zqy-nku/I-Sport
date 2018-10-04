package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Friendrelation;

public interface IFriendrelationDao {
	public abstract int insertFriendrelation(final Friendrelation friendrelation);
	public abstract int updateFriendrelation(final Friendrelation friendrelation);
	public abstract List<Friendrelation> selectAllFrienndrelation();
	public abstract Friendrelation selectFriendrelationById(final int relatid);
	public abstract int deleteFriendrelationById(final int relatid);
	public abstract List<Friendrelation> selectByUserid(final int userid);
	public abstract int deleteRelationByUserid(final int uid, final int fid);
}
