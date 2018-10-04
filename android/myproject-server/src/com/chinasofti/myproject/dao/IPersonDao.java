package com.chinasofti.myproject.dao;

import java.util.List;

import com.chinasofti.myproject.po.Person;

public interface IPersonDao {
	public abstract int insertPerson(final Person person);
	public abstract int deletePersonById(final int regid);
	public abstract Person selectPersonById(final int regid);
	public abstract int updatePerson(final Person person);
	public abstract List<Person> selectAllPerson();
	public abstract Person selectPersonByAccount(final String account);
	public abstract Person selectPersonByNickname(final String nickname);
	public abstract Person selectByObject(String account,String password);
	public abstract Person findByCondition(final Person p);
}
