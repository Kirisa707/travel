package com.jswl.travel.service;

import java.util.List;

import com.jswl.travel.dao.CategoryDao;
import com.jswl.travel.pojo.Category;

public class CategoryService {

	CategoryDao cd = new CategoryDao();
	
	
	public List<Category> findByList(){
		
		return cd.findByLists();
	}
	
}
