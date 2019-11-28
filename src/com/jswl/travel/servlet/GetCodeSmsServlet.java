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
		// ������֤��
		String uuid = UuidUtil.getUuid();
		// ��ȡ4λ��
		String msg = uuid.substring(0, 4);
		// �ŵ�session������
	    request.getSession().setAttribute("sms", msg);
	    // ����һ���������
	    ResultInfo info = new ResultInfo();
	    if (msg!=null ||msg!="") {
	    	 info.setFlag(true);
		      //��4λ�Ĵ��ŵ����������
		 	 info.setMsg(msg);
		}else {
			info.setFlag(false);
			info.setErrorMsg("��֤�����ɴ��������»�ȡ");
		}
	 // ��ȡjacksonת������
	    ObjectMapper ob = new ObjectMapper();
	    // ������ת����json��
	    String jsonValue = ob.writeValueAsString(info);
	    //  ת��
	    response.setContentType("application/json;charset=utf-8");
	    // д��ҳ��
	    response.getWriter().write(jsonValue);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
