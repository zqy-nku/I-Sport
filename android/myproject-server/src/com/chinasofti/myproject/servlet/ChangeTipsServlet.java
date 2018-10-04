package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IDailytipsBiz;
import com.chinasofti.myproject.biz.impl.DailytipsBizImpl;
import com.chinasofti.myproject.po.Dailytips;

/**
 * Servlet implementation class ChangeTipsServlet
 */
@WebServlet("/ChangeTipsServlet")
public class ChangeTipsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeTipsServlet() {
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
		//随机找tips
				IDailytipsBiz dailytipsBiz = new DailytipsBizImpl();
				Dailytips dailytips = dailytipsBiz.findByRand();
				String tipscontext = dailytips.getTipcontext();
				System.out.println(dailytips);
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.println(tipscontext);
				out.flush();
				out.close();
	}

}
