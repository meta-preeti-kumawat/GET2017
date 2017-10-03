package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product getProductById(int id);
	Status addProduct(Product product);
	Status deleteProduct(int id);
	Status updateProduct(Product product, int id);
}