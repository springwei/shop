package cn.edu.nuc.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.shop.dao.UserMapper;
import cn.edu.nuc.shop.entiry.User;
import cn.edu.nuc.shop.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int regist(User user) {
		
		return	userMapper.insert(user);
	}

	@Override
	public int checkusername(String username) {
		
		return userMapper.checkUsername(username);
	}

	@Override
	public User login(User user) {
		
		return userMapper.login(user);
	}

}
