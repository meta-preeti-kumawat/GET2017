package main.java.com.metacube.layeredArchitecture.facade;

import main.java.com.metacube.layeredArchitecture.dto.MiniCartDto;
import main.java.com.metacube.layeredArchitecture.model.User;
import main.java.com.metacube.layeredArchitecture.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	@Autowired
	private UserService userService;

	public DefaultUserFacade() {
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getUserByID(String id) {
		return userService.getUserByID(id);
	}

	@Override
	public void addUser(User user) {
		userService.addUser(user);
	}

	@Override
	public User addUserIfNotExists(String id) {
		User user = getUserByID(id);
		if (user == null) {
			String idParts[] = id.split("@");
			user = new User(id, idParts[0]);
			addUser(user);
		}
		userService.setCurrentUser(user);
		System.out.println("set: " + userService.getCurrentUser().getEmail());
		return user;
	}

	@Override
	public int getNumOfProductsInCart() {
		return userService.getNumOfProductsInCart();
	}

	@Override
	public float getAmountOfCart() {
		return userService.getAmountOfCart();
	}

	@Override
	public MiniCartDto getMiniCart() {
		System.out.println("minicart " + userService.getCurrentUser());
		return new MiniCartDto(getNumOfProductsInCart(), getAmountOfCart());
	}

	@Override
	public int getCurrentCartID(User currentUser) {
		return userService.getCurrentCartID(currentUser);
	}

	@Override
	public void logout() {
		userService.setCurrentUser(null);
	}
}