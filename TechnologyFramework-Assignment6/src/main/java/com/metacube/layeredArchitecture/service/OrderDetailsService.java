package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface OrderDetailsService {
	Status deleteProductById(int currentCartID, int productID);

	Status addProductById(int currentCartID, int productId);

	List<Product> getProductsByOrderId(int id);
}