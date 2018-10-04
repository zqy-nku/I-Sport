package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class inOtherSpaceServlet
 */
public class inOtherSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inOtherSpaceServlet() {
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
		int userid=Integer.parseInt(request.getParameter("uid"));
		System.out.println(userid);
		IUserDao userDao=new UserDaoImpl();
		User user=userDao.selectUserById(userid);
		IPersonDao personDao=new PersonDaoImpl();
		Person person=personDao.selectPersonById(userid);
		request.setAttribute("user",user);
		request.setAttribute("person", person);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/othermain.jsp");
		dispatcher.forward(request, response);
	}

}
