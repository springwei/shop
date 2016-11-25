package cn.edu.nuc.shop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.Admin;
import cn.edu.nuc.shop.entiry.Forder;
import cn.edu.nuc.shop.entiry.Sorder;

public class ForderMapperTest extends BaseTest{

	@Autowired
	private SorderMapper sorderMapper;
	
	
	@Test
	public void findByAdmin(){
		
		 List<Sorder> account = sorderMapper.listSorderByfid(201407013);
		
		System.out.println("------------------" + account);
	}
}
