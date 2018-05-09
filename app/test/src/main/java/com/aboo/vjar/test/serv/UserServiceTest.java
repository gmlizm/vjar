package com.aboo.vjar.test.serv;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aboo.vjar.TestApplication;
import com.aboo.vjar.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestApplication.class })
public class UserServiceTest {
	
	
	@Autowired
	private UserService userService;
	
	//@Test
	public void testInsertUser() {
		boolean result  = userService.insertUser("张三2");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testSelectUser() {
		boolean result  = userService.selectUser(2L);
		Assert.assertTrue(result);
	}
	
	

}
