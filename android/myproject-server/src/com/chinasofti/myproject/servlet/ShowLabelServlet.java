package com.chinasofti.myproject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chinasofti.myproject.biz.ISportBiz;
import com.chinasofti.myproject.biz.IUserBiz;
import com.chinasofti.myproject.biz.impl.SportBizImpl;
import com.chinasofti.myproject.biz.impl.UserBizImpl;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.Sport;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class ShowLabelServlet
 */
public class ShowLabelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLabelServlet() {
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
		
		HttpSession session = request.getSession();
		//IUserBiz userBiz = new UserBizImpl() ;
		
		Person person = new Person();
		System.out.println(person.toString());
		person = (Person)session.getAttribute("person");
		//鑾峰緱鎴戠殑鏍囩
		IUserBiz userBiz = new UserBizImpl();
		User user = userBiz.findByRegid(person.getRegid());
		String Label = user.getSportlabel();
		String[] labels = Label.split("/");
		//
		String[] mylabel = new String[labels.length];
		ISportBiz sportBiz = new SportBizImpl();
		for(int i=0; i<labels.length;i++){
			int label = Integer.parseInt(labels[i]);
			mylabel[i] = sportBiz.findNameById(label);
		}
		request.setAttribute("mylabel", mylabel);
		//鑾峰緱鎬荤殑鏍囩

		List<Sport> lstSport = sportBiz.findAllSport();
		request.setAttribute("lstSport", lstSport);
		
		// 姝ラ4锛氫娇鐢ㄨ姹傝浆鍙戞ā寮忚繘琛岄〉闈㈣烦杞�
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/changeinfo.jsp");
				dispatcher.forward(request, response);
	}

}
