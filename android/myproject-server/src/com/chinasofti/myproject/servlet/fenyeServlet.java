package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IPeruserDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.PeruserDaoImpl;

/**
 * Servlet implementation class fenyeServlet
 */
public class fenyeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fenyeServlet() {
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
		IUserBiz useBiz=new UserBizImpl();
		HttpSession session=request.getSession();
		Person person=(Person)session.getAttribute("person");
		List<Peruser> lst=new ArrayList<Peruser>();
		if(request.getParameter("action") ==null){
			System.out.println("enter if session.get");
	    lst=useBiz.tuiFriend(person.getRegid(), 0, 4);
	    session.setAttribute("page", 0);
	    request.getSession().setAttribute("lst", lst);
	    response.sendRedirect("/myproject/jsp/main.jsp");
		}else{
			System.out.println("enter else session.get");
			if (request.getParameter("action").equals("before")) {
				session.setAttribute("page", (int)(session.getAttribute("page"))-1);
				lst=useBiz.tuiFriend(person.getRegid(),(int)(session.getAttribute("page"))*4, 4);
			    request.getSession().setAttribute("lst", lst);
			    response.sendRedirect("jsp/main.jsp");
			} else {
				
				 session.setAttribute("page", (int)(session.getAttribute("page"))+1);
				 lst=useBiz.tuiFriend(person.getRegid(),(int)(session.getAttribute("page"))*4, 4);
				 request.getSession().setAttribute("lst", lst);
				 response.sendRedirect("jsp/main.jsp");
			}
		}
		
		System.out.println(lst.toString());
	}

}
