package com.metacube.shoppingCart;

import com.metacube.shoppingCart.view.DisplayOutput;
import com.metacube.shoppingCart.view.GetInput;

public class ShoppingCart {
	public static void main(String[] args) {
		DisplayOutput.getInstance().showProductList();
		String cartId = GetInput.getInstance().getOrder();
		DisplayOutput.getInstance().showCart(cartId);
	}
}
