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
import com.jswl.travel.service.FavoriteService;


@WebServlet("/deleteCollectServlet")
public class DeleteCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteService  fs = new FavoriteService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		
		User user = (User)request.getSession().getAttribute("chek");
		Boolean flag = fs.deleteCollect(rid,user.getUid());
		ResultInfo info  = new ResultInfo();
		ObjectMapper objectMapper  = new ObjectMapper();
		response.setContentType("application/json;charset=utf-8");
		info.setFlag(flag);
		String jsonString = objectMapper.writeValueAsString(info);
		response.getWriter().write(jsonString);
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
