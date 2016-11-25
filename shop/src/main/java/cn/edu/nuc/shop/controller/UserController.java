package cn.edu.nuc.shop.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.edu.nuc.shop.entiry.User;
import cn.edu.nuc.shop.service.interfaces.UserService;
import cn.edu.nuc.shop.vo.Reg;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/toregist",method=RequestMethod.GET)
	public String toregist(){
		
		return "redirect:/regist.jsp";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(User user,HttpServletRequest request){
		
		int rows = userService.regist(user);
		
		if(rows==1){
			
			request.getSession().setAttribute("username", user.getUsername());
			
			return "redirect:/product/frontlist";
		}
		
			request.setAttribute("msg", "注册失败");
		
		return "forward:/user/toregist";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String tologin(){
		
		return "redirect:/login.jsp";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpServletRequest request){
		
		User exituser =  userService.login(user);
		
		if(exituser ==null){
			
			model.addAttribute("msg","用户名或密码错误");
			return "forward:/login.jsp";
		}
		
		request.getSession()
		.setAttribute("frontuser", exituser.getUsername());
		request.getSession()
		.setAttribute("frontuserId", exituser.getUid());
		
		String path = (String) request.getSession().getAttribute("orderpath");
		
		if(path!=null){
			
			return "redirect:" + path;
			
		}
		return "redirect:/product/frontlist";
	}
	
	@RequestMapping(value="/checkuser",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public @ResponseBody Reg checkusername(String username){
		
		int count = userService.checkusername(username);
		Reg reg = new Reg(200 , "可以注册");
		
		if(count>0){
		
			reg.setCode(500);
			reg.setMsg("账号已经存在");
			
		}
		
		return reg;
	}
	
	
}
