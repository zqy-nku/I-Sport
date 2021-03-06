package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

/**
 * Servlet implementation class ShowTreasureServlet
 */
public class ShowTreasureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowTreasureServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("111111");
		//找运动类型
		request.setCharacterEncoding("UTF-8");
		ISportBiz sportBiz = new SportBizImpl();
		ISporttreasureBiz sporttreasureBiz = new SporttreasureBizImpl();
		List<Sport> lstSport = sportBiz.findAllSport();
		request.setAttribute("lstSport", lstSport);
		System.out.println(lstSport);
		//结束
		//随机找tips
		IDailytipsBiz dailytipsBiz = new DailytipsBizImpl();
		Dailytips dailytips = dailytipsBiz.findByRand();
		request.setAttribute("dailytips", dailytips);
		System.out.println("dailytps="+dailytips);
		//加载tips结束
		//判断jsp页面是否有选择运动项目的选择
		List<Sporttreasure> lstSporttreasure = sporttreasureBiz.findAll();	
			 System.out.println("所有的treas:"+lstSporttreasure);
		request.setAttribute("lstSporttreasure", lstSporttreasure);
		// 姝ラ4锛氫娇鐢ㄨ姹傝浆鍙戞ā寮忚繘琛岄〉闈㈣烦杞�
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/treasure.jsp");
		dispatcher.forward(request, response);
	}

}
