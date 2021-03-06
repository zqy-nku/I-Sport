package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IActivityBiz;
import com.chinasofti.myproject.biz.impl.ActivityBizImpl;
import com.chinasofti.myproject.po.Actihuo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class JoinedActiServlet
 */
public class JoinedActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinedActiServlet() {
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
		// 获取终端传入的JSon数据
		String user_data = request.getParameter("user_data");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
	   int userid=gson.fromJson(user_data, Integer.class);
	  System.out.println("我参与的活动，在servlet中接收到的userid:"+userid);
				
		// -------------------处理数据-----------------------
		IActivityBiz activityBiz=new ActivityBizImpl();
		List<Actihuo> lstActi=activityBiz.JoinedActivity(userid);
		//
		// -------------------响应客户端 JSon----------------
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				String gson_joinedActi = gson.toJson(lstActi);
				
				System.out.println(gson_joinedActi);
				out.println(gson_joinedActi);
				
				out.flush();
				out.close();
	}

}
