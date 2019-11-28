package com.jswl.travel.dao;


import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.User;
import com.jswl.travel.utils.JDBCUtils;

public class UserDao {
	
	// 创建操作数据库的工具类   并使用数据库连接池
	JdbcTemplate jd  = new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	//  查询用户是否存在
	public User   findByUserName(String userName) {
		User user = null;
		// 编写sql语句
		String sql ="select username from tab_user where username=?";
		try {
			
	      user = jd.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userName);	
		
		} catch (Exception e) {
			// 如果出现错误返回空
		  return null;
		}
		
		return user;
	}
	// 保存方法    新增  删除  修改的返回类型都是integer  查询 多条list 单条是对象
	public Integer   save(User user) {
		int result =0;
		// 编写新增语句
		String sql ="insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
		
			result= jd.update(sql,user.getUsername(),
                user.getPassword(),
            user.getName(),
            user.getBirthday(),
            user.getSex(),
            user.getTelephone(),
            user.getEmail(),
            user.getStatus(),
            user.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 查看code是否存在
	public User findByCode(String code) {
		
		User user = null;
		try {
		String sql ="select * from tab_user where code=?";
		user =jd.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),code);
		} catch (Exception e) {
		    return null;
		}
		return user;
		
	}
	// 根据id修改激活状态
	public Integer updataActiveCode(User user) {
	    
		String sql ="update tab_user set status='1' where uid=?";
		
		return jd.update(sql,user.getUid());
		
		
	}
	
	
	public User findByUser(String userName,String password) {
		
		String sql ="SELECT * FROM tab_user WHERE username=? AND PASSWORD=? AND STATUS=1";
		User user =null;
		try {
			user= jd.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userName,password);
			  
		} catch (Exception e) {
			return null;
		}
		return user;
	}
	
	
	

}
