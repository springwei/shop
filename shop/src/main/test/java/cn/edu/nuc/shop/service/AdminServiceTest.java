package cn.edu.nuc.shop.service;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.nuc.shop.BaseTest;
import cn.edu.nuc.shop.entiry.Admin;
import cn.edu.nuc.shop.service.interfaces.AdminService;
import cn.edu.nuc.shop.util.IPTimeStamp;

public class AdminServiceTest extends BaseTest{
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void login(){
		
		/*Admin admin = adminService.login("admin", "admin");
		
		System.out.println(admin);*/
		IPTimeStamp ip = new IPTimeStamp();
		
		System.out.println(ip.getTimeStamp());
		
		
	
		
	}
}
