package com.jswl.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.utils.UuidUtil;


@WebServlet("/getCodeSmsServlet")
public class GetCodeSmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 生成验证码
		String uuid = UuidUtil.getUuid();
		// 截取4位置
		String msg = uuid.substring(0, 4);
		// 放到session容器里
	    request.getSession().setAttribute("sms", msg);
	    // 创建一个结果对象
	    ResultInfo info = new ResultInfo();
	    if (msg!=null ||msg!="") {
	    	 info.setFlag(true);
		      //把4位的串放到结果对象里
		 	 info.setMsg(msg);
		}else {
			info.setFlag(false);
			info.setErrorMsg("验证码生成错误请重新获取");
		}
	 // 获取jackson转换对象
	    ObjectMapper ob = new ObjectMapper();
	    // 将对象转换成json串
	    String jsonValue = ob.writeValueAsString(info);
	    //  转码
	    response.setContentType("application/json;charset=utf-8");
	    // 写会页面
	    response.getWriter().write(jsonValue);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
