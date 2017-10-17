package main.java.com.metacube.layeredArchitecture.dao.user;

import main.java.com.metacube.layeredArchitecture.dao.BaseDao;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserDao extends BaseDao<User, String> {
	public int getNumOfProductsInCart(User user);

	public float getAmountOfCart(User user);

	public int getCurrentCartID(User currentUser);
}