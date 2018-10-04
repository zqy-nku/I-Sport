package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class canceljoinActiServlet
 */
public class canceljoinActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public canceljoinActiServlet() {
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
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int userid=user.getUserid();
		IActivityinvitationDao actiDao=new ActivityinvitationDaoImpl();
		Activityinvitation acti=actiDao.selectActivityinvitationById(actiid);
		int count=acti.getActiusercount()-1;
		acti.setActiusercount(count);
		String actiuserid=acti.getActiuserid();
		actiuserid.replace(String.valueOf(userid)+"/", "");
		acti.setActiuserid(actiuserid);
		System.out.println(actiuserid);
		int flag=actiDao.updateActivityinvitation(acti);
		
		
		String joinid=user.getActiid();
		joinid.replace(String.valueOf(actiid)+"/", "");
		user.setActiid(joinid);
		IUserDao userDao=new UserDaoImpl();
		int flag1=userDao.updateUser(user);
		if(flag1>0){
		if (flag>0) {
		session.setAttribute("user", user);
		response.sendRedirect("jsp/activity.jsp");
		}else{
		response.sendRedirect("jsp/selectWrong.html");
		}}
	}

}
