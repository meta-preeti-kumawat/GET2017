package com.metacube.shoppingCart.facade;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.dao.BaseDao;
import com.metacube.shoppingCart.dao.DaoFactory;
import com.metacube.shoppingCart.enums.DBType;
import com.metacube.shoppingCart.enums.EntityName;
import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.model.Product;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: ProductFacade
 * 
 * This class stores the product related operations
 *
 */
public class ProductFacade {
    private static ProductFacade productFacade = null;
    private static Map<String, Product> productList;
    private BaseDao<Product> productDao;
    
    @SuppressWarnings("unchecked")
    private ProductFacade() throws IOException{
        productList = new HashMap<String, Product>();
        productDao = (BaseDao<Product>) DaoFactory.getDaoForEntity(EntityName.PRODUCT, DBType.FILE);    
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return ProductFacade
     * @throws IOException 
     */
    synchronized public static ProductFacade getInstance() throws IOException{
        if(productFacade == null){
            productFacade = new ProductFacade();
        }
        return productFacade;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * This method validates whether a product is a already available or not
     * if product code is not available then add this new product
     * else return DUPLICATE
     * 
     * @param product
     * @return Status (OK, DUPLICATE, UNAVAILABLE, ...)
     * @throws IOException
     */
    public  Status storeProduct(Product product) throws IOException {
        Status status = Status.OK;
        productList = (Map<String, Product>) productDao.getAll();
        for (Map.Entry<String, Product> entry : productList.entrySet()) {
            if(entry.getValue().getCode().equals(product.getCode())){
                status = Status.DUPLICATE;
            }
        }
        if (status == Status.OK) {
            productDao.create(product);
        }
        return status;
    }
    
    /**
     * This method updates a product information
     * it returns UNAVAILABLE, if product is not already present 
     * 
     * @param product
     * @return Status
     * @throws IOException
     */
    public  Status updateProduct(Product product) throws IOException {
        Status status = Status.OK;
        productList = (Map<String, Product>) productDao.getAll();
        for (Map.Entry<String, Product> entry : productList.entrySet()) {
            if(entry.getKey().equals(product.getId())){
                status = Status.OK;
                productDao.update(product);
                break;
            }
            else {
                status = Status.UNAVAILABLE;
            }
        }
        return status;
    }
    
    /**
     * This method removes an already available product
     * it returns UNAVAILABLE, if product is not present 
     * 
     * @param product
     * @return
     * @throws IOException
     */
    public  Status removeProduct(Product product) throws IOException {
        Status status = Status.OK;
        productList = (Map<String, Product>) productDao.getAll();
        for (Map.Entry<String, Product> entry : productList.entrySet()) {
            if(entry.getKey().equals(product.getId())){
                status = Status.OK;
                productDao.remove(product);
                break;
            }
            else {
                status = Status.UNAVAILABLE;
            }
        }
        return status;
    }
}
