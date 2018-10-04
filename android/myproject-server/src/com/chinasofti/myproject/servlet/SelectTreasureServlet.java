package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.myproject.biz.IDailytipsBiz;
import com.chinasofti.myproject.biz.ISportBiz;
import com.chinasofti.myproject.biz.ISporttreasureBiz;
import com.chinasofti.myproject.biz.impl.DailytipsBizImpl;
import com.chinasofti.myproject.biz.impl.SportBizImpl;
import com.chinasofti.myproject.biz.impl.SporttreasureBizImpl;
import com.chinasofti.myproject.po.Dailytips;
import com.chinasofti.myproject.po.Sport;
import com.chinasofti.myproject.po.Sporttreasure;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SelectTreasureServlet
 */
@WebServlet("/SelectTreasureServlet")
public class SelectTreasureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTreasureServlet() {
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

		// 获取终端传入的JSon数据
		String strsportid = request.getParameter("sportid");
		// 反序列化形成一个int对象
		Gson gson = new GsonBuilder().create();
		int sportid = gson.fromJson(strsportid, int.class);
		// 根据sportid找相应内容
		ISporttreasureBiz sporttreasureBiz = new SporttreasureBizImpl();
		List<Sporttreasure> lstSporttreasure = sporttreasureBiz
				.findTreasBySportid(sportid);
		System.out.println("lst");

		// -------------------响应客户端 JSon----------------
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String lsttreas = gson.toJson(lstSporttreasure);
		
		System.out.println(lsttreas);
		out.println(lsttreas);

		out.flush();
		out.close();

	}

}
