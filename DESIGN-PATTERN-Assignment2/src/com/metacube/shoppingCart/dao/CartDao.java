package com.metacube.shoppingCart.dao;

import com.metacube.shoppingCart.model.Cart;

public interface CartDao extends BaseDao<Cart> {
    public Cart getCart(String id);
}
