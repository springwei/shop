package cn.edu.nuc.shop.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.dao.ProductMapper;
import cn.edu.nuc.shop.entiry.Product;
import cn.edu.nuc.shop.service.interfaces.ProductService;

public class ProductServiceTest extends BaseTest {
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void listProduct(){
		
		Product product =  productService.findById(5);
		 
		 System.out.println(product+"--------------------------");
	}
	
	@Test
	public void findProduct(){
		
	}

}
