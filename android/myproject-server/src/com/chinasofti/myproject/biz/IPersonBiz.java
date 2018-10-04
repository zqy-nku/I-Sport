package com.chinasofti.myproject.biz;

import com.chinasofti.myproject.po.Person;

public interface IPersonBiz {
	public abstract Person findByAccount(final String account);
	public abstract Person findByNickname(final String nickname);
	public abstract boolean registerPerson(final Person person);
	public abstract boolean updatePerson(final Person person);

}
