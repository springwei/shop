package cn.edu.nuc.shop.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.User;

public class UserMapperTest extends BaseTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void listProduct(){
		
		User user = new User();
		
		user.setUsername("user");
		user.setPassword("user");
		
		int c = userMapper.checkUsername("user");
		
		System.out.println(c + "----------------");
		
	}
	
	@Test
	public void qw(){
		
		User user = new User();
		
		user.setUsername("user");
		user.setPassword("user");
		
		User user2= userMapper.login(user);
		
		System.out.println(user2 + "----------------");
		
	}
}
