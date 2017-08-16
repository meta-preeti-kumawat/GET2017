package com.metacube.shoppingCart.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: Cart
 * 
 * This class stores information about a cart
 *
 */
public class Cart extends BaseEntity {
	private Map<String, Integer> allProductsInCart = new HashMap<String, Integer>();
	private double totalPrice = 0;
	
	public Map<String, Integer> getAllProductsInCart() {
		return allProductsInCart;
	}
	public void setAllProductsInCart(Map<String, Integer> productQuantity) {
		this.allProductsInCart = productQuantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void addProduct(String productId, int quantity){
		allProductsInCart.put(productId, quantity);
	}
}
