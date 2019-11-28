package com.jswl.travel.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import com.jswl.travel.pojo.Category;
import com.jswl.travel.utils.JDBCUtils;

public class CategoryDao {
	
	
	// ��ȡ���ݿ�����
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
	public List<Category> findByLists(){
		
		String  sql ="select cid,cname from tab_category";
		
		return jd.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}
	
	
	

}
