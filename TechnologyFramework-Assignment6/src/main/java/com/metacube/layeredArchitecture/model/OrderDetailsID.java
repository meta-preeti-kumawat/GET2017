package main.java.com.metacube.layeredArchitecture.model;

import java.io.Serializable;

public class OrderDetailsID implements Serializable, BaseModel {
	private static final long serialVersionUID = 1L;
	private int orderId;
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}