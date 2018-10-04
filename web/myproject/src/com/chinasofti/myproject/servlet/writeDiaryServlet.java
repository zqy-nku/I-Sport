package com.chinasofti.myproject.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chinasofti.myproject.biz.IMydiaryBiz;
import com.chinasofti.myproject.biz.impl.MydiaryBizImpl;
import com.chinasofti.myproject.po.Mydiary;

/**
 * Servlet implementation class fileUpload
 */

public class writeDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public writeDiaryServlet() {
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
		request.setCharacterEncoding("UTF-8");
		int userid = Integer.parseInt(request.getParameter("userid"));
		// ����1�������ϴ��ļ��Ĳ���
		System.out.println("all here");
		// 1-1�����÷����������ϴ��ļ���λ�ã����������ļ��У�
		String fileUploadPath = this.getServletContext().getRealPath(
				"/upload/diary");
		System.out
				.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ���λ���ǣ�"
						+ fileUploadPath);
		// 1-2�����÷�������ʱ�������λ�ã���ʱ������ļ��У�
		File fileUploadTempPath = new File(this.getServletContext()
				.getRealPath("/tempDir"));
		if (!fileUploadTempPath.exists()) {
			// ����һ��ȫ�µ�
			fileUploadTempPath.mkdir();
		}
		System.out
				.println("[SingleFileUploadServlet] ���÷��������ܿͻ����ϴ��ļ�����ʱλ���ǣ�"
						+ fileUploadTempPath.getPath());

		// ����2���жϱ?�Ƿ����ϴ�Ҫ��
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// ����3�������ļ��ϴ����������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 3-1:������������������λ�õİ�
			factory.setRepository(fileUploadTempPath);
			// 3-2�����û��������Ĵ�С��4*1024 �ֽڣ�
			factory.setSizeThreshold(4 * 1024);
			System.out
					.println("[SingleFileUploadServlet] ��ʼ�����������ܿͻ����ϴ��ļ�����ʱλ����ϣ�");

			// ����4�������ͻ��˱?���ϴ������
			// 4-1:����һ��ServletFileUpload������ɶԶ����Ʊ?��ݵĽ�������ʵ�ַ������ϴ�����
			ServletFileUpload sfu = new ServletFileUpload(factory);

			try {
				// ����ر�ע���� ��ѭ������?���֮ǰ����ʵ�������
				Mydiary mydiary = new Mydiary();

				// 4-2:���������Ķ������ļ���װ��FileItem�Ķ�����
				@SuppressWarnings("unchecked")
				List<FileItem> fileItems = sfu.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					// ��չ3���жϵ�ǰ��������������Ƿ�Ϊ��ͨ�?���
					if (fileItem.isFormField()) {
						// ��ȡ�ͻ��˱?����Ԫ�ص�name���Ե�ֵ
						String name = fileItem.getFieldName().trim();
						// �ж����Ϊ�ĸ��ֶ����
						if ("mdiaryname".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							mydiary.setMdiaryname(value);
							System.out.println("����-��־���⣺> " + value);
						}
						if ("mdiarycont".equalsIgnoreCase(name)) {
							String value = fileItem.getString();
							value = new String(value.getBytes("iso8859-1"),
									"UTF-8");
							mydiary.setMdiarycont(value);
							System.out.println("����-��־���ݣ�> " + value);
						}
					} else {
						// 4-3:��ȡ�ϴ��ļ������
						String fileName = fileItem.getName().trim();
						// ��չ1��Ψһ����
						String fileExtName = fileName.substring(fileName
								.lastIndexOf("."));
						fileName = generateUnqieName() + fileExtName;
						// ����ر�ע���� �����λ��Ϊͷ�����Ը�ֵ
						mydiary.setMdiaryresid(fileName);
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

				// ���Է�װ����
				mydiary.setMdiarystatus(1);
				// mydiary.setMdiarytime(1992-09-27 12:29:11);
				mydiary.setUserid(userid);
				Date datetime = new Date();
				mydiary.setMdiarytime(datetime);
				// mydiary.setMdiarytime(1234);
				IMydiaryBiz mydiaryBiz = new MydiaryBizImpl();
				boolean flag = mydiaryBiz.writediary(mydiary);
				//
				if (flag) {
					request.setAttribute("mdiaryname", mydiary.getMdiaryname());
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("jsp/main.jsp");
				} else
					System.out.println("�ϴ���־ʧ�ܣ�");

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("�ͻ��˱?������ϴ�Ҫ��");
		}
		response.sendRedirect("/myproject/jsp/main.jsp");
	}

	// �Զ��巽������ϴ��ļ���Ƶ��Զ����
	private synchronized String generateUnqieName() {
		return String.valueOf(System.nanoTime());
	}

}
