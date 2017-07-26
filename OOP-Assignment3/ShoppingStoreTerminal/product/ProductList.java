package product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dao.DataAccessObject;


/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class holds a list of products
 *
 */
public class ProductList {
    private Map<String, Product> productMap = new HashMap<String, Product>();
    private String error;
    private String fileData;
    
    public void setFileData(String data) {
        this.fileData = data;
    }
    
    public String getFileData() {
        return this.fileData;
    }
    
    public Map<String, Product> getProductMap() {
        return this.productMap;
    }

    /**
     * this method returns complete product list
     * @param path
     * @return
     */
    public ProductList getDetails(String path){
        try{
            DataAccessObject productList = new DataAccessObject();
            ArrayList<String> dataList = new ArrayList<String>();
            String fileData = "";
            
            dataList = productList.accessFileForRead(path);
            fileData += " --------------\n| Product List |\n --------------\n";

            for (Iterator<String> iterator = dataList.iterator(); iterator.hasNext();) {
                String data = (String) iterator.next();
                Product product = new Product();
                product.splitData(data);
                this.setMap(product);
                fileData += data + "\n";
            }
            this.setFileData(fileData);
        }catch(IOException fileNotFound) {
                this.error = "File Not Found";
        }
        return this;
    }
    
    public void setMap(Product product) {
        this.productMap.put(product.getCode(), product);
    }
    
    public Product getProductByCode(String code){
        if(this.productMap.containsKey(code)){
            return this.productMap.get(code);
        }
        else{
            this.error = "No product available with given code";
        }
        return null;
    }
    
    public String getError(){
        return this.error;
    }
    
}
