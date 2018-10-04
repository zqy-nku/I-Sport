package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.ILoginBiz;
import com.chinasofti.myproject.biz.IPersonBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.LoginBizImpl;
import com.chinasofti.myproject.biz.impl.PersonBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IPeruserDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.PeruserDaoImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;
import com.chinasofti.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		System.out.println("开始注册--------");
		String regperson = request.getParameter("regperson");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Person person = gson.fromJson(regperson, Person.class);

		System.out.println(person.toString());
		// -------------------处理数据-----------------------
		//注册person
		int issuccess = 0;
		IPersonBiz personBiz = new PersonBizImpl();
		if(personBiz.findByAccount(person.getAccount()) != null ){
			issuccess = -1;
		} else if( personBiz.findByNickname(person.getNickname()) != null){
			// person加入数据库
			issuccess = -2;
		} else{
			issuccess = 1;
		}
		//根据返回情况执行
		if(issuccess == 1){
				personBiz.registerPerson(person);
				//用户加入数据库
				User user = new User();
				user.setRegid(person.getRegid());
				IUserBiz userBiz = new UserBizImpl();
				System.out.println(user.toString());
				userBiz.addUser(user);
				//
			}
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(issuccess);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();


	}

}
