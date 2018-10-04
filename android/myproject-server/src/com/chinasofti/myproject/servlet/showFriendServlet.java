package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class showFriendServlet
 */
public class showFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showFriendServlet() {
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
		//找出我的好友
		IUserBiz userBiz=new UserBizImpl();
		HttpSession session=request.getSession();
		Person person=(Person)session.getAttribute("person");
		User user = userBiz.findByRegid(person.getRegid());
		List<Peruser> lstmyfri = userBiz.findMyfriend(user.getUserid()) ;
		System.out.println("好友们："+lstmyfri);
		//找出推荐好友
		List<Peruser> lstrecomfri = userBiz.recomFriend(user.getUserid());
		//
		System.out.println("推荐好友们："+lstrecomfri);
		request.setAttribute("lstmyfri", lstmyfri);
		request.setAttribute("lstrecomfri", lstrecomfri);
		//跳转过标记
		String Havedone = "havedone";
		request.setAttribute("Havedone", Havedone);
		//页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/main.jsp");
		dispatcher.forward(request, response);
//		if(request.getParameter("action") ==null){
//			System.out.println("enter if session.get");
//	    list=useBiz.allFriend(person.getRegid(), 0, 4);
//	    session.setAttribute("page", 0);
//	    request.getSession().setAttribute("list", list);
//	    response.sendRedirect("jsp/main.jsp");
//		}else{
//			System.out.println("enter else session.get");
//			if (request.getParameter("action").equals("before")) {
//				session.setAttribute("page", (int)(session.getAttribute("page"))-1);
//				list=useBiz.allFriend(person.getRegid(),(int)(session.getAttribute("page"))*4, 4);
//			    request.getSession().setAttribute("list", list);
//				response.sendRedirect("jsp/main.jsp");
//			} else {
//				
//				 session.setAttribute("page", (int)(session.getAttribute("page"))+1);
//				 list=useBiz.allFriend(person.getRegid(),(int)(session.getAttribute("page"))*4, 4);
//				 request.getSession().setAttribute("list", list);
//				 response.sendRedirect("jsp/main.jsp");
//			}
//		}
		

	}

	}


