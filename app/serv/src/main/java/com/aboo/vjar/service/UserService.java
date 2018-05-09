package com.aboo.vjar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboo.vjar.data.mapper.UserMapper;
import com.aboo.vjar.data.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public boolean insertUser(String userName){
		User user = new User();
		user.setUserName(userName);
		int cnt = userMapper.insert(user);
		System.out.println("return cnt->"+cnt+"    userId->"+user.getUserId());
		return true;
	}
	
	public boolean selectUser(Long userId){
		User user = userMapper.selectUser(userId);
		System.out.println("return userId->"+user.getUserId()+"    userName->"+user.getUserName());
		return true;
	}
	
	public boolean deleteUser(Long userId){
		int cnt = userMapper.deleteById(userId);
		return cnt == 1;
	}
	
}
