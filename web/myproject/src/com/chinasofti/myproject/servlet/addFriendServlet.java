package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IFriendrelationDao;
import com.chinasofti.myproject.dao.impl.FriendrelationDaoImpl;
import com.chinasofti.myproject.po.Friendrelation;
import com.chinasofti.myproject.po.Person;

/**
 * Servlet implementation class addFriendServlet
 */
public class addFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFriendServlet() {
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
		//获得fid
		int fid=Integer.parseInt(request.getParameter("fid"));
		System.out.println("fid"+fid);
		IUserBiz userBiz=new UserBizImpl();
		Friendrelation friendrelation1=new Friendrelation();
		Friendrelation friendrelation2=new Friendrelation();
		//获得userid
		HttpSession session = request.getSession();
		Person person = (Person) session.getAttribute("person");
		int userid=person.getRegid();
		System.out.println("userid"+userid);
		//
		friendrelation1.setUserid(userid);
		friendrelation1.setFid(fid);
		friendrelation2.setUserid(fid);
		friendrelation2.setFid(userid);
		boolean flag1=userBiz.addFriend(friendrelation1);
		boolean flag2=userBiz.addFriend(friendrelation2);
		request.getSession().removeAttribute("lst");
		request.getSession().removeAttribute("lst");
		if (flag1&&flag2) {
			response.sendRedirect("jsp/main.jsp");
		} else {
            response.sendRedirect("jsp/selectwrong.html");
		}
		
	}

}
