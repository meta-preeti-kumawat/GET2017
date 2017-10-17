package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface OrderDetailsFacade {
	Status deleteProductById(int currentCartID, int productID);

	Message addProductById(int currentCartID, int productId);

	List<Product> getProductsByOrderId(int id);
}