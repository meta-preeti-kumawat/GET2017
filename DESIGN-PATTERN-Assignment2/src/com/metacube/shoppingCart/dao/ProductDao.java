package com.metacube.shoppingCart.dao;

import com.metacube.shoppingCart.model.Product;

public interface ProductDao extends BaseDao<Product> {

    public Product getByProductCode(String code);

}
