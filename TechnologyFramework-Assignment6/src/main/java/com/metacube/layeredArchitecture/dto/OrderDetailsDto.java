package main.java.com.metacube.layeredArchitecture.dto;

import java.util.List;

public class OrderDetailsDto {
	private int orderNo;
	private float total;
	private String date;
	private List<ProductDto> products;

	public OrderDetailsDto() {

	}

	public OrderDetailsDto(int orderNo, float total, String date,
			List<ProductDto> products) {
		setOrderNo(orderNo);
		setTotal(total);
		setDate(date);
		setProducts(products);
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
}