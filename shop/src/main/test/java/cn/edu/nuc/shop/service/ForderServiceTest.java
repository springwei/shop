package cn.edu.nuc.shop.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.dao.ProductMapper;
import cn.edu.nuc.shop.entiry.Forder;
import cn.edu.nuc.shop.entiry.Product;
import cn.edu.nuc.shop.service.interfaces.ForderService;
import cn.edu.nuc.shop.service.interfaces.ProductService;

public class ForderServiceTest extends BaseTest {
	
	@Autowired
	private ForderService forderMapper;
	
	@Test
	public void listProduct(){
		
		Forder forder = new Forder();
		
		forder.setAddress("sdfsdf");
		
	//	int count =  forderMapper.insertOrder(forder);
		
		System.out.println(forder.getFid());
		 
		// System.out.println(count+"--------------------------");
	}
	
	@Test
	public void findProduct(){
		
	}

}
