package edu.jmu.service;

import edu.jmu.pojo.User;

public interface IUserService {
	public User login(String username,String password);//登录
	public boolean register(User user);//注册
}
