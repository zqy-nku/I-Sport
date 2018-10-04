package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Publishstatus;

public interface IPublishstatusDao {
	public abstract int insertPublishstatus(final Publishstatus publishstatus);
	public abstract int deletePublishstatusById(final int staid);
	public abstract Publishstatus selectPublishstatusById(final int staid);
	public abstract int updatePublishstatus(final Publishstatus publishstatus);
	public abstract List<Publishstatus> selectAllPublishstatus();
	public abstract List<Publishstatus> selectByUserid(final int userid);
}
