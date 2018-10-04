package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Mydiary;
import com.chinasofti.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class changeDeclarationServlet
 */
public class changeDeclarationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeDeclarationServlet() {
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
		//--------------------接受数据JSon-----------------
				// 获取终端传入的JSon数据
		String declar_data=request.getParameter("declar_data");
		String user_data=request.getParameter("user_data");
		// 反序列化形成一个Users对象
	    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
	    String decla=gson.fromJson(declar_data, String.class);
	    int userid=gson.fromJson(user_data, Integer.class);
	    IUserDao userDao=new UserDaoImpl();
	    User user=userDao.selectUserById(userid);
	    user.setSpordec(decla);
	    int flag=userDao.updateUser(user);
	    boolean istrue=flag>0?true:false;
	    
	    
	 // -------------------响应客户端 JSon----------------
	 		response.setContentType("text/html; charset=UTF-8");
	 		response.setCharacterEncoding("UTF-8");
	 		PrintWriter out = response.getWriter();
	 		
	 		String gson_data=gson.toJson(istrue);
			System.out.println(gson_data);
			out.println(gson_data);
			
			out.flush();
			out.close();
	}

}
