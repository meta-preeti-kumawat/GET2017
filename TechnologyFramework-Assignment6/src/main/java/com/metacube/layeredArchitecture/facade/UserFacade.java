package main.java.com.metacube.layeredArchitecture.facade;

import main.java.com.metacube.layeredArchitecture.dto.MiniCartDto;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserFacade {
	public User getUserByID(String id);

	public void addUser(User user);

	public User addUserIfNotExists(String id);

	public int getNumOfProductsInCart();

	public float getAmountOfCart();

	public MiniCartDto getMiniCart();

	public int getCurrentCartID(User currentUser);

	public void logout();
}