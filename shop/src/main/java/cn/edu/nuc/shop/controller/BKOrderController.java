package cn.edu.nuc.shop.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.shop.entiry.Forder;
import cn.edu.nuc.shop.service.interfaces.ForderService;

@Controller
@RequestMapping("/order")
public class BKOrderController {
	
	@Autowired
	private ForderService forderService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listProduct(Model model){
		
		List<Forder> list = forderService.selectList();
		model.addAttribute("list", list);
		
		System.out.println(list);
		
		return "order/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Forder forder,Model model){
		
		
		
		try {
			
			forderService.deleteByPrimaryKey(forder.getFid());
			
		} catch (Exception e) {
			
			model.addAttribute("msg", "删除失败");
			return "sys/error.jsp";
			
		}
		
		List<Forder> list = forderService.selectList();
		model.addAttribute("list", list);
		
		System.out.println(list);
		
		return "order/list";
	}
	
	
	
	
}
