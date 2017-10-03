package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

public interface ProductFacade {
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	Status addProduct(Product product);
	Status deleteProductById(int id);
	Status updateProduct(Product product, int id);
}