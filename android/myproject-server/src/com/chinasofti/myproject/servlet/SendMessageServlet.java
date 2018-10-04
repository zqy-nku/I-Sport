package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class SendMessageServlet
 */
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
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
		request.setCharacterEncoding("UTF-8");
		//获得userid
		HttpSession session = request.getSession();
		Person person = (Person)session.getAttribute("person");
		IUserBiz userBiz = new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		System.out.println("user="+user);
		int userid = user.getUserid();
		//获得fid
		int fid = Integer.parseInt(request.getParameter("fid"));
		//获得需要发送的消息
		String text = request.getParameter("text");
		System.out.println("text="+text);
		Message message = new Message();
		message.setUserid(userid);
		message.setTouserid(fid);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = sdf.format(date);
		message.setMsgtime(strdate);
		message.setMsgcontext(text);
		message.setMsgstatus(0);
		//
		IMessageBiz messageBiz = new MessageBizImpl();
		boolean flag = messageBiz.addMessage(message);
		if(flag){
//			request.setAttribute("fid", fid);
			//页面跳转
			System.out.println("准备跳转");
			response.sendRedirect("/myproject/ShowMessageServlet?fid="+fid);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/myproject/ShowMessageServlet?fid=");
//			dispatcher.forward(request, response);
			System.out.println("跳转成功");
		}else{
			response.sendRedirect("jsp/error.jsp");
		}
	}

}
