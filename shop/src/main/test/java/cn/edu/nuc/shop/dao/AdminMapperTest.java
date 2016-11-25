package cn.edu.nuc.shop.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.Admin;

public class AdminMapperTest extends BaseTest{

	@Autowired
	private AdminMapper accountMapper;
	
	@Test
	public void selectByPrimaryKey(){
		
		Admin account = accountMapper.selectByPrimaryKey(1);
		
		System.out.println( account);
	}
	
	@Test
	public void findByAdmin(){
		
		Admin account = accountMapper.findByAdmin("admin", "admin");
		
		System.out.println( account);
	}
}
