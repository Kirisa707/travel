package com.jswl.travel.service;

import static org.hamcrest.CoreMatchers.nullValue;

import com.jswl.travel.dao.UserDao;
import com.jswl.travel.pojo.User;
import com.jswl.travel.utils.MailUtils;
import com.jswl.travel.utils.UuidUtil;
import com.sun.org.apache.regexp.internal.recompile;

public class UserService {
	
	
	UserDao  userDao  = new UserDao();
	// 判断用户名是否存在 新增
	public Boolean isUserName(User user) {
		// 查询用户是否存在
		User user2 = userDao.findByUserName(user.getUsername());
	   // 判断是否存在
		if(user2==null) {
			// 设置激活码
			user.setCode(UuidUtil.getUuid());
			// 设置状态码   0未激活
			user.setStatus("0");
			// 进行注册
			Integer save = userDao.save(user);
			// 判断新增
			if(save<=0 || save==null) {
				return false;
			}else {
				try {
					// 发送邮箱   用户注册完成需要收到一封邮件   有一条信息  就是激活链接
					//激活链接  邮箱内容
					String context="<a href='http://localhost:8080/travel/activeUserServlet?"
							+ "code="+user.getCode()+"'>点击激活携程旅游网链接  亲！。。。。</a>";
					// 发送邮件
					 MailUtils.sendMail(user.getEmail(),context,"携程旅游网激活邮件");
					 System.out.println("发送邮件");
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
			// 存在的   // 更新激活状态
			Integer result = userDao.updataActiveCode(user);
			if (result>0) {
				return true;
			}
		}else {
			// 不存在
			return false;
		}
		return false;
		
	}
	// 1查询用户
	public User checkUser(String userName,String password) {
		
		return userDao.findByUser(userName, password);
	}
	
	
	
	
	
	

}