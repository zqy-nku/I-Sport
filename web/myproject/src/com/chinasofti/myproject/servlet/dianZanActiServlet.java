package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;

/**
 * Servlet implementation class dianZanActiServlet
 */
public class dianZanActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dianZanActiServlet() {
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
		System.out.println("all here");
		int actiid=Integer.parseInt(request.getParameter("actiid"));
		IActivityinvitationDao actiDao=new ActivityinvitationDaoImpl();
		Activityinvitation acti=actiDao.selectActivityinvitationById(actiid);
		int count=acti.getActidianzan()+1;
		acti.setActidianzan(count);
		int flag=actiDao.updateActivityinvitation(acti);
		if (flag>0) {
		response.sendRedirect("jsp/activity.jsp");
		}else{
		response.sendRedirect("jsp/selectWrong.html");
		}
	}

}
