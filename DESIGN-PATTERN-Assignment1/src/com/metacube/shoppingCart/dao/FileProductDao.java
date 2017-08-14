package com.metacube.shoppingCart.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.metacube.shoppingCart.constants.Constants;
import com.metacube.shoppingCart.model.Product;

/**
 * 
 * @author Preeti Kumawat
 * Class Name: FileProductDao
 *
 */
public class FileProductDao implements ProductDao{

    private static String filePath;
    private static FileProductDao fileProductDao = null;
    private static FileInputStream dataFile;
    private static BufferedReader readDataLine;
    private static String inputText = new String();
    private static Map<String, Product> dataList;
    private static BufferedWriter writer;
    private static PrintWriter printWriter;
    
    private FileProductDao() throws IOException{
        filePath = Constants.PRODUCT_FILE_PATH;
        
        // Create file if not available
        File file = new File(filePath);
        if(!file.exists()){
            file.createNewFile();
        }
        
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryProductDao
     * @throws IOException
     */
    synchronized public static FileProductDao getInstance() throws IOException{
        if(fileProductDao == null){            
            fileProductDao = new FileProductDao();
        }
        return fileProductDao;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * getAll() method will return a map containing all products from file
     * @throws IOException 
     */
    @Override
    public Map<String, Product> getAll() throws IOException{
        dataList = new HashMap<String, Product>();
        dataFile = new FileInputStream(filePath);
        readDataLine = new BufferedReader(new InputStreamReader(dataFile));
        inputText = readDataLine.readLine();    
        
        while(inputText != null){
            if(inputText != ""){
                Product product = new Product();
                String[] data = inputText.split(",");
                if(data.length == 4){
                    product.setId(data[0].trim());
                    product.setCode(data[1].trim());
                    product.setName(data[2].trim());
                    product.setPrice(Float.parseFloat(data[3].trim()));
                    dataList.put(product.getId(), product); 
                }
            }
           inputText = readDataLine.readLine();  
        }
        readDataLine.close();
        return dataList;
    }
    
    /**
     * write all data to file
     * @throws IOException 
     */
    public void writeAll() throws IOException{
        writer = new BufferedWriter(new FileWriter(new File(filePath)));
        printWriter = new PrintWriter(writer);
        Product product = new Product();
        String id = "";
        for (Map.Entry<String, Product> item : dataList.entrySet()) {
            id = item.getKey();
            product = item.getValue();
            String productInfo = id + "," + product.getCode() + "," + product.getName() + "," + product.getPrice();
            printWriter.println(productInfo);
        }
        writer.close();
    }

    /**
     * create a new product
     * @throws IOException 
     */
    @Override
    public void create(Product entity) throws IOException{
        writer = new BufferedWriter(new FileWriter(new File(filePath), true));
        printWriter = new PrintWriter(writer);
        String id = generateId();
        String productInfo = id + "," + entity.getCode() + "," + entity.getName() + "," + entity.getPrice();
        printWriter.println(productInfo);
        writer.close();
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
     * updates a product object stored in map
     * @throws IOException 
     */
    @Override
    public void update(Product entity) throws IOException{
        dataList.put(entity.getId(), entity); 
        writeAll();
    }

    /**
     * remove a product from map
     * @throws IOException 
     */
    @Override
    public void remove(Product entity) throws IOException{
        dataList.remove(entity.getId()); 
        writeAll();
    }
    
    /**
     * generates a random id for each product
     * @return string
     */
    public String generateId() {
        int id = (int) (Math.random()*10000);
        String idStr = Integer.toString(id);
        if(dataList.get(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }
}
