package com.jswl.travel.dao;


import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.User;
import com.jswl.travel.utils.JDBCUtils;

public class UserDao {
	
	// �����������ݿ�Ĺ�����   ��ʹ�����ݿ����ӳ�
	JdbcTemplate jd  = new JdbcTemplate(JDBCUtils.getDataSource());
	
	
	//  ��ѯ�û��Ƿ����
	public User   findByUserName(String userName) {
		User user = null;
		// ��дsql���
		String sql ="select username from tab_user where username=?";
		try {
			
	      user = jd.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),userName);	
		
		} catch (Exception e) {
			// ������ִ��󷵻ؿ�
		  return null;
		}
		
		return user;
	}
	// ���淽��    ����  ɾ��  �޸ĵķ������Ͷ���integer  ��ѯ ����list �����Ƕ���
	public Integer   save(User user) {
		int result =0;
		// ��д�������
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
	// �鿴code�Ƿ����
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
	// ����id�޸ļ���״̬
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
