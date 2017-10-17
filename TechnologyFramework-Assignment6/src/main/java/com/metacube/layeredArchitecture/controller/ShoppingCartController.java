/**
 * The class ShoppingCartController is a controller of shopping cart application. 
 * It provides various restful services.
 */
package main.java.com.metacube.layeredArchitecture.controller;

import java.util.List;

import main.java.com.metacube.layeredArchitecture.dto.Message;
import main.java.com.metacube.layeredArchitecture.dto.MiniCartDto;
import main.java.com.metacube.layeredArchitecture.dto.OrderDetailsDto;
import main.java.com.metacube.layeredArchitecture.dto.OrdersDto;
import main.java.com.metacube.layeredArchitecture.dto.ProductDto;
import main.java.com.metacube.layeredArchitecture.enums.Status;
import main.java.com.metacube.layeredArchitecture.facade.OrderDetailsFacade;
import main.java.com.metacube.layeredArchitecture.facade.OrdersFacade;
import main.java.com.metacube.layeredArchitecture.facade.ProductFacade;
import main.java.com.metacube.layeredArchitecture.facade.UserFacade;
import main.java.com.metacube.layeredArchitecture.model.Product;
import main.java.com.metacube.layeredArchitecture.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/service")
public class ShoppingCartController {
	@Autowired
	ProductFacade productFacade;

	@Autowired
	UserFacade userFacade;

	@Autowired
	OrdersFacade ordersFacade;

	@Autowired
	OrderDetailsFacade orderDetailsFacade;

	User currentUser;

	/**
	 * This method returns list of all products.
	 * 
	 * @return List of ProductDto
	 */
	@RequestMapping(value = "/product/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * This method return product by its product id.
	 * 
	 * @param id
	 * @return ProductDto
	 */
	@RequestMapping(value = "/product/{productId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProductById(
			@PathVariable("productId") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * This method creates a new product.
	 * 
	 * @param product
	 *            - Product
	 * @return Product
	 */
	@RequestMapping(value = "/product/addProduct", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public @ResponseBody Product createProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}

	/**
	 * This method deletes a product using its product id.
	 * 
	 * @param id
	 * @return Status(FAILURE, SUCCESS)
	 */
	@RequestMapping(value = "/product/deleteProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id) {
		return productFacade.deleteProductById(id);
	}

	/**
	 * This method edits the product
	 * 
	 * @param product
	 * @param id
	 * @return Status(FAILURE, SUCCESS)
	 */
	@RequestMapping(value = "/product/updateProduct/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.PUT)
	public @ResponseBody Status editProduct(@RequestBody Product product,
			@PathVariable("id") int id) {
		return productFacade.updateProduct(product, id);
	}

	/**
	 * This method adds the user in database if not exists.
	 * 
	 * @param mailid
	 * @return User
	 */
	@RequestMapping(value = "/user/login", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody User logInUser(@RequestParam("mailid") String mailid) {
		currentUser = userFacade.addUserIfNotExists(mailid);
		return currentUser;
	}

	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public void logoutUser() {
		currentUser = null;
		userFacade.logout();
	}

	/**
	 * This method returns the details of cart of the current user.
	 * 
	 * @return MiniCartDto
	 */
	@RequestMapping(value = "/minicart", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody MiniCartDto getMiniCart() {
		return userFacade.getMiniCart();
	}

	/**
	 * This method returns the list of all products of the cart.
	 * 
	 * @return List of Product
	 */
	@RequestMapping(value = "/cart", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProductsOfCart() {
		return ordersFacade.getProductsOfCart(currentUser);
	}

	/**
	 * This method deletes the product by using its product id.
	 * 
	 * @param productId
	 * @return Status(FAILURE, SUCCESS)
	 */
	@RequestMapping(value = "/cart/removeProduct/{id}", produces = "application/json", method = RequestMethod.DELETE)
	public @ResponseBody Status deleteProductFromCart(
			@PathVariable("id") int productId) {
		int currentCartID = userFacade.getCurrentCartID(currentUser);
		return orderDetailsFacade.deleteProductById(currentCartID, productId);
	}

	/**
	 * This method add the product in the cart.
	 * 
	 * @param productId
	 * @return Message
	 */
	@RequestMapping(value = "/cart/addProduct/{id}", method = RequestMethod.POST)
	public @ResponseBody Message addProductToCart(
			@PathVariable("id") int productId) {
		int currentCartID = userFacade.getCurrentCartID(currentUser);
		if (currentCartID == 0) {
			currentCartID = ordersFacade.createNewOrder(currentUser);
			System.out.println("orderID: " + currentCartID);
		}
		return orderDetailsFacade.addProductById(currentCartID, productId);
	}

	/**
	 * This method places the order.
	 * 
	 * @return Status(FAILURE, SUCCESS)
	 */
	@RequestMapping(value = "/cart/placeOrder", method = RequestMethod.GET)
	public @ResponseBody Status placeProduct() {
		int currentCartID = userFacade.getCurrentCartID(currentUser);
		return ordersFacade.placeOrder(currentCartID);
	}

	/**
	 * This method return the previous orders list.
	 * 
	 * @return List of OrdersDto
	 */
	@RequestMapping(value = "/previousOrders/list", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<OrdersDto> getPreviousOrders() {
		return ordersFacade.getAllPreviousOrders(currentUser);
	}

	/**
	 * This method returns order details using order id.
	 * 
	 * @param id
	 * @return OrderDetailsDao
	 */
	@RequestMapping(value = "/orderDetails/{orderId}", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody OrderDetailsDto getOrderById(
			@PathVariable("orderId") int id) {
		return ordersFacade.getOrderDetailsById(orderDetailsFacade, id);
	}
}