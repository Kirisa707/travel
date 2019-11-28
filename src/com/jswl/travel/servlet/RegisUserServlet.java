package com.jswl.travel.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.pojo.User;
import com.jswl.travel.service.UserService;


@WebServlet("/regisUserServlet")
public class RegisUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 调用Userservice
	UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取数据
		Map<String, String[]> map = request.getParameterMap();
		// 转换为javaBean
		User  user  = new User();
		try {
			//将提交的数据转换为user对象
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//创建结果的封装类
		ResultInfo info = new ResultInfo();
		//调用service的注册方法完成注册
		Boolean result = us.isUserName(user);
		// 将结果封装到
		if (result) {
			// 注册成功
			info.setFlag(true);
		}else {
			// 注册失败
			info.setFlag(false);
			info.setErrorMsg("注册失败");
		}
		//将提示信息转换为json
		ObjectMapper ob = new ObjectMapper();
		// json字符串
		String json = ob.writeValueAsString(info);
		// 转码
		response.setContentType("application/json;charset=utf-8");
		// 将json串写回页面里
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
