package com.metacube.get.layarch.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.ProductService;

/**
 * product facade class to get and post data to server
 */
public class DefaultProductFacade implements ProductFacade
{
    ProductService productService;

    /**
     * Constructor to initialize the productList
     * @param productService
     */
    public DefaultProductFacade(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method is used to retrieve all products
     */
    @Override public Iterable<ProductDto> getAllProducts()
    {
        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productService.getAllProducts()) {
            productDtoList.add(modelToDto(product));
        }

        return productDtoList;
    }

    /**
     * Method is used to retrieve product by its id
     */
    @Override public ProductDto getProductById(final int id)
    {
        return modelToDto(productService.getProductById(id));
    }

    /**
     * Method is used to convert the dto object for mobile 
     * @param productDto
     * @return
     */
    protected Product dtoToModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return product;
    }

    /**
     * Method is used to convert data to dto object 
     * @param productDto
     * @return
     */
    protected ProductDto modelToDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    /**
     * Method to delete the product
     */
    @Override
    public Status deleteProductById(int id) {
        return productService.deleteProductById(id);
    }
    
    /**
     * Method to add the product
     */
    @Override
    public Status addProduct(Product product) {
        return productService.addProduct(product);
    }
    
    /**
     * Method to edit the product
     */
    @Override
    public Status editProduct(Product product,int id) {
        return productService.editProduct(product,id);
    }
}
