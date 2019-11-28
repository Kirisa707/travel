package com.jswl.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.pojo.User;
import com.jswl.travel.service.UserService;


@WebServlet("/checkUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName = request.getParameter("userName");
		String password =request.getParameter("password");
		String code    = request.getParameter("code");
		// ����service
		 User checkUser = us.checkUser(userName, password);
		 // 2 ���û��ŵ�session����
		 request.getSession().setAttribute("chek", checkUser);
		// ��ȡ��֤��
		String  coString = (String)request.getSession().getAttribute("sms");
		ResultInfo info  = new ResultInfo();
		ObjectMapper objectMapper  = new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		// �ж�checkUser�Ƿ����
		if(checkUser!=null && coString.equals(code)) {
		    // ��½�ɹ�	
			info.setFlag(true);
			String Jsoninfo = objectMapper.writeValueAsString(info);
			response.getWriter().write(Jsoninfo);
		}else {
			//��½ʧ��
			info.setFlag(false);
			info.setErrorMsg("�û����������");
			String Jsoninfo = objectMapper.writeValueAsString(info);
			response.getWriter().write(Jsoninfo);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
