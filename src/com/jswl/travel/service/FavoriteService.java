package com.jswl.travel.service;

import com.jswl.travel.dao.FavoriteDao;
import com.jswl.travel.pojo.Favorite;

public class FavoriteService {
	
	FavoriteDao fd = new FavoriteDao();
	public  Boolean   isFavorite(Integer rid,Integer uid) {
		// 判断这个对象是否有值   是否存在
		Favorite cf = fd.isCheckFavorite(rid, uid);
		
		return  cf!=null;
	}
	public void addCollect(String rid,Integer uid) {
		
		fd.addCollect(Integer.parseInt(rid), uid);
		
	}
	public Boolean deleteCollect(String rid, Integer uid) {
		// TODO Auto-generated method stub
		
		Integer result = fd.deleteCollect(rid,uid);
		if (result<=0) {
			return false;
		}
		return true;
	}
	

}
