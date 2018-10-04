package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Resource;

public interface IResourceDao {
	public abstract int insertResource(final Resource resource);
	public abstract List<Resource> selectAll();
	public abstract Resource selectById(final int resid);
	public abstract int deleteResourceById(final int id);
	public abstract int updateResource(final Resource resource);
	public abstract List<Resource> selectByUserid(final int userid);
	public abstract List<Resource> selectByRestype(final String restype);
}
