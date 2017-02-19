package edu.jmu.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.jmu.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserDaoImplTest {
	@Resource
	IUserDao userDao;

	@Before
	public void setUp() throws Exception {
		System.out.println("---TEST---");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("---TESTEND---");
	}

	@Test
	public void testInsertUser() {
		User user = new User("test");
		boolean condition = userDao.insertUser(user);
		Assert.assertTrue(condition);
	}

	@Test
	public void testDeleteUser() {
		User user = new User("test");
		boolean condition = userDao.deleteUser(user);
		Assert.assertTrue(condition);
		System.out.println("删除" + user.getUsername() + "成功");
		user.setUsername("test2");
		condition = userDao.deleteUser(user);
		Assert.assertTrue(condition);
		System.out.println("删除" + user.getUsername() + "成功");
		user.setUsername("test3");
		condition = userDao.deleteUser(user);
		Assert.assertTrue(condition);
		System.out.println("删除" + user.getUsername() + "成功");
	}

	@Test
	public void testUpdateUser() {
		User user = new User("李四");
		user.setPassword(new Date().toString());
		boolean condition = userDao.updateUser(user);
		Assert.assertTrue(condition);
	}

	@Test
	public void testInsertOrUpdateUser() {
		User user = new User("test2");
		user.setPassword(new Date().toString());
		boolean condition = userDao.insertOrUpdateUser(user);
		Assert.assertTrue(condition);
	}

	@Test
	public void testFindByUsername() {
		User user;
		user = userDao.findByUsername("李四");
		System.out.println(user);
	}

	@Test
	public void testFindAllUser() {
		List<User> userList;
		userList = userDao.findAllUser();
		Assert.assertNotNull(userList);
		Assert.assertTrue("查询结果需大于0", userList.size() > 0);
		for (User user : userList) {
			if (user != null) {
				System.out.println(user);
			}
		}
		return;
	}

}
