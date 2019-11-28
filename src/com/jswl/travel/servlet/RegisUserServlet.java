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

	// ����Userservice
	UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 ��ȡ����
		Map<String, String[]> map = request.getParameterMap();
		// ת��ΪjavaBean
		User  user  = new User();
		try {
			//���ύ������ת��Ϊuser����
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//��������ķ�װ��
		ResultInfo info = new ResultInfo();
		//����service��ע�᷽�����ע��
		Boolean result = us.isUserName(user);
		// �������װ��
		if (result) {
			// ע��ɹ�
			info.setFlag(true);
		}else {
			// ע��ʧ��
			info.setFlag(false);
			info.setErrorMsg("ע��ʧ��");
		}
		//����ʾ��Ϣת��Ϊjson
		ObjectMapper ob = new ObjectMapper();
		// json�ַ���
		String json = ob.writeValueAsString(info);
		// ת��
		response.setContentType("application/json;charset=utf-8");
		// ��json��д��ҳ����
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
