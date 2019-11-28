package com.jswl.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.pojo.Route;
import com.jswl.travel.service.RouteService;

@WebServlet("/routeFindImgSellerServlet")
public class RouteFindImgSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RouteService ro = new RouteService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rid = request.getParameter("rid");
		
		Route route = ro.findOne(rid);
		
		// 将对象转换成json  
		ObjectMapper objectMapper = new ObjectMapper();
		ResultInfo rif = new ResultInfo();
		rif.setData(route);
		String json = objectMapper.writeValueAsString(rif);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
