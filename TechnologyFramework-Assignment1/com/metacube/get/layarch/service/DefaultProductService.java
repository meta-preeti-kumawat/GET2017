package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * Describe the service class to get products;
 */
public class DefaultProductService implements ProductService
{
     ProductDao productDao;

    public DefaultProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override public Iterable<Product> getAllProducts()
    {
        return productDao.findAll();
    }

    @Override public Product getProductById(final int id)
    {
        return productDao.findOne(id);
    }

    @Override
    public Status addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Status deleteProductById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public Status editProduct(Product product, int id) {
        return productDao.edit(product, id);
    }
}
