package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.OrderDetailsDto;
import main.java.com.metacube.layeredArchitecture.dto.OrdersDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface OrdersFacade {
	List<Product> getProductsOfCart(User currentUser);

	int createNewOrder(User currentUser);

	Status placeOrder(int currentCartID);

	List<OrdersDto> getAllPreviousOrders(User currentUser);

	OrderDetailsDto getOrderDetailsById(OrderDetailsFacade orderDetailsFacade,
			int id);
}