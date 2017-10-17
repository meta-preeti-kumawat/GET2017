package main.java.com.metacube.layeredArchitecture.service;

import main.java.com.metacube.layeredArchitecture.model.User;

public interface UserService {
	public User getUserByID(String id);

	public String addUser(User user);

	public User getCurrentUser();

	public void setCurrentUser(User user);

	public int getNumOfProductsInCart();

	public float getAmountOfCart();

	public int getCurrentCartID(User currentUser);
}