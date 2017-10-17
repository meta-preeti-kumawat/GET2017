package main.java.com.metacube.layeredArchitecture.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import main.java.com.metacube.layeredArchitecture.dao.orderDetails.OrderDetailsDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Product;

import org.springframework.stereotype.Component;

@Component("OrderDetailsService")
@Transactional
public class DefaultOrderDetailsService implements OrderDetailsService {

	@Resource(name = "hibernateOrderDetailsDao")
	private OrderDetailsDao orderDetailsDao;

	public DefaultOrderDetailsService() {
	}

	public DefaultOrderDetailsService(OrderDetailsDao orderDetailsDao) {
		setOrderDetailsDao(orderDetailsDao);
	}

	public OrderDetailsDao getOrderDetailsDao() {
		return orderDetailsDao;
	}

	public void setOrderDetailsDao(OrderDetailsDao orderDetailsDao) {
		this.orderDetailsDao = orderDetailsDao;
	}

	@Override
	public Status deleteProductById(int currentCartID, int productID) {
		return orderDetailsDao.deleteProductFromCart(currentCartID, productID);
	}

	@Override
	public Status addProductById(int currentCartID, int productId) {
		return orderDetailsDao.addProductById(currentCartID, productId);
	}

	@Override
	public List<Product> getProductsByOrderId(int id) {
		return orderDetailsDao.getAllByOrderId(id);
	}
}