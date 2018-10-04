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
 * Servlet implementation class reActiServlet
 */
public class reActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reActiServlet() {
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
		// -------------------处理数据-----------------------
		System.out.println("您要查看热门活动servlet");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		// -------------------处理数据-----------------------
				IActivityBiz activityBiz=new ActivityBizImpl();
				List<Actihuo> lstActi=activityBiz.HotActivity();
				System.out.println("输出热门活动"+lstActi.toString());
				//
				// -------------------响应客户端 JSon----------------
						response.setContentType("text/html; charset=UTF-8");
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						
						String gson_hotActi = gson.toJson(lstActi);
						
						System.out.println(gson_hotActi);
						out.println(gson_hotActi);
						
						out.flush();
						out.close();
	}

}
