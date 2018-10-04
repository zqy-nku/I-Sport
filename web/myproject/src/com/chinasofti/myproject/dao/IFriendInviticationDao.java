package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Friendinvitation;



public interface IFriendInviticationDao {
	public abstract int insert(final Friendinvitation friendinvitation);
	public abstract List<Friendinvitation> selectAll();
	public abstract int deleteById(final int inviid);
	public abstract Friendinvitation selectById(final int inviid);
	public abstract int update(Friendinvitation friendinvitation );
	public abstract List<Friendinvitation> selectByUserid(final int userid);
	public abstract List<Friendinvitation> selectBySportid(final int sportid);
	public abstract List<Friendinvitation> selectByInvibegtime(final String invibegtime);
	public abstract List<Friendinvitation> selectByPartuserid(final int partuserid);

}
