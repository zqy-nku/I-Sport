package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chinasofti.myproject.biz.IVenueBiz;
import com.chinasofti.myproject.biz.impl.VenueBizImpl;
import com.chinasofti.myproject.po.Venue;

/**
 * Servlet implementation class viewVenueDetailServlet
 */
public class viewVenueDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewVenueDetailServlet() {
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
		int venueid=Integer.parseInt(request.getParameter("venueid"));
		int sportid=Integer.parseInt(request.getParameter("sportid"));
		System.out.println(venueid);
		IVenueBiz venueBiz=new VenueBizImpl();
		Venue venue=venueBiz.selectById(venueid);
		if (venue==null) {
			response.sendRedirect("jsp/selectWrong.html");
		}else{
		request.setAttribute("sportid", sportid);
		request.setAttribute("venue", venue);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/venue.jsp");
	    dispatcher.forward(request, response);
		}
	}

}
