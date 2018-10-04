package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.ISporttreasureBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.SporttreasureBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Sporttreasure;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class AddColleServlet
 */

public class AddColleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColleServlet() {
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
		//取得用户的收藏
		HttpSession session = request.getSession();
		Person person = (Person)session.getAttribute("person");
		IUserBiz userBiz =new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		String colle = user.getColletreasid();
		//更新用户数据库
		String addcolle = request.getParameter("colleid");
		int Addcolle = Integer.parseInt(addcolle);
		colle = colle + addcolle +"/";
		user.setColletreasid(colle);
		userBiz.updateUser(user);
		//更新宝典数据库
		ISporttreasureBiz treasureBiz = new SporttreasureBizImpl();
		Sporttreasure treasure = treasureBiz.findSportByTreasId(Addcolle);
		treasure.setTreascollecount(treasure.getTreascollecount()+1);
		treasureBiz.updateTreas(treasure);
		//输出流
		int count = treasure.getTreascollecount();
		PrintWriter out = response.getWriter();
		out.println(count);
		out.flush();
		out.close();
	}

}
