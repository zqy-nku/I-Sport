package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IPersonBiz;
import com.chinasofti.myproject.biz.impl.PersonBizImpl;
import com.chinasofti.myproject.po.Person;

/**
 * Servlet implementation class CheckaccountServlet
 */
public class CheckaccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckaccountServlet() {
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
		String account = request.getParameter("email");
		IPersonBiz personBiz = new PersonBizImpl();
		int flag = personBiz.findByAccount(account)!=null ? 1:0;
		System.out.println(flag);
		PrintWriter out = response.getWriter();
		out.println(flag);
		out.flush();
		out.close();
	}

}
