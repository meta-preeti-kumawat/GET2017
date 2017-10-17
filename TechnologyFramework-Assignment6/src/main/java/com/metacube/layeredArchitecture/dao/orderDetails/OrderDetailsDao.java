package main.java.com.metacube.layeredArchitecture.dao.orderDetails;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dao.BaseDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.OrderDetails;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface OrderDetailsDao extends BaseDao<OrderDetails, Integer> {
	Status deleteProductFromCart(int currentCartID, int productID);

	Status addProductById(int currentCartID, int productId);

	List<Product> getAllByOrderId(int id);
}