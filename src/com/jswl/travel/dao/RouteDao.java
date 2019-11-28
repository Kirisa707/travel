package com.jswl.travel.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jswl.travel.pojo.Route;
import com.jswl.travel.utils.JDBCUtils;

public class RouteDao {

	// ��ȡ���ݿ�����   
	JdbcTemplate jd = new JdbcTemplate(JDBCUtils.getDataSource());
	
	// cid     Rtext   ��������
	//  ���cid û�еĻ�  ֻ��rtext   û��Rtext   ֻ��cid
	// �����ȡ������
	public Integer findTotalCount(Integer cid,String rText) {
		//   ����һ��sql����ģ��  ԭʼ��
		String sql ="SELECT count(*)  FROM tab_route where 1=1 ";
		StringBuilder  sbui  = new StringBuilder(sql);
		List param = new ArrayList();
		// cid��ֵ��ʱ��
		if(cid != 0) {
			// ��cid
			sbui.append(" and cid = ? ");
			param.add(cid);
		}
		// ��rname��ֵ��ʱ��    null ""
		if(rText != null && rText.length()>0 && !"null".equals(rText)) {
			sbui.append("and rname like ?");
			param.add("%"+rText+"%");
		}
		sql = sbui.toString();
		  System.out.println(sql);
			System.out.println(param.toString());
		/* String sql ="SELECT count(*)  FROM tab_route WHERE cid=? and rText=?"; */
		// ֻ���ڲ�ѯ��ֵ�������  ������BeanPropertyRowMapper
		return jd.queryForObject(sql,Integer.class, param.toArray());
	}	
	// ÿҳ��ʾ������
 	public List<Route> finByRouteForList(int cid,int start,int pageSize,String rText){
 	       //   ����һ��sql����ģ��  ԭʼ��
 			String sql ="SELECT  *  FROM tab_route where 1=1 ";
 			StringBuilder  sbui  = new StringBuilder(sql);
 			List param = new ArrayList();
 			if(cid != 0) {
 				// ��cid
 				sbui.append("and cid=? ");
 				param.add(cid);
 			}
 		// ��rname��ֵ��ʱ��
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
	// ����rid ��ѯ����������Ʒ
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
 	
 	// ��ѯ��Ʒ���ղش���
 	public Integer  findCountByid(Integer rid) {
 		
 		String sql ="SELECT COUNT(*) FROM tab_favorite WHERE rid=?";
 		
 		return jd.queryForObject(sql,Integer.class,rid);
 		
 	}
 	
 	
	
	
}