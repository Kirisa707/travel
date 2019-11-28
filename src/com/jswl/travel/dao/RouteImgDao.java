package com.jswl.travel.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.RouteImg;
import com.jswl.travel.utils.JDBCUtils;
// ²éÑ¯Í¼Æ¬¼¯ºÏ
public class RouteImgDao {
	
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
	public List<RouteImg> allList(Integer rid){
		
		String sql ="select * from  tab_route_img where rid=?";
		
		return jd.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class),rid);
	}
	
	
	

}
