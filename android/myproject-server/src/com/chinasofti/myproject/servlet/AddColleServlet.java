package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.ISporttreasureBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.SporttreasureBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Sporttreasure;
import com.chinasofti.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AddColleServlet
 */

public class AddColleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		System.out.println("AddColeServlet进入");
		String struserid = request.getParameter("userId");
		String strtreasid = request.getParameter("treasId");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		int userid = gson.fromJson(struserid, int.class);
		int treasid = gson.fromJson(strtreasid, int.class);
		System.out.println("gson="+gson);
		//
		boolean flag = false;
		//更新用户数据库
		IUserBiz userBiz = new UserBizImpl();
		User user = userBiz.findByRegid(userid);
		String usercollect = user.getColletreasid();
		usercollect = usercollect + treasid +"/";
		user.setColletreasid(usercollect);
		flag = userBiz.updateUser(user);
		//更新宝典数据库
		ISporttreasureBiz treasureBiz = new SporttreasureBizImpl();
		Sporttreasure treasure = treasureBiz.findTreasByTreasId(treasid);
		treasure.setTreascollecount(treasure.getTreascollecount()+1);
		flag = treasureBiz.updateTreas(treasure);
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}
