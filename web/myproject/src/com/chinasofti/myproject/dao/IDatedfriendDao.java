package com.chinasofti.myproject.dao;

import java.util.List;
import com.chinasofti.myproject.po.Datedfriend;

public interface IDatedfriendDao {
	public abstract int insert(final Datedfriend datedfriend);
	public abstract List<Datedfriend> selectAll();
	public abstract int deleteById(final int datefrirelaid);
	public abstract Datedfriend selectById(final int datefrirelaid);
	public abstract int update(Datedfriend datedfriend );
	public abstract List<Datedfriend> selectByUserid(final int userid);
	public abstract List<Datedfriend> selectByDatedType(final int datedtype);
   public abstract List<Datedfriend> selectByFriendid(final int friendid);
}
