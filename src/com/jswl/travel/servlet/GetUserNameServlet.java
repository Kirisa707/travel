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


@WebServlet("/getUserNameServlet")
public class GetUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 把用户从session里去出来
		User user  = (User)request.getSession().getAttribute("chek");
		// 判断用户收否存在
        if (user!=null) {
        	// 存放结果的对象
		ResultInfo info = new ResultInfo();
		// 转换json字符串的对象
		ObjectMapper objectMapper = new ObjectMapper();
		// 返回是以json返回
		response.setContentType("application/json;charset=utf-8");
		// 有用户名
		if ((!"".equals(user.getUsername())) || (user.getUsername()!=null)) {
			// 设置为真
			info.setFlag(true);
			// 把session对象放进去
			info.setData(user);
			// 转换成json
			String codes = objectMapper.writeValueAsString(info);
			//  {data:"code",flag:true}  code.value
			// 放松到页面当中去
			response.getWriter().write(codes);
			
		}else {
			info.setFlag(false);
			String codes = objectMapper.writeValueAsString(info);
			response.getWriter().write(codes);
		}
      }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
