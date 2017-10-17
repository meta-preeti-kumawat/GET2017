package main.java.com.metacube.layeredArchitecture.dto;

public class OrdersDto {
	private int orderNo;
	private String date;
	private float total;

	public OrdersDto() {

	}

	public OrdersDto(int orderNo, String date, float total) {
		setOrderNo(orderNo);
		setDate(date);
		setTotal(total);
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}