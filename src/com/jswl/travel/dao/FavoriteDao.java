package com.jswl.travel.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.Favorite;
import com.jswl.travel.utils.JDBCUtils;

public class FavoriteDao {
	
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
		public Favorite isCheckFavorite(Integer rid,Integer uid) {
			Favorite f =null;
			String sql ="select * from tab_favorite where rid=? and uid=?";
			try {
			f=	jd.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class),rid,uid);
			} catch (Exception e) {
				
				return null;
			}
			return f;
		}
		
		public void addCollect(Integer rid,Integer uid) {
			
			String sql ="insert into tab_favorite(rid,date,uid) values(?,?,?)";
			jd.update(sql,rid,new Date(),uid);
		}

		public Integer deleteCollect(String rid, Integer uid) {
			String sql ="delete from tab_favorite where rid=? and uid=?";
			return jd.update(sql,rid,uid);
			
		}
		
		
		
	

}
