package com.metacube.shoppingCart.view;

import java.util.Scanner;

import com.metacube.shoppingCart.controller.CartController;
import com.metacube.shoppingCart.controller.ProductController;

public class GetInput {
	private static GetInput getInput = null;
	private static Scanner scan = new Scanner(System.in);

	synchronized public static GetInput getInstance() {
		if (getInput == null) {
			getInput = new GetInput();
		}
		return getInput;
	}

	public int getIntInput() {
		int choice;
		boolean firstTime = true;
		do {
			if (firstTime == false) {
				System.out.print("Enter Correct Number: ");
			} else {
				firstTime = false;
			}
			while (!scan.hasNextInt()) {
				System.out.print("Invalid Input! Please Re-Input: ");
				scan.next();
			}

			choice = scan.nextInt();
		} while (choice <= 0);

		return choice;
	}

	public String getOrder() {
		System.out.println("Enter Number of Products:");
		int numberOfProduct = getNumOfProductInput();
		String productId;
		int quantity;
		String id = "" ;
		for (int loop = 0; loop < numberOfProduct; loop++) {
			System.out.println("\nProduct "+ (loop+1));
			System.out.print("\tEnter Product Id: ");
			productId = getProductId();
			System.out.print("\tEnter Quantity:");
			quantity = getIntInput();
			if(loop == 0){
				id = CartController.getInstance().createCart();
				if(id.equals("Unable to create") || id == null){
					System.out.println("Some Error Occurred in cart creation");
					break;
				}
			}
			CartController.getInstance().saveToCart(id, productId, quantity);
		
		}
		return id;
	}

	private String getProductId() {
		String productId = scan.next();
		if(!ProductController.getInstance().validateProductId(productId)){
			System.out.print("Invalid Product Code... Please re-enter:");
			return getProductId();
		}
		return productId;
	}

	private int getNumOfProductInput() {
		int numberOfProduct = getIntInput();
		if(!ProductController.getInstance().validateNumberOfProducts(numberOfProduct)) {
			System.out.println("Number of products entered are greater than the number of products in our store!! Please Re-enter.");
			return getNumOfProductInput();
		}
		return numberOfProduct;
	}

}
