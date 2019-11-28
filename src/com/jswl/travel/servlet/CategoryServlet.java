package com.jswl.travel.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.Category;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.service.CategoryService;


@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs = new CategoryService();
		
		List<Category> list = cs.findByList();
		
		//创建一个返回的封装类
		ResultInfo resultInfo  = new ResultInfo();
		// 创建一个将对象转换成json串的封装类
		ObjectMapper ob = new ObjectMapper();
		resultInfo.setData(list);
		String StringJson = ob.writeValueAsString(resultInfo);
		// 转码
		response.setContentType("application/json;charset=utf-8");
       // 传给页面
		response.getWriter().write(StringJson);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
