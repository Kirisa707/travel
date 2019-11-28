package com.jswl.travel.service;

import java.util.List;

import com.jswl.travel.dao.RouteDao;
import com.jswl.travel.dao.RouteImgDao;
import com.jswl.travel.dao.SellerDao;
import com.jswl.travel.pojo.PageBean;
import com.jswl.travel.pojo.Route;
import com.jswl.travel.pojo.RouteImg;
import com.jswl.travel.pojo.Seller;

public class RouteService {
	
	RouteDao  rd = new RouteDao();
	// 1  页面需要传几个参数   
	
	public  PageBean<Route> queryPageBean(int cid,int currentPage,int pageSize,String rText){
		PageBean<Route> pg = new PageBean<Route>();
		// 当前页    
		pg.setCurrentPage(currentPage);
		// 每页显示的条数
		pg.setPageSize(pageSize);
		//  设置总记录数
		Integer count = rd.findTotalCount(cid,rText);
		pg.setTotalCount(count);
		// 设置 当前页数显示的数据集合
		int start = (currentPage-1)*pageSize;
		List<Route> list = rd.finByRouteForList(cid, start, pageSize,rText);
		pg.setList(list);
		// 设置总页数
		int totalPage =  count % pageSize ==0? count / pageSize:(count / pageSize)+1;
		pg.setTotalPage(totalPage);
		//返回个Servlet
		return pg;
	} 
	
	
	
	
	
	RouteImgDao routeimgdao = new RouteImgDao();
	SellerDao   sellerDao   = new SellerDao();
	public Route  findOne(String rid) {
		//根据rid查route对象 
		Route route = rd.findOne(rid);
		
		// 根据rid查询图片集合
		List<RouteImg> imgList = routeimgdao.allList(route.getRid());
		route.setRouteImgs(imgList);
		
		// 根据sid查商家
		Seller seller = sellerDao.findBysId(route.getSid());
		route.setSeller(seller);
		
		Integer count = rd.findCountByid(route.getRid());
		route.setCount(count);
		
		
		return route;
	}
	
	public Integer findCountByid(String rid) {
		
		return  rd.findCountByid(Integer.parseInt(rid));
		
	}
	
	
	

}
