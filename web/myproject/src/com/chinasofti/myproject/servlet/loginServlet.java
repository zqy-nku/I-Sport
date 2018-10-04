package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.ILoginBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.LoginBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;


/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		// 获取客户端传入的数据
		String account = request.getParameter("account").trim();
		String password = request.getParameter("password").trim();
		
		// 单点登录验证
		// 获取全局Application级别的用户在线列表
		List<String> usersOnLineList = (List<String>) this.getServletContext().getAttribute("usersOnLineList");
		if(usersOnLineList == null){
			usersOnLineList = new ArrayList<String>();
		}
		// 判断当前登录用户是否存在于该在线列表中
		boolean singleLoginFlag;
		if(usersOnLineList.contains(account)){
			singleLoginFlag = true;
		}else{
			singleLoginFlag = false;			
		}
		
		if(!singleLoginFlag){
			// 调用Biz层实现数据库验证
			ILoginBiz loginBiz = new LoginBizImpl();
			Person person= loginBiz.isLogin(account, password);
			// 响应客户端		
			int msgcode = person == null ? 101 : 102;
			String url = "";
			switch (msgcode) {
			case 101:
				url = "jsp/login.jsp";
				request.setAttribute("msgcode", msgcode);
				break;
			case 102:
				url = "jsp/index.jsp";
				HttpSession session = request.getSession(); // 获取session对象
				// 将登录的用户添加到在线列表中
				usersOnLineList.add(person.getAccount());
				// 刷新在线用户列表
				this.getServletContext().setAttribute("usersOnLineList", usersOnLineList);
				session.setAttribute("person", person);
				IUserDao userDao=new UserDaoImpl();
				User user=userDao.selectUserById(person.getRegid());
				session.setAttribute("user", user);
				break;
			default:
				break;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			int msgcode = 103;
			request.setAttribute("msgcode", msgcode);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
		

	}


}
