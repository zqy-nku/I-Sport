package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IShowAllDiaryBiz;
import com.chinasofti.myproject.biz.impl.ShowAllDiaryBizImpl;
import com.chinasofti.myproject.dao.IMydiaryDao;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.impl.MydiaryDaoImpl;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.po.Mydiary;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.VDiary;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class viewDiaryServlet
 */
public class viewDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public viewDiaryServlet() {
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

		// IShowAllDiaryBiz showAllDiaryBiz = new ShowAllDiaryBizImpl();
		// List<VDiary> lstDiary = showAllDiaryBiz.show(userid);
		// System.out.println("lstDiary=" + lstDiary);
		// 步骤1：创建Gson对象
		String user_data = request.getParameter("user_data");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		int userid = gson.fromJson(user_data, int.class);

		
		 IShowAllDiaryBiz showAllDiaryBiz = new ShowAllDiaryBizImpl();
				 List<VDiary> lstDiary = showAllDiaryBiz.show(userid);
				 System.out.println("lstDiary=" + lstDiary);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String lstdiary = gson.toJson(lstDiary);
		out.print(lstdiary);

		out.flush();
		out.close();

	}

}
