package edu.jmu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import edu.jmu.dao.IUserDao;
import edu.jmu.pojo.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserDaoImpl() {
		return;
	}

	@Override
	public boolean insertUser(User user) {
		try {
			hibernateTemplate.save(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			hibernateTemplate.delete(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			hibernateTemplate.update(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertOrUpdateUser(User user) {
		try {
			hibernateTemplate.saveOrUpdate(user);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByUsername(String username) {
		User user = null;
		if (username==null||username.equals("")) {
			return null;
		}
		try {
			user = hibernateTemplate.get(User.class, username);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> userList = null;
		try {
			userList = hibernateTemplate.loadAll(User.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
