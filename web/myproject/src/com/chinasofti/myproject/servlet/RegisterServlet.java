package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IPersonBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.PersonBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODOAuto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String account = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String gender = request.getParameter("Radiogender");
		String addr = request.getParameter("select");
		//注册person
		Person person =new Person();
		person.setAccount(account);
		person.setNickname(nickname);
		person.setPassword(password);
		person.setRegaddr(addr);
		person.setReggender(gender);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String regtime = sdf.format(date);
		person.setRegtime(regtime);
		System.out.println(person.toString());
		// person加入数据库
		IPersonBiz personBiz = new PersonBizImpl();
		personBiz.registerPerson(person);
		
		//用户加入数据库
		User user = new User();
		user.setRegid(person.getRegid());
		IUserBiz userBiz = new UserBizImpl();
		System.out.println(user.toString());
		userBiz.addUser(user);
		request.setAttribute("account", person.getAccount());
		//页面跳转
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("jsp/login.jsp");
		dispatcher.forward(request, response);
	

	}

}
