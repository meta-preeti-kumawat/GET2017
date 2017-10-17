package main.java.com.metacube.layeredArchitecture.dto;

public class MiniCartDto {
	private int numOfProducts;
	private float amount;

	public MiniCartDto() {
	}

	public MiniCartDto(int numOfProducts, float amount) {
		setNumOfProducts(numOfProducts);
		setAmount(amount);
	}

	public int getNumOfProducts() {
		return numOfProducts;
	}

	public void setNumOfProducts(int numOfProducts) {
		this.numOfProducts = numOfProducts;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}