package cn.edu.nuc.shop.controller;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.shop.BaseTest;

@WebAppConfiguration
public class AdminControllerTest extends BaseTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	
	
	private MockMvc mockMvc;
	
	@Before
	public void before() throws Exception{
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testLogin() throws Exception{
		
		MockHttpServletRequestBuilder requestBuilder=
				MockMvcRequestBuilders.post("/login");
		
		requestBuilder.accept(MediaType.TEXT_HTML);
		requestBuilder.param("username", "admin");
		requestBuilder.param("password", "admin");
		ResultActions ra = this.mockMvc.perform(requestBuilder);
		
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName() + "------------------");
		
		
		
	}
	
	
	

}
