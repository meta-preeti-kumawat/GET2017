package main.java.com.metacube.layeredArchitecture.dao.orders;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dao.BaseDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Orders;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

public interface OrdersDao extends BaseDao<Orders, Integer> {
	public List<Product> getCurrentOrderProductList(User currentUser);

	public Status placeOrder(int currentCartID);

	public float getTotalAmountOfOrder(int orderID);

	public List<Orders> getPreviousOrdersByUserName(User currentUser);
}