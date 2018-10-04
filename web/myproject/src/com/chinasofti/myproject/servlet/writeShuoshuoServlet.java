package com.chinasofti.myproject.servlet;

import java.io.File;
import java.io.IOException;
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
		// TODO Auto-generated method stub
				request.setCharacterEncoding("UTF-8");
				int userid=Integer.parseInt(request.getParameter("userid"));
					
						String fileUploadPath = this.getServletContext().getRealPath("/upload/resources");
						System.out.println("[SingleFileUploadServlet] 锟斤拷锟矫凤拷锟斤拷锟斤拷锟斤拷锟杰客伙拷锟斤拷锟较达拷锟侥硷拷锟斤拷位锟斤拷锟角ｏ拷" + fileUploadPath);
					
						File fileUploadTempPath = new File(this.getServletContext().getRealPath("/tempDir"));
						if(!fileUploadTempPath.exists()){
							
							fileUploadTempPath.mkdir();
						}
						System.out.println("[SingleFileUploadServlet] 锟斤拷锟矫凤拷锟斤拷锟斤拷锟斤拷锟杰客伙拷锟斤拷锟较达拷锟侥硷拷锟斤拷锟斤拷时位锟斤拷锟角ｏ拷" + fileUploadTempPath.getPath());
						
					
						boolean isMultipart = ServletFileUpload.isMultipartContent(request);
						if(isMultipart){
							
							DiskFileItemFactory factory = new DiskFileItemFactory();
							
							factory.setRepository(fileUploadTempPath);
					
							factory.setSizeThreshold(4 * 1024);
							System.out.println("[SingleFileUploadServlet] 锟斤拷始锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟杰客伙拷锟斤拷锟较达拷锟侥硷拷锟斤拷锟斤拷时位锟斤拷锟斤拷希锟�");
							
							
							ServletFileUpload sfu = new ServletFileUpload(factory);			
							
							try {
							
								Publishstatus publishstatus= new Publishstatus();
								
								
								@SuppressWarnings("unchecked")
								List<FileItem> fileItems = sfu.parseRequest(request);
								for (FileItem fileItem : fileItems) {
									
									if(fileItem.isFormField()){
										
										String name = fileItem.getFieldName().trim();
										
										if("stacontext".equalsIgnoreCase(name)){
											String value = fileItem.getString();
											value = new String(value.getBytes("iso8859-1"),"UTF-8");
											publishstatus.setStacontext(value);
											System.out.println("测试-说说内容：> " + value);
										}	
									}else{
										String fileName = fileItem.getName().trim();
										String fileExtName = fileName.substring(fileName.lastIndexOf("."));
										fileName = generateUnqieName() + fileExtName;	
									    publishstatus.setStaresid(fileName);
										String[] allowedTypes = new String[]{".jpg", ".jpeg", ".png", ".bmp"};
										Arrays.sort(allowedTypes);
										int searchIndex = Arrays.binarySearch(allowedTypes, fileExtName);
										if(searchIndex < 0){
											System.out.println("[SingleFileUploadServlet] 锟斤拷锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷锟较达拷锟斤拷");
											return;
										}
										
										System.out.println("[SingleFileUploadServlet] 锟斤拷取锟较达拷锟侥硷拷锟斤拷锟斤拷锟轿� " + fileName);
										File saveFile = new File(fileUploadPath, fileName);
										fileItem.write(saveFile);
										System.out.println("[SingleFileUploadServlet] 锟较达拷锟侥硷拷锟缴癸拷锟斤拷");
									}
								}
								
								publishstatus.setStastatus(1);
							    publishstatus.setUserid(userid);
							    Date stapubtime=new Date();
							    publishstatus.setStapubtime(stapubtime);
								IPublishstatusBiz publishstatusBiz = new PublishstatusBizImpl();
								boolean flag=publishstatusBiz.writeshuoshuo(publishstatus);
								//
								if(flag){
									request.setAttribute("stacontext", publishstatus.getStacontext());
								     RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/main.jsp");
								}else
									System.out.println("发表说说失败");
								
								
								
							} catch (FileUploadException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else{
							System.out.println("锟酵伙拷锟剿�锟斤拷锟斤拷锟斤拷洗锟揭拷锟�");
						}
						response.sendRedirect("/myproject/jsp/main.jsp");
					}
					
					// 锟皆讹拷锟藉方锟斤拷锟斤拷锟斤拷洗锟斤拷募锟斤拷锟狡碉拷锟皆讹拷锟斤拷锟�
					private synchronized String generateUnqieName(){
						return String.valueOf(System.nanoTime());
					}
					
				

	}


