package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IActivityBiz;
import com.chinasofti.myproject.biz.impl.ActivityBizImpl;
import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.po.Actihuo;
import com.chinasofti.myproject.po.Activityinvitation;

/**
 * Servlet implementation class showActiByAnameServlet
 */
public class showActiByAnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showActiByAnameServlet() {
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
		String actiname=request.getParameter("actiname");
		IActivityBiz activityBiz=new ActivityBizImpl();
		List<Actihuo> lstacti=activityBiz.searchActiByAname(actiname);
		request.setAttribute("lstacti", lstacti);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showactivity.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
