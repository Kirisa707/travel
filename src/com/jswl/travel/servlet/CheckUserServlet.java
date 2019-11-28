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
		// 调用service
		 User checkUser = us.checkUser(userName, password);
		 // 2 把用户放到session当中
		 request.getSession().setAttribute("chek", checkUser);
		// 获取验证码
		String  coString = (String)request.getSession().getAttribute("sms");
		ResultInfo info  = new ResultInfo();
		ObjectMapper objectMapper  = new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		// 判断checkUser是否存在
		if(checkUser!=null && coString.equals(code)) {
		    // 登陆成功	
			info.setFlag(true);
			String Jsoninfo = objectMapper.writeValueAsString(info);
			response.getWriter().write(Jsoninfo);
		}else {
			//登陆失败
			info.setFlag(false);
			info.setErrorMsg("用户名密码错误");
			String Jsoninfo = objectMapper.writeValueAsString(info);
			response.getWriter().write(Jsoninfo);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
