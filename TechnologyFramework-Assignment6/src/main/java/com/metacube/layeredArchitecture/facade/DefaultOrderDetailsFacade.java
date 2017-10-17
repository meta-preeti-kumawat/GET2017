package main.java.com.metacube.layeredArchitecture.facade;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.service.OrderDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderDetailsFacade")
public class DefaultOrderDetailsFacade implements OrderDetailsFacade {
	@Autowired
	private OrderDetailsService orderDetailsService;

	public DefaultOrderDetailsFacade() {

	}

	public DefaultOrderDetailsFacade(OrderDetailsService orderDetailsService) {
		setOrderDetailsService(orderDetailsService);
	}

	public OrderDetailsService getOrderDetailsService() {
		return orderDetailsService;
	}

	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}

	@Override
	public Status deleteProductById(int currentCartID, int productID) {
		return orderDetailsService.deleteProductById(currentCartID, productID);
	}

	@Override
	public Message addProductById(int currentCartID, int productId) {
		Status status = orderDetailsService.addProductById(currentCartID,
				productId);
		Message msg;
		if (status == Status.FAILURE) {
			msg = new Message("FAILURE");
		} else {
			msg = new Message("SUCCESS");
		}
		return msg;
	}

	@Override
	public List<Product> getProductsByOrderId(int id) {
		return orderDetailsService.getProductsByOrderId(id);
	}
}
