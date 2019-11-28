package com.jswl.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jswl.travel.service.UserService;


@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1   ��ȡ������
		String code = request.getParameter("code");
		if(code!=null) {
			
			UserService userService = new UserService();
			Boolean flag = userService.activeByCode(code);
			
			// ����һ���������ֵı���
			String msg =null;
			if (flag) {
				//����ɹ�
				msg="����ɹ� <a href='login.html'>��½</a>";
			}else {
				// ����ʧ��
				msg ="����ʧ�ܣ� ����ϵ����Ա";
			}
            response.setContentType("text/html;charset=utf-8");
			
             response.getWriter().write(msg);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
