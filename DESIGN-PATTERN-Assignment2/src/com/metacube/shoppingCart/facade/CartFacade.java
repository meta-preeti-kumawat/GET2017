package com.metacube.shoppingCart.facade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.dao.BaseDao;
import com.metacube.shoppingCart.dao.DaoFactory;
import com.metacube.shoppingCart.dao.InMemoryCartDao;
import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.EntityName;
import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.model.Cart;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: CartFacade
 * 
 * This class stores the cart related operations
 *
 */
public class CartFacade {
    private static CartFacade cartFacade = null;
    private BaseDao<Cart> cartDao;
	private Map<String, Cart> cartList;
    
    @SuppressWarnings("unchecked")
    private CartFacade() throws IOException{
    	cartList = new HashMap<String, Cart>();
        cartDao = (BaseDao<Cart>) DaoFactory.getDaoForEntity(EntityName.CART, DBType.IN_MEMORY);    
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return ProductFacade
     * @throws IOException 
     */
    synchronized public static CartFacade getInstance() throws IOException{
        if(cartFacade == null){
            cartFacade = new CartFacade();
        }
        return cartFacade;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * This method validates whether a cart is a already available or not
     * if cart id is not available then add this new cart
     * else return DUPLICATE
     * 
     * @param cart
     * @return Status (OK, DUPLICATE, UNAVAILABLE, ...)
     * @throws IOException
     */
    public  Status storeNewCart(Cart cart) throws IOException {
        Status status = Status.OK;
        cartList = (Map<String, Cart>) cartDao.getAll();
        for (Map.Entry<String, Cart> entry : cartList.entrySet()) {
            if(entry.getKey().equals(cart.getId())){
                status = Status.DUPLICATE;
            }
        }
        if (status == Status.OK) {
            cartDao.create(cart);
        }
        return status;
    }
    
    /**
     * This method updates a cart information
     * it returns UNAVAILABLE, if cart is not already present 
     * 
     * @param cart
     * @return Status
     * @throws IOException
     */
    public  Status updateCart(Cart cart) throws IOException {
        Status status = Status.OK;
        cartList = (Map<String, Cart>) cartDao.getAll();
        for (Map.Entry<String, Cart> entry : cartList.entrySet()) {
            if(entry.getKey().equals(cart.getId())){
                status = Status.OK;
                cartDao.update(cart);
                break;
            }
            else {
                status = Status.UNAVAILABLE;
            }
        }
        return status;
    }
    
    /**
     * This method removes an already available cart
     * it returns UNAVAILABLE, if product is not present 
     * 
     * @param cart
     * @return
     * @throws IOException
     */
    public  Status removeCart(Cart cart) throws IOException {
        Status status = Status.OK;
        cartList = (Map<String, Cart>) cartDao.getAll();
        for (Map.Entry<String, Cart> entry : cartList.entrySet()) {
            if(entry.getKey().equals(cart.getId())){
                status = Status.OK;
                cartDao.remove(cart);
                break;
            }
            else {
                status = Status.UNAVAILABLE;
            }
        }
        return status;
    }
    
    public Cart getCartById(String id) {
    	return ((InMemoryCartDao) cartDao).getCart(id);
	}
    
	public String createCart() throws IOException {
		String id =((InMemoryCartDao) cartDao).generateId();
		Cart cart = new Cart();
		cart.setId(id);
		cartDao.create(cart);
		return id;
	}

	public void saveToCart(String id, String productId, int quantity) throws IOException {
		Cart cart = getCartById(id);
		if (cart.getAllProductsInCart().containsKey(productId)) {
			 cart.addProduct(productId, cart.getAllProductsInCart().get(productId) + quantity);
		}
		else{
			cart.addProduct(productId, quantity);
		}
		
		double price = cart.getTotalPrice();
		cart.setTotalPrice(price + ProductFacade.getInstance().getProductPriceByProductId(productId) * quantity);
		updateCart(cart);
	}
}
