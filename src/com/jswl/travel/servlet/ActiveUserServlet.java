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
		
		//1   获取激活码
		String code = request.getParameter("code");
		if(code!=null) {
			
			UserService userService = new UserService();
			Boolean flag = userService.activeByCode(code);
			
			// 定义一个返回文字的变量
			String msg =null;
			if (flag) {
				//激活成功
				msg="激活成功 <a href='login.html'>登陆</a>";
			}else {
				// 激活失败
				msg ="激活失败， 请联系管理员";
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
