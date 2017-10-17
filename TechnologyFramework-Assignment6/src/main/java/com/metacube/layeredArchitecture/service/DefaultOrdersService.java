package main.java.com.metacube.layeredArchitecture.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import main.java.com.metacube.layeredArchitecture.dao.orders.OrdersDao;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Orders;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

import org.springframework.stereotype.Component;

@Component("ordersService")
@Transactional
public class DefaultOrdersService implements OrdersService {

	@Resource(name = "hibernateOrdersDao")
	private OrdersDao ordersDao;

	@Override
	public List<Product> getProductsOfCart(User currentUser) {
		return ordersDao.getCurrentOrderProductList(currentUser);
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public int createNewOrder(User currentUser) {
		return ordersDao.create(new Orders(currentUser.getEmail(),
				new Timestamp(new Date().getTime()), "C"));
	}

	@Override
	public Status placeOrder(int currentCartID) {
		return ordersDao.placeOrder(currentCartID);
	}

	@Override
	public List<Orders> getAllPreviousOrders(User currentUser) {
		return ordersDao.getPreviousOrdersByUserName(currentUser);
	}

	@Override
	public float getAmountOfOrder(int orderId) {
		return ordersDao.getTotalAmountOfOrder(orderId);
	}

	@Override
	public Orders getOrderById(int id) {
		return ordersDao.getById(id);
	}
}