package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IPersonBiz;
import com.chinasofti.myproject.biz.impl.PersonBizImpl;
import com.chinasofti.myproject.po.Person;

/**
 * Servlet implementation class ModifyPswServlet
 */
public class ModifyPswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPswServlet() {
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
		// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				String newpassword = request.getParameter("newpassword");
				System.out.println(newpassword);
				HttpSession session = request.getSession();
				Person person = (Person)session.getAttribute("person");
				person.setPassword(newpassword);
				System.out.println(person.toString());
				//
				IPersonBiz personBiz =new PersonBizImpl();
				int flag = personBiz.updatePerson(person)==true?1:-1;
				System.out.println(flag);
				if(flag ==1) {
					session.setAttribute("person", person);
				}
				request.setAttribute("flag", flag);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("jsp/changeinfo.jsp");
				dispatcher.forward(request, response);
	}

}
