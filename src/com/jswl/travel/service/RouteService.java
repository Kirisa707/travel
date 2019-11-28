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
	// 1  ҳ����Ҫ����������   
	
	public  PageBean<Route> queryPageBean(int cid,int currentPage,int pageSize,String rText){
		PageBean<Route> pg = new PageBean<Route>();
		// ��ǰҳ    
		pg.setCurrentPage(currentPage);
		// ÿҳ��ʾ������
		pg.setPageSize(pageSize);
		//  �����ܼ�¼��
		Integer count = rd.findTotalCount(cid,rText);
		pg.setTotalCount(count);
		// ���� ��ǰҳ����ʾ�����ݼ���
		int start = (currentPage-1)*pageSize;
		List<Route> list = rd.finByRouteForList(cid, start, pageSize,rText);
		pg.setList(list);
		// ������ҳ��
		int totalPage =  count % pageSize ==0? count / pageSize:(count / pageSize)+1;
		pg.setTotalPage(totalPage);
		//���ظ�Servlet
		return pg;
	} 
	
	
	
	
	
	RouteImgDao routeimgdao = new RouteImgDao();
	SellerDao   sellerDao   = new SellerDao();
	public Route  findOne(String rid) {
		//����rid��route���� 
		Route route = rd.findOne(rid);
		
		// ����rid��ѯͼƬ����
		List<RouteImg> imgList = routeimgdao.allList(route.getRid());
		route.setRouteImgs(imgList);
		
		// ����sid���̼�
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
