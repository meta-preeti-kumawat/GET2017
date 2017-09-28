package com.metacube.get.layarch.facade;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * Product Facade layer class
 */
public interface ProductFacade
{
    Iterable<ProductDto> getAllProducts();
    ProductDto getProductById(int id);
    Status addProduct(Product entity);
    Status deleteProductById(int id);
    Status editProduct(Product entity,int id);
}
