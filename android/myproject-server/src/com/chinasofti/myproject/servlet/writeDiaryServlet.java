package com.chinasofti.myproject.servlet;


import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chinasofti.myproject.biz.IMydiaryBiz;
import com.chinasofti.myproject.biz.impl.MydiaryBizImpl;
import com.chinasofti.myproject.po.Mydiary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class fileUpload
 */

public class writeDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public writeDiaryServlet() {
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
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		//--------------------接受数据JSon-----------------
				// 获取终端传入的JSon数据
		String diary_data=request.getParameter("diary_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Mydiary mydiary=gson.fromJson(diary_data, Mydiary.class);

		// -------------------处理数据-----------------------
		
		IMydiaryBiz mydiaryBiz = new MydiaryBizImpl();
		boolean writediary=mydiaryBiz.writediary(mydiary);
		
		
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data=gson.toJson(writediary);
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
		
		
		
		
	}

}
