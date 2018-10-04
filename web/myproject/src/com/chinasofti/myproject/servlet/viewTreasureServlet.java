package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.ISporttreasureDao;
import com.chinasofti.myproject.dao.impl.SporttreasureDaoImpl;
import com.chinasofti.myproject.po.Sporttreasure;

/**
 * Servlet implementation class viewTreasureServlet
 */
public class viewTreasureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTreasureServlet() {
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
		int treasid=Integer.parseInt(request.getParameter("treasid"));
		ISporttreasureDao sporttreasureDao=new SporttreasureDaoImpl();
		Sporttreasure sporttreasure=sporttreasureDao.selectById(treasid);
		request.setAttribute("sporttreasure", sporttreasure);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/treasuredetail.jsp");
	   dispatcher.forward(request, response);
		
	}

}
