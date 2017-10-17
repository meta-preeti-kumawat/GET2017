package main.java.com.metacube.layeredArchitecture.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.OrderDetailsDto;
import main.java.com.metacube.layeredArchitecture.dto.OrdersDto;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.model.Orders;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;
import main.java.com.metacube.layeredArchitecture.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ordersFacade")
public class DefaultOrdersFacade implements OrdersFacade {
	@Autowired
	private OrdersService ordersService;

	public DefaultOrdersFacade() {

	}

	public DefaultOrdersFacade(OrdersService ordersService) {
		setOrdersService(ordersService);
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	@Override
	public List<Product> getProductsOfCart(User currentUser) {
		return ordersService.getProductsOfCart(currentUser);
	}

	@Override
	public int createNewOrder(User currentUser) {
		return ordersService.createNewOrder(currentUser);
	}

	@Override
	public Status placeOrder(int currentCartID) {
		return ordersService.placeOrder(currentCartID);
	}

	@Override
	public List<OrdersDto> getAllPreviousOrders(User currentUser) {
		List<Orders> orders = ordersService.getAllPreviousOrders(currentUser);
		List<OrdersDto> ordersDtoList = new ArrayList<>();
		Iterator<Orders> iter = orders.iterator();
		OrdersDto ordersDto;
		while (iter.hasNext()) {
			Orders order = iter.next();
			ordersDto = new OrdersDto();
			ordersDto.setOrderNo(order.getOrderId());
			ordersDto.setTotal(ordersService.getAmountOfOrder(order
					.getOrderId()));
			Date date = new Date();
			date.setTime(order.getOrderDate().getTime());
			String formattedDate = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss")
					.format(date);
			ordersDto.setDate(formattedDate);
			ordersDtoList.add(ordersDto);
		}
		return ordersDtoList;
	}

	private ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}

		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setDescription(product.getDescription());
		productDto.setImageUrl(product.getImageUrl());
		return productDto;
	}

	@Override
	public OrderDetailsDto getOrderDetailsById(
			OrderDetailsFacade orderDetailsFacade, int id) {
		Orders order = ordersService.getOrderById(id);
		List<Product> products = orderDetailsFacade.getProductsByOrderId(id);
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : products) {
			productDtoList.add(modelToDto(product));
		}

		OrderDetailsDto orderDetails = new OrderDetailsDto();
		orderDetails.setOrderNo(id);
		Date date = new Date();
		date.setTime(order.getOrderDate().getTime());
		String formattedDate = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss")
				.format(date);
		orderDetails.setDate(formattedDate);
		orderDetails
				.setTotal(ordersService.getAmountOfOrder(order.getOrderId()));
		orderDetails.setProducts(productDtoList);
		return orderDetails;
	}
}