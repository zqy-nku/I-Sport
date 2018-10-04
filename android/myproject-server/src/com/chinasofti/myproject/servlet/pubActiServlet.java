package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IActivityDao;
import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class pubActiServlet
 */
public class pubActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pubActiServlet() {
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
		 System.out.println("来到发表的servlet了呢");
          request.setCharacterEncoding("UTF-8");
		
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String activityinvitation = request.getParameter("acti_data");
		System.out.println("客户端传来数据"+activityinvitation);
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Activityinvitation acti = gson.fromJson(activityinvitation, Activityinvitation.class);
		System.out.println("解析后的数据"+acti);
		
		// -------------------处理数据-----------------------
		IActivityinvitationDao activityinvitationDao=new ActivityinvitationDaoImpl();
		int flag=activityinvitationDao.insertActivityinvitation(acti);
		
		boolean istrue=flag>0?true:false;
		System.out.println("是否发表成功"+istrue);
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_flag = gson.toJson(istrue);
		System.out.println("servlet中查看是否成功发表活动"+istrue);
		out.println(gson_flag);
		
		out.flush();
		out.close();
	}

}
