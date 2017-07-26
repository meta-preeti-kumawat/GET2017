package promotions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import dao.DataAccessObject;
import order.OrderEntry;
import product.Product;
import product.ProductList;
import utility.OrderUtil;

/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * this class hods information about product level promotions
 */
public class ProductPromotion {
    private ArrayList<Product> listOfProductsWithPromotion = new ArrayList<Product>();
    private String type;
    private float discount;
    private String fileData;
    private String error;

    public String getError(){
        return this.error;
    }
    
    public String getFileData() {
        return this.fileData;
    }

    public ArrayList<Product> getListOfProductsWithPromotion() {
        return listOfProductsWithPromotion;
    }

    public ArrayList<Product> getProduct() {
        return listOfProductsWithPromotion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public ProductPromotion splitData(String data,
            ProductList productList) {
        if (data.indexOf(',') != -1) {
            String[] productPromotionData = data.split(",");
            if (productPromotionData.length == 3) {
                this.setType(productPromotionData[0]);
                this.setDiscount(Float.parseFloat(productPromotionData[1]));
                this.setListOfProductsWithPromotion(productPromotionData[2],
                        productList);
            }
        }
        return this;
    }
    /**
     * set list of products connected with a promotion
     * @param listOfProductsWithPromotion
     * @param productList
     */
    public void setListOfProductsWithPromotion(
            String listOfProductsWithPromotion, ProductList productList) {
        String[] listOdProductCodes = listOfProductsWithPromotion.split(";");
        for (int i = 0; i < listOdProductCodes.length; i++) {
            String string = listOdProductCodes[i];
            Map<String, Product> productMap = productList.getProductMap();
            if (productMap.containsKey(string)) {
                this.listOfProductsWithPromotion.add(productMap.get(string));
            }
        }
    }
    
    /**
     * used to fetch details 
     * @param path
     * @param productMap
     * @return ArrayList<ProductPromotion>
     */
    public ArrayList<ProductPromotion> getDetails(String path, ProductList productMap){
        ArrayList<ProductPromotion> productPromotionsList = new ArrayList<ProductPromotion>();
        
        try{
            DataAccessObject productList = new DataAccessObject();
            ArrayList<String> dataList = new ArrayList<String>();
            String fileData = "";
            
            dataList = productList.accessFileForRead(path);
            fileData += " --------------------\n| Product Promotions |\n --------------------\n";

            for (Iterator<String> iterator = dataList.iterator(); iterator.hasNext();) {
                String data = (String) iterator.next();
                ProductPromotion productPromotion = new ProductPromotion();
                productPromotion.splitData(data, productMap);
                productPromotionsList.add(productPromotion);
                fileData += data + "\n";
            }
            this.setFileData(fileData);
        }catch(IOException fileNotFound) {
                this.error = "File Not Found";
        }
        return productPromotionsList;
    }

    private void setFileData(String fileData) {
        this.fileData = fileData;
    }

    /**
     * used to find applicable product promotions
     * @param orderEntry
     * @param productPromotionsList
     * @return
     */
    public static String applicableProductPromotions(OrderEntry orderEntry, ArrayList<ProductPromotion> productPromotionsList) {
        float discount = 0;
        boolean check;
        String data = "";
        String fixedPercent = "ProductFixedPercentPromotion";
        for (ProductPromotion productPromotion : productPromotionsList) {
            
            if (!productPromotion.getProduct().isEmpty()) {
                check = fixedPercent.equalsIgnoreCase(productPromotion.getType());
                int number = 0;
                for (Product product : productPromotion.getProduct()) {
                    if(orderEntry.getDetails().getCode().equals(product.getCode())){
                        if (check) {
                            data += "Promotion :  "+ (int) productPromotion.getDiscount() + "% off on ";
                        } else{
                            data += "Promotion :  Rs."+ productPromotion.getDiscount() + " off on ";
                        }
                        if(number == 0){
                            data += product.getName() + " [Code:"+ product.getCode() + "] ";
                            number = 1;
                        }
                        else{
                            data += ", "+ product.getName() + " [Code:"+ product.getCode() + "] ";
                        }
                        
                        if (check) {
                            discount = (productPromotion.getDiscount() / 100) * product.getCost() * orderEntry.getQuantity();
                            
                        } else {
                            discount = productPromotion.getDiscount() * orderEntry.getQuantity();
                        }
                        double printDiscount = Math.round(discount * 100.0) / 100.0;
                        data += "\nDiscount :  Rs." + printDiscount + "\n\n";    
                        OrderUtil.productLevelDiscount += discount;
                    }
                }
            }
        }
        return data;
    }

}
