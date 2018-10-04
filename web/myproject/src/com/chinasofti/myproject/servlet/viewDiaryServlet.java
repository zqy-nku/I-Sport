package com.chinasofti.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IMydiaryDao;
import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.impl.MydiaryDaoImpl;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.po.Mydiary;
import com.chinasofti.myproject.po.Person;

/**
 * Servlet implementation class viewDiaryServlet
 */
public class viewDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewDiaryServlet() {
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
		int mdiaryid=Integer.parseInt(request.getParameter("mdiaryid"));
		IMydiaryDao mydiaryDao=new MydiaryDaoImpl();
		Mydiary mydiary=mydiaryDao.selectMydiaryById(mdiaryid);
		request.setAttribute("mydiary", mydiary);
		// 步骤4：使用请求转发模式进行页面跳转
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/diarydetail.jsp");
	    dispatcher.forward(request, response);
		
		
		
	}

}
