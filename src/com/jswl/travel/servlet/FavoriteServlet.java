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

@WebServlet("/favoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FavoriteService fs = new FavoriteService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String rid =  request.getParameter("rid");  
	      User user =   (User)request.getSession().getAttribute("chek");
	      int uid =0;
	      if (user==null) {
	    	  // ÓÃ»§ÉÐÎ´µÇÂ½
	    	  uid=0;
			
		}else {
			uid = user.getUid();
		}
	     boolean flage = fs.isFavorite(Integer.parseInt(rid), uid);
	     response.setContentType("application/json;charset=utf-8");
	     ObjectMapper objectMapper = new ObjectMapper();
	     ResultInfo resultInfo   = new ResultInfo();
	     resultInfo.setFlag(flage);
	     String jsoString = objectMapper.writeValueAsString(resultInfo);
	     response.getWriter().write(jsoString);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
