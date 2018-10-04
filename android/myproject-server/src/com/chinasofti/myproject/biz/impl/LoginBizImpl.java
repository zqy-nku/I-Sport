package com.chinasofti.myproject.biz.impl;

import com.chinasofti.myproject.biz.ILoginBiz;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.po.Person;

public class LoginBizImpl implements ILoginBiz {
	private IPersonDao personDao;
	

	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.personDao=new PersonDaoImpl();
	}


	@Override
	public Person isLogin(String account, String password) {
		// TODO Auto-generated method stub
		return personDao.selectByObject(account, password);
	}

}
