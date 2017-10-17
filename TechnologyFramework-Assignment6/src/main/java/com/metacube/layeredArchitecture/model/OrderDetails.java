package main.java.com.metacube.layeredArchitecture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OrderDetailsID.class)
@Table(name = "order_details")
public class OrderDetails implements BaseModel {

	@Id
	@Column(name = "order_id")
	private int orderId;

	@Id
	@Column(name = "product_id")
	private int productId;

	public OrderDetails() {
	}

	public OrderDetails(int orderId, int productId) {
		setOrderId(orderId);
		setProductId(productId);
	}

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

	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (!(object instanceof OrderDetails)) {
			return false;
		}
		return ((getOrderId() == ((OrderDetails) object).getOrderId()) && (getProductId() == ((OrderDetails) object)
				.getProductId()));
	}
}