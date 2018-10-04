package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class publishActivityServlet
 */
public class publishActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publishActivityServlet() {
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
		// 步骤1：设置字符编码集合
		request.setCharacterEncoding("UTF-8");
		// 步骤2：接受客户端传入的数据
		int userid = Integer.parseInt(request.getParameter("userid").trim());
		int sportid=Integer.parseInt(request.getParameter("sportid"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String time=request.getParameter("actibegtime");
		Date actibegtime=new Date();
		Date actiendtime=new Date();
		try {
			actibegtime=sdf.parse(time);
			System.out.println("开始时间："+actibegtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("转换错误");
		}
		time=request.getParameter("actiendtime");
		try {
			actiendtime=sdf.parse(time);
			System.out.println("结束时间："+actiendtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("转换错误");
		}
		String actiname=request.getParameter("actiname");
		String actiplace=request.getParameter("actiplace");
		String acticont=request.getParameter("acticont");
		Activityinvitation activityinvitation=new Activityinvitation();
		activityinvitation.setUserid(userid);
		activityinvitation.setSportid(sportid);
		activityinvitation.setActibegtime(actibegtime);
		activityinvitation.setActiendtime(actiendtime);
		activityinvitation.setActisettime(new Date());
		activityinvitation.setActiplace(actiplace);
		activityinvitation.setActiname(actiname);
		activityinvitation.setActicont(acticont);
		IActivityinvitationDao activityinvitationDao=new ActivityinvitationDaoImpl();
		int a=activityinvitationDao.insertActivityinvitation(activityinvitation);
		IUserBiz userBiz=new UserBizImpl();
		IUserDao userDao=new UserDaoImpl();
		boolean flag=userBiz.praise(userid,33);
		User user=userDao.selectUserById(userid);
		HttpSession session=request.getSession();
		session.setAttribute("user",user );
		if(flag){
		if (a>0) {
			response.sendRedirect("/myproject/jsp/activity.jsp");
		}else{
			if(a==0){
				response.sendRedirect("/myproject/jsp/activity.jsp");
			}
			else{
			response.sendRedirect("/myproject/jsp/selectWrong.html");}
		}
		}
	}

}
