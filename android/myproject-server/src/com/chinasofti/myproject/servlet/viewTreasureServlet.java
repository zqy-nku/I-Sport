package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.ISporttreasureDao;
import com.chinasofti.myproject.dao.impl.SporttreasureDaoImpl;
import com.chinasofti.myproject.po.Sporttreasure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class viewTreasureServlet
 */
public class viewTreasureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTreasureServlet() {
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
		String user_data = request.getParameter("user_data");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss")
				.create();
		int userid = gson.fromJson(user_data, int.class);
		
		IUserBiz showTreasure = new UserBizImpl();
		List<Sporttreasure> lstTreasure=showTreasure.showMyCollect(userid);
		System.out.println("lstTreasure="+lstTreasure);
		

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		PrintWriter out = response.getWriter();
		String lsttreasure=gson.toJson(lstTreasure);
		out.print(lsttreasure);
	}

}
