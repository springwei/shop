package cn.edu.nuc.shop.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.Product;

public class ProductMapperTest extends BaseTest{
	
	@Autowired
	private ProductMapper productMapper;
	
	@Test
	public void listProduct(){
		
		List<Product> list = productMapper.listProduct();
		
		System.out.println(list + "----------------");
		
	}
	
	@Test
	public void addpro(){
		
		Product product = new Product();
		
		product.setSprice(200);
		product.setCprice(100);
		product.setIsHot(true);
		
		int i = productMapper.insert(product);
		System.out.println(i);
	}
	
	@Test
	public void findbyname(){
		
		List<Product> list = productMapper.findByPname("女装");
		
		System.out.println(list);
	}
	
	@Test
	public void frontlist(){
		
		//List<Product> list = productMapper.frontlistNew();
		List<Product> list = productMapper.frontlistHot();
		
		System.out.println(list.size());
		
		System.out.println(list);
		
	}
}
