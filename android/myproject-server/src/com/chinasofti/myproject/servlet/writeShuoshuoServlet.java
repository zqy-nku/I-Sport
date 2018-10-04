package com.chinasofti.myproject.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.myproject.biz.IPublishstatusBiz;
import com.chinasofti.myproject.biz.impl.PublishstatusBizImpl;
import com.chinasofti.myproject.po.Publishstatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * Servlet implementation class writeShuoshuoServlet
 */
public class writeShuoshuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeShuoshuoServlet() {
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
		String shuoshuo_data=request.getParameter("shuoshuo_data");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
		Publishstatus shuoshuo =gson.fromJson(shuoshuo_data, Publishstatus.class);
		
		// -------------------处理数据-----------------------
		IPublishstatusBiz shuoshuoBiz=new PublishstatusBizImpl();
		boolean writeshuoshuo=shuoshuoBiz.writeshuoshuo(shuoshuo);
		// -------------------响应客户端 JSon----------------
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				String gson_data=gson.toJson(writeshuoshuo);
		       
				System.out.println(gson_data);
				out.println(gson_data);
				
				out.flush();
				out.close();
		
		
	 }
	}


