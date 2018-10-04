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
 * Servlet implementation class viewCoachDetailServlet
 */
public class viewCoachDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewCoachDetailServlet() {
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
		int coachid=Integer.parseInt(request.getParameter("coachid"));
		int sportid=Integer.parseInt(request.getParameter("sportid"));
		System.out.println(coachid);
		ICoachBiz coachBiz=new CoachBizImpl();
		Coach coach=coachBiz.selectById(coachid);
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
