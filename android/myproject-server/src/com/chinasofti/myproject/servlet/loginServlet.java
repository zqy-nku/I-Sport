package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.ILoginBiz;
import com.chinasofti.myproject.biz.impl.LoginBizImpl;
import com.chinasofti.myproject.dao.IPeruserDao;
import com.chinasofti.myproject.dao.impl.PeruserDaoImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("come here");
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String user_data = request.getParameter("user_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Person person = gson.fromJson(user_data, Person.class);
		System.out.println("gson="+gson);
		
		// -------------------处理数据-----------------------
		ILoginBiz loginBiz = new LoginBizImpl();
		Person loginPerson = loginBiz.isLogin(person.getAccount(), person.getPassword());
		System.out.println("loginper="+loginPerson);
		//
		Peruser peruser = null;
		if(loginPerson != null){
			IPeruserDao peruserDao = new PeruserDaoImpl();
			peruser = peruserDao.selectById(loginPerson.getRegid());
		}
		System.out.println("peruser="+peruser);
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(peruser);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();

	}


}
