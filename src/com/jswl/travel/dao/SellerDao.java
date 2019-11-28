package com.jswl.travel.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.Seller;
import com.jswl.travel.utils.JDBCUtils;
// ²éÑ¯Âô¼Ò
public class SellerDao {
	
	
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
	public Seller findBysId(Integer sid) {
		
		Seller seller =null;
		String sql="select * from tab_seller where sid=?";
		try {
			seller = jd.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class),sid);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
		return  seller;
		
		
	}
	

}
