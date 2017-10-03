package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dao.product.ProductDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

@Component("productService")
public class DefaultProductService implements ProductService {
	@Autowired
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	public List<Product> getAllProducts() {
		return productDao.getAll();
	}

	public Product getProductById(int id) {
		return productDao.getById(id);
	}
	
	public Status addProduct(Product product) {
		return productDao.create(product);
	}
	
	public Status deleteProduct(int id) {
		return productDao.deleteById(id);
	}
	
	public Status updateProduct(Product product, int id) {
		return productDao.update(product, id);
	}	
}