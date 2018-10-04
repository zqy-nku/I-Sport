package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.IPersonBiz;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.po.Person;

public class PersonBizImpl implements IPersonBiz {
	private IPersonDao personDao;
	

	public PersonBizImpl() {
		super();
		this.personDao = new PersonDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Person findByAccount(String account) {
		// TODO Auto-generated method stub
		return this.personDao.selectPersonByAccount(account);
	}

	@Override
	public Person findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return this.personDao.selectPersonByNickname(nickname);
	}

	@Override
	public boolean registerPerson(Person person) {
		// TODO Auto-generated method stub
		return this.personDao.insertPerson(person)>0?true:false;
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return this.personDao.updatePerson(person)>0?true:false;
	}

}
