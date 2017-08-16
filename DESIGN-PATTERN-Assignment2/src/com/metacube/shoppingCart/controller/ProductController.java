package com.metacube.shoppingCart.controller;

import java.io.IOException;
import java.util.Map;

import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.model.Product;


public class ProductController {
	private static ProductController productController = null;
	
	synchronized public static ProductController getInstance() {
        if(productController == null){
        	productController = new ProductController();
        }
        return productController;
    }

	public String showProductList() {
		String productString = ""; 
		try {
			Map<String, Product> productList = ProductFacade.getInstance().getAllProducts();
			
			for (Map.Entry<String, Product> entry : productList.entrySet()) {
	            productString += entry.getKey() + "\t\t" + entry.getValue().getCode() + "\t\t" + 
	            						entry.getValue().getName() + "\t\t" + entry.getValue().getPrice() + "\n"; 
	        }
		} catch (IOException e) {
			productString = "Sorry ! Some Error Occurred..!!!";
		}
		 return productString;	
	}

	public boolean validateNumberOfProducts(int numberOfProduct) {
		try {
			if(numberOfProduct > ProductFacade.getInstance().getAllProducts().size() ){
				return false;
			}
		} catch (IOException e) {
			return false;
		}
		return true;
		
	}

	public boolean validateProductId(String productId) {
		try {
			if(ProductFacade.getInstance().getAllProducts().containsKey(productId)){
				return true;
			}
        } catch (IOException e) {
			return false;
		}
		return false;
		
	}
	
	
}
