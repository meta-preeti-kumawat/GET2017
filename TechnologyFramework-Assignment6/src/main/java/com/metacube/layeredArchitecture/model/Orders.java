package main.java.com.metacube.layeredArchitecture.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements BaseModel {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(name = "user_mail_id", nullable = false)
	private String userMailId;

	@Column(name = "order_date", nullable = false)
	private Timestamp orderDate;

	@Column(name = "status", nullable = false)
	private String status;

	public Orders() {
	}

	public Orders(int orderId, String userMailId, Timestamp orderDate,
			String status) {
		setUserMailId(userMailId);
		setStatus(status);
		setOrderId(orderId);
		setOrderDate(orderDate);
	}

	public Orders(String userMailId, Timestamp orderDate, String status) {
		setUserMailId(userMailId);
		setStatus(status);
		setOrderDate(orderDate);
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String user_mail_id) {
		this.userMailId = user_mail_id;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}