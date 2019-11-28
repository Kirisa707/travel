package com.jswl.travel.test;

import org.junit.Test;

import com.jswl.travel.pojo.User;
import com.jswl.travel.service.UserService;

public class Tests {
	
	UserService UserService  = new UserService();
	@Test
	public void fun() {
		
		User user = new User();
		user.setUsername("liys");
		Boolean result = UserService.isUserName(user);
		System.out.println(result);
		
	}
	

}
