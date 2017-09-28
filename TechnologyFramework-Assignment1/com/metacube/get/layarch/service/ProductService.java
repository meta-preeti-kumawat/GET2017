package com.metacube.get.layarch.service;

import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * Product service is an inheritance class
 */
public interface ProductService
{
    Iterable<Product> getAllProducts();
    Product getProductById(int id);
    Status addProduct(Product entity);
    Status deleteProductById(int id);
    Status editProduct(Product entity, int id);
}
