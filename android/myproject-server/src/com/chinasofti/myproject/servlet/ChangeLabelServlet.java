package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class ChangeLabelServlet
 */
public class ChangeLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLabelServlet() {
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
		String label = request.getParameter("data");
		HttpSession session = request.getSession();
		Person person = new Person();
		person = (Person)session.getAttribute("person");
		//
		IUserBiz userBiz =new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		user.setSportlabel(label);
		userBiz.updateUser(user);
		//
		response.sendRedirect("jsp/changeinfo.jsp");
	}

}
