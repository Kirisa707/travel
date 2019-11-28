package com.jswl.travel.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.Route;
import com.jswl.travel.utils.JDBCUtils;

public class RouteDao {

	// 获取数据库链接   
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
	// cid     Rtext   三个都有
	//  如果cid 没有的话  只查rtext   没有Rtext   只查cid
	// 负责获取总条数
	public Integer findTotalCount(Integer cid,String rText) {
		//   定义一个sql语句的模板  原始的
		String sql ="SELECT count(*)  FROM tab_route where 1=1 ";
		StringBuilder  sbui  = new StringBuilder(sql);
		List param = new ArrayList();
		// cid有值得时候
		if(cid != 0) {
			// 有cid
			sbui.append(" and cid = ? ");
			param.add(cid);
		}
		// 当rname有值得时候    null ""
		if(rText != null && rText.length()>0 && !"null".equals(rText)) {
			sbui.append("and rname like ?");
			param.add("%"+rText+"%");
		}
		sql = sbui.toString();
		  System.out.println(sql);
			System.out.println(param.toString());
		/* String sql ="SELECT count(*)  FROM tab_route WHERE cid=? and rText=?"; */
		// 只有在查询赋值的情况下  才能用BeanPropertyRowMapper
		return jd.queryForObject(sql,Integer.class, param.toArray());
	}	
	// 每页显示的数据
 	public List<Route> finByRouteForList(int cid,int start,int pageSize,String rText){
 	       //   定义一个sql语句的模板  原始的
 			String sql ="SELECT  *  FROM tab_route where 1=1 ";
 			StringBuilder  sbui  = new StringBuilder(sql);
 			List param = new ArrayList();
 			if(cid != 0) {
 				// 有cid
 				sbui.append("and cid=? ");
 				param.add(cid);
 			}
 		// 当rname有值得时候
 			if(rText!=null && rText.length()>0 && !"null".equals(rText)) {
 				sbui.append("and rname like ?");
 				param.add("%"+rText+"%");
 			}
 			sbui.append("LIMIT ?,?");
 			sql =sbui.toString();
 			param.add(start);
 			param.add(pageSize);
 			System.out.println(sql);
 			System.out.println(param.toString());
 		return jd.query(sql, new BeanPropertyRowMapper<Route>(Route.class),param.toArray());
 	}
	// 根据rid 查询单个旅游商品
 	public  Route findOne(String rid) {
 		Route ro =null;
 		String sql ="select * from tab_route where rid=?";
 		try {
 	 	  ro = jd.queryForObject(sql, new BeanPropertyRowMapper<Route>
 	 	        (Route.class),rid);

		} catch (Exception e) {
			e.printStackTrace();
		   return null;
		}
 		
 		return ro;
 		
 	}
 	
 	// 查询商品的收藏次数
 	public Integer  findCountByid(Integer rid) {
 		
 		String sql ="SELECT COUNT(*) FROM tab_favorite WHERE rid=?";
 		
 		return jd.queryForObject(sql,Integer.class,rid);
 		
 	}
 	
 	
	
	
}