package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IVenueBiz;
import com.chinasofti.myproject.biz.impl.VenueBizImpl;
import com.chinasofti.myproject.po.Venuecomment;

/**
 * Servlet implementation class commentVenueServlet
 */
public class commentVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentVenueServlet() {
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
		int userid=Integer.parseInt(request.getParameter("userid"));
		String vencomcont=request.getParameter("vencomcont");
		int vencomstar=Integer.parseInt(request.getParameter("vencomstar"));
		Venuecomment venuecomment=new Venuecomment();
		venuecomment.setVenueid(venueid);
		venuecomment.setUserid(userid);
		venuecomment.setVencomcont(vencomcont);
		venuecomment.setVencomstar(vencomstar);
		venuecomment.setVencomtime(new Date());
		IVenueBiz venueBiz =new VenueBizImpl();
		boolean flag=venueBiz.InsertVenueComment(venuecomment);
		if (flag) {
			response.sendRedirect("jsp/index.jsp");
		} else {
			response.sendRedirect("jsp/selectWrong.html");
		}
		
	}

}
