package com.chinasofti.myproject.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.myproject.dao.IPersonDao;
import com.chinasofti.myproject.dao.IUserDao;
import com.chinasofti.myproject.dao.impl.PersonDaoImpl;
import com.chinasofti.myproject.dao.impl.UserDaoImpl;
import com.chinasofti.myproject.po.Mydiary;
import com.chinasofti.myproject.po.Person;
import com.chinasofti.myproject.po.User;

/**
 * Servlet implementation class changeUserinfoServlet
 */
public class changeUserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeUserinfoServlet() {
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
		int userid=Integer.parseInt(request.getParameter("id"));
		String fileUploadPath = this.getServletContext().getRealPath("/upload/photo");
		System.out.println("[SingleFileUploadServlet] "+ fileUploadPath);
		// 1-2缓存地址
		File fileUploadTempPath = new File(this.getServletContext().getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			fileUploadTempPath.mkdir();
		}
		System.out.println("[SingleFileUploadServlet]"	+ fileUploadTempPath.getPath());
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:������������������λ�õİ�
			factory.setRepository(fileUploadTempPath);
			// 3-2�����û��������Ĵ�С��4*1024 �ֽڣ�
			factory.setSizeThreshold(4 * 1024);
			ServletFileUpload sfu = new ServletFileUpload(factory);

		
			try {
				Person person=new Person();
				User user=new User();
					// 4-2:���������Ķ������ļ���װ��FileItem�Ķ�����
					@SuppressWarnings("unchecked")
					List<FileItem> fileItems = sfu.parseRequest(request);
					for (FileItem fileItem : fileItems) {
						
						if (fileItem.isFormField()) {
							// ��ȡ�ͻ��˱?����Ԫ�ص�name���Ե�ֵ
							String name = fileItem.getFieldName().trim();
							// �ж����Ϊ�ĸ��ֶ����
							if ("nickname".equalsIgnoreCase(name)) {
								String value = fileItem.getString();
								value = new String(value.getBytes("iso8859-1"),
										"UTF-8");
								person.setNickname(value);
								System.out.println("昵称 " + value);
							}
							if ("reggender".equalsIgnoreCase(name)) {
								String value = fileItem.getString();
								value = new String(value.getBytes("iso8859-1"),
										"UTF-8");
								person.setReggender(value);
								System.out.println("性别 " + value);
							}
							if ("regaddr".equalsIgnoreCase(name)) {
								String value = fileItem.getString();
								value = new String(value.getBytes("iso8859-1"),
										"UTF-8");
								person.setRegaddr(value);
								System.out.println("地址 " + value);
							}
							if ("mark".equalsIgnoreCase(name)) {
								String value = fileItem.getString();
								value = new String(value.getBytes("iso8859-1"),
										"UTF-8");
								user.setMark(value);
								System.out.println("主页介绍 " + value);
								
							}
							if ("spordec".equalsIgnoreCase(name)) {
								String value = fileItem.getString();
								value = new String(value.getBytes("iso8859-1"),
										"UTF-8");
								user.setSpordec(value);
								System.out.println("运动宣言 " + value);
								
							}
						} else {
							// 4-3:��ȡ�ϴ��ļ������
							String fileName = fileItem.getName().trim();
							// ��չ1��Ψһ����
							String fileExtName = fileName.substring(fileName
									.lastIndexOf("."));
							fileName = generateUnqieName() + fileExtName;
							// ����ر�ע���� �����λ��Ϊͷ�����Ը�ֵ
						    user.setUserpho(fileName);
							// ��չ2�������ϴ��ļ�����
							String[] allowedTypes = new String[] { ".jpg", ".jpeg",
									".png", ".bmp" };
							Arrays.sort(allowedTypes);
							int searchIndex = Arrays.binarySearch(allowedTypes,
									fileExtName);
							if (searchIndex < 0) {
								System.out
										.println("[SingleFileUploadServlet] �������ļ��������ϴ���");
								return;
							}

							System.out
									.println("[SingleFileUploadServlet] ��ȡ�ϴ��ļ������Ϊ: "
											+ fileName);
							// 4-4:��װ�ϴ��ļ�����д�뵽������
							File saveFile = new File(fileUploadPath, fileName);
							fileItem.write(saveFile);
							System.out
									.println("[SingleFileUploadServlet] �ϴ��ļ��ɹ���");
						}
					}
					
					//封装对象
					IPersonDao personDao=new PersonDaoImpl();
					IUserDao userDao=new UserDaoImpl();
					person.setRegid(userid);
					user.setUserid(userid);
					Person person1=personDao.selectPersonById(userid);
					User user1=userDao.selectUserById(userid);
					person.setAccount(person1.getAccount());
					person.setPassword(person1.getPassword());
					person.setRegtime(person1.getRegtime());
					user.setCollestatusid(user1.getCollestatusid());
					user.setColletreasid(user1.getColletreasid());
					user.setInteg(user.getInteg());
					user.setIsaccepmsg(user1.getIsaccepmsg());
					user.setMark(user1.getMark());
					user.setRank(user1.getRank());
					user.setSpornum(user1.getSpornum());
					user.setSportlabel(user1.getSportlabel());
					user.setUserstatus(user1.getUserstatus());
					user.setRegid(userid);
					user.setUserid(userid);
					int flag1=personDao.updatePerson(person);
					int flag2=userDao.updateUser(user);
					if((flag1>0)&&(flag2>0)){
						HttpSession session = request.getSession();
						session.setAttribute("person", person);
						session.setAttribute("user", user);
						response.sendRedirect("jsp/main.jsp");
					}
					else{
						response.sendRedirect("jsp/selectWrong.html");
					}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	
		
		
		
		
	}
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
	}
}
