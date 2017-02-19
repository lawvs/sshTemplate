package edu.jmu.dao;

import java.util.List;

import edu.jmu.pojo.User;

public interface IUserDao {
	public boolean insertUser(User user);

	public boolean deleteUser(User user);

	public boolean updateUser(User user);

	public boolean insertOrUpdateUser(User user);

	public User findByUsername(String username);

	public List<User> findAllUser();
}
