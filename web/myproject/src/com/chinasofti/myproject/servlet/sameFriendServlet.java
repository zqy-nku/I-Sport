package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Peruser;

/**
 * Servlet implementation class sameFriendServlet
 */
public class sameFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sameFriendServlet() {
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
		int fid=Integer.parseInt(request.getParameter("fid"));
		List<Peruser> list2=new ArrayList<Peruser>();
		if(request.getParameter("action") ==null){
			System.out.println("enter if session.get");
	    list2=useBiz.sameFriend(person.getRegid(),fid, 0, 4);
	    session.setAttribute("page", 0);
	    request.getSession().setAttribute("list2", list2);
	    response.sendRedirect("jsp/myspace/othermain.jsp");
		}else{
			System.out.println("enter else session.get");
			if (request.getParameter("action").equals("before")) {
				session.setAttribute("page", (int)(session.getAttribute("page"))-1);
				list2=useBiz.sameFriend(person.getRegid(),fid,(int)(session.getAttribute("page"))*4, 4);
			    request.getSession().setAttribute("list2", list2);
				response.sendRedirect("jsp/myspace/othermain.jsp");
			} else {
				
				 session.setAttribute("page", (int)(session.getAttribute("page"))+1);
				 list2=useBiz.sameFriend(person.getRegid(),fid,(int)(session.getAttribute("page"))*4, 4);
				 request.getSession().setAttribute("list2", list2);
				 response.sendRedirect("jsp/myspace/othermain.jsp");
			}
		}
		
		System.out.println(list2.toString());
	}
	}


