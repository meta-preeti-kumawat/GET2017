package main.java.com.metacube.layeredArchitecture.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.ProductService;

@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	@Autowired
	private ProductService productService;
	
	public DefaultProductFacade() {
		
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	public List<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}
	
	public ProductDto getProductById(int id) {
		return modelToDto(productService.getProductById(id));
	}

	private ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		productDto.setImageUrl(product.getImageUrl());
		return productDto;
	}
	
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImageUrl());
		return product;
	}

	public Product addProduct(Product product) {
		productService.addProduct(product);
		return new Product(product.getId(), product.getName(), product.getPrice(), product.getDescription(), product.getImageUrl());
	}

	public Status deleteProductById(int id) {
		return productService.deleteProduct(id);
	}

	public Status updateProduct(Product product, int id) {
		return productService.updateProduct(product, id);
	}
}