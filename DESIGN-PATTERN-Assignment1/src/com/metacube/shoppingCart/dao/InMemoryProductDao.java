package com.metacube.shoppingCart.dao;

import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.model.Product;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: InMemoryProductDao
 *
 */
public class InMemoryProductDao implements ProductDao{

    private static InMemoryProductDao inMemoryProductDao = null;
    private static Map<String, Product> dataList;
    
    private InMemoryProductDao(){
         dataList = new HashMap<String, Product>();
         
         Product  product1 =  new Product();
         product1.setId("1234");
         product1.setCode("1001");
         product1.setName("Reebok");
         product1.setPrice(1050);
         dataList.put(product1.getId(), product1);
         
         Product  product2 =  new Product();
         product2.setId("192");
         product2.setCode("1002");
         product2.setName("Nike");
         product2.setPrice(2650);
         dataList.put(product2.getId(), product2);
         
         Product  product3 =  new Product();
         product3.setId("708");
         product3.setCode("1003");
         product3.setName("Puma");
         product3.setPrice(1125);
         dataList.put(product3.getId(), product3);
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryProductDao
     */
    synchronized public static InMemoryProductDao getInstance(){
        if(inMemoryProductDao == null){
            inMemoryProductDao = new InMemoryProductDao();
        }
        return inMemoryProductDao;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * getAll() method returns map
     */
    @Override
    public Map<String, Product> getAll(){
        return dataList;
    }

    /**
     * adds a new product to map
     */
    @Override
    public void create(Product entity){
        String id = generateId();
        dataList.put(id, entity);
    }

    /**
     * get product object by code
     */
    @Override
    public Product getByProductCode(String code) {
        Product product = new Product();
        for (Map.Entry<String, Product> item : dataList.entrySet()) {
            if(item.getValue().getCode().equals(code)){
                product = item.getValue();
            }
        }
        return product;
    }

    /**
     * updates a product in map
     */
    @Override
    public void update(Product entity){
        dataList.put(entity.getId(), entity); 
    }

    /**
     * removes a product from map
     */
    @Override
    public void remove(Product entity){
        dataList.remove(entity.getId()); 
    }
    
    /**
     * auto generates an id
     * @return
     */
    public String generateId() {
        int id = (int) Math.random();
        String idStr = Integer.toString(id);
        if(dataList.get(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }
}
