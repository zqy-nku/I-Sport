package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.ICoachBiz;
import com.chinasofti.myproject.biz.impl.CoachBizImpl;
import com.chinasofti.myproject.po.Coach;

/**
 * Servlet implementation class showCoachListServlet
 */
public class showCoachListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showCoachListServlet() {
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
		int sportid=Integer.parseInt(request.getParameter("sportid"));
		ICoachBiz coachBiz=new CoachBizImpl();
		List<Coach> lstCoach = new ArrayList<Coach>();
		lstCoach=coachBiz.selectBySportid(sportid);
		if (lstCoach==null) {
			response.sendRedirect("jsp/selectWrong.html");
		}else{
		request.setAttribute("sportid", sportid);
		request.setAttribute("lstCoach", lstCoach);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/coachlist.jsp");
		dispatcher.forward(request, response);
		}
		
	}

}
