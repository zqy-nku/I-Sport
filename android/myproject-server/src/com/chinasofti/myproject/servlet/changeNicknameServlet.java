package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class changeNicknameServlet
 */
public class changeNicknameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeNicknameServlet() {
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
		String nickname_data = request.getParameter("nickname_data");
		String user1_data=request.getParameter("user1_data");
		// 反序列化形成一个Users对象
	    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
	    String nickname=gson.fromJson(nickname_data,String.class);
	    int userid=gson.fromJson(user1_data, int.class);
	    IUserDao userDao=new UserDaoImpl();
	    User user=userDao.selectUserById(userid);
	    IPersonDao personDao=new PersonDaoImpl();
	    Person person=personDao.selectPersonById(userid);
	    person.setNickname(nickname);
	    int flag=personDao.updatePerson(person);
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
