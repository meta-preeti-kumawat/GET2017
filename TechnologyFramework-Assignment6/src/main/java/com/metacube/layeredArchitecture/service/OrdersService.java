package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Orders;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface OrdersService {

	List<Product> getProductsOfCart(User currentUser);

	int createNewOrder(User currentUser);

	Status placeOrder(int currentCartID);

	List<Orders> getAllPreviousOrders(User currentUser);

	float getAmountOfOrder(int orderId);

	Orders getOrderById(int id);
}
