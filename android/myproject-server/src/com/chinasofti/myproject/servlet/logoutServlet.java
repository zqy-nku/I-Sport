package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;


/**
 * Servlet implementation class logoutServlet
 */
public class logoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutServlet() {
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
		// 步骤1：通过session获取登录的账号
				HttpSession session = request.getSession();
				Person person = (Person) session.getAttribute("person");
				User user=(User) session.getAttribute("user");
				// 步骤2：销毁session
				session.removeAttribute("user");
				session.removeAttribute("person");
				session.invalidate();
				// 步骤3：从在线列表中移除当前登录账号
				List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
				usersOnLineList.remove(person.getAccount());  // 移除
				this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);  // 刷新在线列表
				// 步骤4：页面跳转
				response.sendRedirect("jsp/login.jsp");
				
	}

}
