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
		// ���û���session��ȥ����
		User user  = (User)request.getSession().getAttribute("chek");
		// �ж��û��շ����
        if (user!=null) {
        	// ��Ž���Ķ���
		ResultInfo info = new ResultInfo();
		// ת��json�ַ����Ķ���
		ObjectMapper objectMapper = new ObjectMapper();
		// ��������json����
		response.setContentType("application/json;charset=utf-8");
		// ���û���
		if ((!"".equals(user.getUsername())) || (user.getUsername()!=null)) {
			// ����Ϊ��
			info.setFlag(true);
			// ��session����Ž�ȥ
			info.setData(user);
			// ת����json
			String codes = objectMapper.writeValueAsString(info);
			//  {data:"code",flag:true}  code.value
			// ���ɵ�ҳ�浱��ȥ
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
