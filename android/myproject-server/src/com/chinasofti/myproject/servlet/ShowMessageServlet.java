package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IMessageBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.MessageBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Message;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class ShowMessageServlet
 */
public class ShowMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得userid
		System.out.println("开始showmessage了。。。。");
		HttpSession session = request.getSession();
		Person person = (Person)session.getAttribute("person");
		System.out.println("person="+person);
		IUserBiz userBiz = new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		System.out.println("User="+user);
		int userid = user.getUserid();
		//获得fid
		int fid = Integer.parseInt(request.getParameter("fid"));
		System.out.println("fid="+fid);
		//查询消息
		IMessageBiz messageBiz = new MessageBizImpl();
		List<Message> lstMessage = messageBiz.findByUserFridid(userid, fid);
		//
		request.setAttribute("fid", fid);
		request.setAttribute("lstMessage", lstMessage);
		//页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/chat1.jsp");
		dispatcher.forward(request, response);
		
	}

}
