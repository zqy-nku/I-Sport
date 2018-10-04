package com.chinasofti.myproject.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.ICoachBiz;
import com.chinasofti.myproject.biz.impl.CoachBizImpl;
import com.chinasofti.myproject.po.Coach;

/**
 * Servlet implementation class searchCoachServlet
 */
public class searchCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCoachServlet() {
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
		String coaname=request.getParameter("coachname1");
		int sportid=Integer.parseInt(request.getParameter("sportid"));
		Coach coach=new Coach();
		ICoachBiz coachBiz=new CoachBizImpl();
		coach=coachBiz.selectByName(coaname);
		if (coach==null) {
			response.sendRedirect("jsp/selectWrong.html");
		}else{
		request.setAttribute("sportid", sportid);
		request.setAttribute("coach", coach);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/coach.jsp");
	    dispatcher.forward(request, response);
		}
		
	}
}

