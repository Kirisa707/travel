package com.jswl.travel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jswl.travel.pojo.PageBean;
import com.jswl.travel.pojo.ResultInfo;
import com.jswl.travel.pojo.Route;
import com.jswl.travel.service.RouteService;

@WebServlet("/routePageQuery")
public class RoutePageQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ����   cid  pageSize  currentPage
		String currentPage =request.getParameter("currentPage");
		String pageSize =request.getParameter("pageSize");
		String cid   = request.getParameter("cid");
		String rtext = request.getParameter("rtext");
		
		int currentPages =0;
		if (currentPage!=null && currentPage.length()>0) {
			// ��ֵ
			 currentPages = Integer.parseInt(currentPage);
		}else {
			// ��ǰҳΪ0
			currentPages =1;
			
		}
		int pagesize = 0;
		if (pageSize!=null && pageSize.length()>0) {
			// ��ֵ
			pagesize = Integer.parseInt(pageSize);
		}else {
			// ÿҳ��ʾ������Ϊ0
			pagesize =5;
		}
		int cids= 0;
		if ((cid!=null && cid.length()>0) && !"null".equals(cid)) {
			// ��ֵ
			 cids = Integer.parseInt(cid);
		}
		//  ����service ���õ�pageBean
		RouteService  routeService = new RouteService();
		// ����service  ����
		PageBean<Route> pb = routeService.queryPageBean(cids, currentPages, pagesize,rtext);
		// ����
		ObjectMapper omMapper = new ObjectMapper();
		ResultInfo resultInfo  = new ResultInfo();
		resultInfo.setData(pb);
		response.setContentType("application/json;charset=utf-8");
		String jsonString = omMapper.writeValueAsString(resultInfo);
		response.getWriter().write(jsonString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
