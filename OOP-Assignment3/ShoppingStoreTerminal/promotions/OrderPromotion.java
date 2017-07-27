package promotions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dao.DataAccessObject;
import utility.OrderUtil;


/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class holds details abiut order level promotions
 *
 */
public class OrderPromotion implements Comparable<OrderPromotion>{
    public String type;
    public float discount;
    public float threshold;
    private String fileData;
    private String error;
    
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
    
    public float getThreshold() {
        return threshold;
    }
    
    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }
    
    public OrderPromotion splitData(String data){
        if (data.indexOf(',') != -1) {
            String[] orderPromotionData = data.split(",");
            if (orderPromotionData.length == 3) {
                this.setType(orderPromotionData[0]);
                this.setDiscount(Float.parseFloat(orderPromotionData[1]));
                this.setThreshold(Float.parseFloat(orderPromotionData[2]));
            }
        }
        return this;
    }
    
    /**
     * returns complete list of Order Promotions
     * @param path
     * @return ArrayList<OrderPromotion>
     */
    public ArrayList<OrderPromotion> getDetails(String path){
        ArrayList<OrderPromotion> orderPromotionsList = new ArrayList<OrderPromotion>();
        
        try{
            DataAccessObject productList = new DataAccessObject();
            ArrayList<String> dataList = new ArrayList<String>();
            String fileData = "";
            
            dataList = productList.accessFileForRead(path);
            fileData += " --------------\n| Product List |\n --------------\n";

            for (Iterator<String> iterator = dataList.iterator(); iterator.hasNext();) {
                String data = (String) iterator.next();
                OrderPromotion orderPromotion = new OrderPromotion();
                orderPromotion.splitData(data);
                orderPromotionsList.add(orderPromotion);
                fileData += data + "\n";
            }
            this.setFileData(fileData);
        }catch(IOException fileNotFound) {
                this.error = "File Not Found";
        }
        return orderPromotionsList;
    }

    private void setFileData(String fileData) {
        this.fileData = fileData;
    }
    
    public String getFileData() {
        return this.fileData;
    }
    
    public String getError() {
        return this.error;
    }
    
    @Override
    public int compareTo(OrderPromotion o) {
        return this.threshold >= o.threshold ? 1 : -1;
    }
    
    /**
     * fnds applicable order promotions for a particular order
     * @param orderPromotionsList
     * @return String
     */
    public static String applicableOrderPromotions(ArrayList<OrderPromotion> orderPromotionsList){
        boolean check;
        String data = "";
        String fixedPercent = "OrderFixedPercentPromotion";
        float discount = 0;
        
        for (OrderPromotion orderPromotion : orderPromotionsList) {
            if(OrderUtil.costAfterProductDiscount >= orderPromotion.threshold){
                check =fixedPercent.equalsIgnoreCase(orderPromotion.getType());
                if(check){
                    data += "Promotion :  "+(int)orderPromotion.discount+"% off on orders above ";
                    discount = (OrderUtil.costAfterProductDiscount*orderPromotion.discount)/100;
                }else{
                    data += "Promotion :  Rs."+orderPromotion.discount+" off on above ";
                    discount = orderPromotion.discount;
                }
                double printDiscount = Math.round(discount * 100.0) / 100.0;
                
                data += "Rs. "+orderPromotion.threshold+"\nDiscount : Rs."+printDiscount+"\n\n";
                OrderUtil.orderLevelDiscount += discount;
                break;
            }
        }
        return data;
    }
    
}
