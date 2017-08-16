package com.metacube.shoppingCart.controller;

import java.io.IOException;
import java.util.Map;

import com.metacube.shoppingCart.facade.CartFacade;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.model.Cart;
import com.metacube.shoppingCart.model.Product;


public class CartController {
	private static CartController cartController = null;
	private CartController(){
		
	}
	
	synchronized public static CartController getInstance() {
        if(cartController == null){
        	cartController = new CartController();
        }
        return cartController;
    }

	public String createCart() {
		String id;
		try {
			id = CartFacade.getInstance().createCart();
		} catch (IOException e) {
			return "Unable to create";
		}
		return id;
		
	}

	public void saveToCart(String id, String productId, int quantity) {
		try {
			CartFacade.getInstance().saveToCart(id, productId, quantity);
		} catch (IOException e) {
			
		}
		
	}

	public String showCart(String cartId) {
		String cartString = "";
		try {
			Cart cart = CartFacade.getInstance().getCartById(cartId);
			Product product;
			Map<String, Integer> cartEntries = cart.getAllProductsInCart();
			for (Map.Entry<String, Integer> entry : cartEntries.entrySet()) {
				product = ProductFacade.getInstance().getProductById(entry.getKey());
				cartString += product.getId() + "\t\t" + product.getCode() + "\t\t" 
								+ product.getName() + "\t\t" + product.getPrice() + "\t\t" 
						        + entry.getValue() + "\t\tRs. " + product.getPrice() * entry.getValue() + "\n";
				
	        }
		} catch (IOException e) {
			return "Unable to show cart";
		}
		return cartString;
	}

	public double showTotalPrice(String cartId) {
		try {
			return CartFacade.getInstance().getCartById(cartId).getTotalPrice();
		} catch (IOException e) {
			return 0;
		}
	}

	
	
	
}
