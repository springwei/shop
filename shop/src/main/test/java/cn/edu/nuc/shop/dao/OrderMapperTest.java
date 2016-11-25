package cn.edu.nuc.shop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.Admin;
import cn.edu.nuc.shop.entiry.Forder;

public class OrderMapperTest extends BaseTest{

	@Autowired
	private  ForderMapper forderMapper;
	
	@Autowired
	private  AdminMapper accountMapper;
	
	@Test
	public void selectList(){
		
		List<Forder> list = forderMapper.selectList();
		
		System.out.println("----------------" + list);
	}
	
	
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
