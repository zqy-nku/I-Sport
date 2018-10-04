package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.ICoachBiz;
import com.chinasofti.myproject.biz.impl.CoachBizImpl;
import com.chinasofti.myproject.dao.ICoachcommentDao;
import com.chinasofti.myproject.dao.impl.CoachcommentDaoImpl;
import com.chinasofti.myproject.po.Coachcomment;

/**
 * Servlet implementation class commentCoach
 */
public class commentCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentCoachServlet() {
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
		int userid=Integer.parseInt(request.getParameter("userid"));
		String coacomcont=request.getParameter("coacomcont");
		int coacomstar=Integer.parseInt(request.getParameter("coacomstar"));
		Coachcomment coachcomment=new Coachcomment();
		coachcomment.setCoachid(coachid);
		coachcomment.setUserid(userid);
		coachcomment.setCoacomcont(coacomcont);
		coachcomment.setCoacomstar(coacomstar);
		coachcomment.setCoacomtime(new Date());
		ICoachBiz coachBiz=new CoachBizImpl();
		boolean flag=coachBiz.insertCoachComment(coachcomment);
		if(flag){
			response.sendRedirect("jsp/index.jsp");
		}else
		{
			response.sendRedirect("jsp/selectWrong.html");
		}
		
		
	}

}
