package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IActivityinvitationDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.ActivityinvitationDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Activityinvitation;
import com.chinasofti.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class joinServlet
 */
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinServlet() {
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
		
		//--------------------接受数据JSon-----------------
		// 获取终端传入的JSon数据
		String user_data = request.getParameter("user_data");
		String acti_data=request.getParameter("acti_data");
		// 反序列化形成一个Users对象
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		int userid = gson.fromJson(user_data, Integer.class);
		int actiid=gson.fromJson(acti_data, Integer.class);
		
		// -------------------处理数据-----------------------
		IUserDao userDao=new UserDaoImpl();
		User user = userDao.selectUserById(userid);
		String acti1=user.getActiid();
		if(acti1==null){
			acti1=actiid+"/";
		}else{
			acti1=acti1+actiid+"/";	}
		user.setActiid(acti1);
		int flag1=userDao.updateUser(user);
		IActivityinvitationDao activityinvitationDao=new ActivityinvitationDaoImpl();
		Activityinvitation activityinvitation=activityinvitationDao.selectActivityinvitationById(actiid);
		activityinvitation.setActiusercount(activityinvitation.getActiusercount()+1);
		int flag2=activityinvitationDao.updateActivityinvitation(activityinvitation);
		boolean flag=false;
		if ((flag1>0)&&(flag2>0)) {
			flag=true;
		} else {
           flag=false;
		}
		
		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String gson_data = gson.toJson(flag);
		
		System.out.println(gson_data);
		out.println(gson_data);
		
		out.flush();
		out.close();
	}

}
