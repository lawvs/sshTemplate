package edu.jmu.service.impl;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jmu.dao.IUserDao;
import edu.jmu.pojo.User;
import edu.jmu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao userDao;

	public UserServiceImpl() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public User login(String username, String password) {
		User user = null;
		if (userDao == null) {//发生错误
			LogManager.getRootLogger().error("登录发生错误！userDao为空");
			return null;
		}
		// 获取用户
		user = userDao.findByUsername(username);

		// 检查密码
		if (user != null && user.getPassword().equals(password)) {
			LogManager.getRootLogger().info("登录成功");
			return user;
		}
		LogManager.getRootLogger().warn("登录失败！");
		return null;
	}

	@Override
	public boolean register(User user) {
		// TODO 自动生成的方法存根
		return true;
	}

}
