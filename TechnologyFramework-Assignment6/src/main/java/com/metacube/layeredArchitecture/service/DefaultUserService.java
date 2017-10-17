package main.java.com.metacube.layeredArchitecture.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import main.java.com.metacube.layeredArchitecture.dao.user.UserDao;
import main.java.com.metacube.layeredArchitecture.model.User;

import org.springframework.stereotype.Component;

@Component("userService")
@Transactional
public class DefaultUserService implements UserService {

	@Resource(name = "hibernateUserDao")
	private UserDao userDao;
	private User currentUser;

	public DefaultUserService() {
	}

	public DefaultUserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByID(String id) {
		return userDao.getById(id);
	}

	@Override
	public String addUser(User user) {
		return userDao.create(user);
	}

	@Override
	public User getCurrentUser() {
		return currentUser;
	}

	@Override
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public int getNumOfProductsInCart() {
		if (currentUser != null) {
			return userDao.getNumOfProductsInCart(currentUser);
		} else {
			return 0;
		}
	}

	@Override
	public float getAmountOfCart() {
		if (currentUser != null) {
			return userDao.getAmountOfCart(currentUser);
		} else {
			return 0;
		}
	}

	@Override
	public int getCurrentCartID(User currentUser) {
		return userDao.getCurrentCartID(currentUser);
	}
}