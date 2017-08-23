package com.metacube.shoppingCart.view;

import com.metacube.shoppingCart.controller.CartController;
import com.metacube.shoppingCart.controller.ProductController;

public class DisplayOutput {
	private static DisplayOutput displayOutput = null;
	
	synchronized public static DisplayOutput getInstance() {
		 if(displayOutput == null){
			 displayOutput = new DisplayOutput();
	        }
	        return displayOutput;
	}

	public void showProductList() {
		System.out.println("----------------");
		System.out.println("  PRODUCT LIST  ");
		System.out.println("----------------");
		System.out.println("Product Id \tProduct Code \tProduct Name \tProduct Price");
		System.out.println(ProductController.getInstance().showProductList());
	}

	public void showCart(String cartId) {
		System.out.println("-------------------");
		System.out.println(" YOUR CART IS HERE: ");
		System.out.println("-------------------");
		System.out.println("Product Id \tProduct Code \tProduct Name \tProduct Price \tQuantity \tTotal Product Cost");
		System.out.println(CartController.getInstance().showCart(cartId));
		System.out.println("Total Bill Amount: Rs. " + CartController.getInstance().showTotalPrice(cartId));
	}
}
