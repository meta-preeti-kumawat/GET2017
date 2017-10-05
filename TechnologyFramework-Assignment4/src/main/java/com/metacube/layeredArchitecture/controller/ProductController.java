package main.java.com.metacube.layeredArchitecture.controller;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/service/product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;

	@RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}
	
	@RequestMapping(value = "/{productId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProductById(@PathVariable("productId") int id) {
		return productFacade.getProductById(id);
	}
	
	@RequestMapping(value = "/addProduct", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	
	@RequestMapping(value = "/deleteProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
		return productFacade.deleteProductById(id);
	}
	
	@RequestMapping(value = "/updateProduct/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product, @PathVariable("id") int id) {
		return productFacade.updateProduct(product, id);
	}
}