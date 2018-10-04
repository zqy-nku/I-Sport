package com.chinasofti.myproject.biz;

import com.chinasofti.myproject.po.Person;



public interface ILoginBiz {
	public abstract Person isLogin(final String account, final String password);

}
