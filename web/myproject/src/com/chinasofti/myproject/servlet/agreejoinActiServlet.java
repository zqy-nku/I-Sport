package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class agreejoinActiServlet
 */
public class agreejoinActiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agreejoinActiServlet() {
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
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int actiid=Integer.parseInt(request.getParameter("actiid"));
		int userid=user.getUserid();
		System.out.println("活动编号"+actiid);
		String acti1=user.getActiid();
		if(acti1==null){
			acti1=actiid+"/";
		}else{
			acti1=acti1+actiid+"/";	}
		user.setActiid(acti1);
		IUserBiz userBiz=new UserBizImpl();
		IUserDao userDao=new UserDaoImpl();
		user.setInteg(user.getInteg()+22);
		if(user.getInteg()>100){
			user.setInteg(user.getInteg()-100);
			user.setRank(user.getRank()+1);
		}
		int flag2=userDao.updateUser(user);
		
		IActivityinvitationDao actiDao=new ActivityinvitationDaoImpl();
		Activityinvitation acti=actiDao.selectActivityinvitationById(actiid);
		String actiuserid=acti.getActiuserid();
		acti.setActiusercount(acti.getActiusercount()+1);
		 actiuserid=acti.getActiuserid();
	
		if(actiuserid==null){
			actiuserid=userid+"/";
		}else{
			actiuserid=actiuserid+userid+"/";
		}
		acti.setActiuserid(actiuserid);
		System.out.println(actiuserid);
		int flag=actiDao.updateActivityinvitation(acti);
		

		if ((flag>0)&&(flag2>0)) {
		session.setAttribute("user", user);
		System.out.println("已更新参加活动的user"+user.toString());
		response.sendRedirect("jsp/activity.jsp");
		}else{
		response.sendRedirect("jsp/selectWrong.html");
		}
		
	}

}
