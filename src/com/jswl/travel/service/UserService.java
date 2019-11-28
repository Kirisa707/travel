package com.jswl.travel.service;

import static org.hamcrest.CoreMatchers.nullValue;

import com.jswl.travel.dao.UserDao;
import com.jswl.travel.pojo.User;
import com.jswl.travel.utils.MailUtils;
import com.jswl.travel.utils.UuidUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class UserService {
	
	
	UserDao  userDao  = new UserDao();
	// �ж��û����Ƿ���� ����
	public Boolean isUserName(User user) {
		// ��ѯ�û��Ƿ����
		User user2 = userDao.findByUserName(user.getUsername());
	   // �ж��Ƿ����
		if(user2==null) {
			// ���ü�����
			user.setCode(UuidUtil.getUuid());
			// ����״̬��   0δ����
			user.setStatus("0");
			// ����ע��
			Integer save = userDao.save(user);
			// �ж�����
			if(save<=0 || save==null) {
				return false;
			}else {
				try {
					// ��������   �û�ע�������Ҫ�յ�һ���ʼ�   ��һ����Ϣ  ���Ǽ�������
					//��������  ��������
					String context="<a href='http://localhost:8080/travel/activeUserServlet?"
							+ "code="+user.getCode()+"'>�������Я������������  �ף���������</a>";
					// �����ʼ�
					 MailUtils.sendMail(user.getEmail(),context,"Я�������������ʼ�");
					 System.out.println("�����ʼ�");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				return true;
			}
		}
		return false;
		
		
		
	}
	
	public Boolean activeByCode(String code) {
		
		User user = userDao.findByCode(code);
		if (user!=null) {
			// ���ڵ�   // ���¼���״̬
			Integer result = userDao.updataActiveCode(user);
			if (result>0) {
				return true;
			}
		}else {
			// ������
			return false;
		}
		return false;
		
	}
	// 1��ѯ�û�
	public User checkUser(String userName,String password) {
		
		return userDao.findByUser(userName, password);
	}
	
	
	
	
	
	

}