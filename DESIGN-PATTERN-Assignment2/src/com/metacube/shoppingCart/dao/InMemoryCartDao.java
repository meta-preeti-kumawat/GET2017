package com.metacube.shoppingCart.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.model.Cart;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: InMemoryCartDao
 *
 */
public class InMemoryCartDao implements CartDao{

    private static InMemoryCartDao inMemoryCartDao = null;
    private Map<String, Cart> cartList;
    
    private InMemoryCartDao(){
    	cartList = new HashMap<String, Cart>();
        
    	Cart cart1 = new Cart();
    	cart1.setId("C101");
    	cart1.addProduct("P1234", 3);
    	
    	cartList.put(cart1.getId(), cart1);
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryCartDao
     */
    synchronized public static InMemoryCartDao getInstance(){
        if(inMemoryCartDao == null){
            inMemoryCartDao = new InMemoryCartDao();
        }
        return inMemoryCartDao;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

	@Override
	public Map<String, Cart> getAll(){
		return cartList;
	}

	
	@Override
	public void create(Cart entity){
		cartList.put(entity.getId(), entity);
	}

	@Override
	public void update(Cart entity) throws IOException {
		cartList.put(entity.getId(), entity);
	}

	@Override
	public void remove(Cart entity) throws IOException {
		 cartList.remove(entity.getId()); 
	}

	@Override
	public Cart getCart(String id) {
		Cart cart = new Cart();
		for (Map.Entry<String, Cart> item : cartList.entrySet()) {
			if(item.getKey().equals(id)){
				cart = item.getValue();
			}
        }
		return cart;
	}
	
	/**
     * auto generates an id
     * @return
     */
    public String generateId() {
        int id = (int) Math.random();
        String idStr = "C" + Integer.toString(id);
        if(cartList.get(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }
}
