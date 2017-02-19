package edu.jmu.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.jmu.pojo.User;
import edu.jmu.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserServiceImplTest {
	@Autowired
	IUserService userService;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("---TEST---");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("---TESTEND---");
	}

	@Test
	public void testLogin() {
		String username;
		String password;
		User user;
		username="张三";
		password="123";
		user=userService.login(username, password);
		assertNotNull(user);
		System.out.println(user);
		
		password="000";
		user=userService.login(username, password);
		assertNull(user);
		
		user=userService.login(username, null);
		assertNull(user);
		
		password="9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		user=userService.login(username, password);
		assertNull(user);
		
		username="9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		password="123";
		user=userService.login(username, password);
		assertNull(user);
		
		user=userService.login(null, password);
		assertNull(user);
		
		user=userService.login("", "");
		assertNull(user);
		
		user=userService.login(null, null);
		assertNull(user);
		
	}

	@Test
	public void testRegister() {
		fail("尚未实现");
	}

}
