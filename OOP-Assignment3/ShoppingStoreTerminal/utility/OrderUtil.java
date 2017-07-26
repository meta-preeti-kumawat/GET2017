package utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dao.DataAccessObject;
import order.Order;
import order.OrderEntry;
import product.Product;
import promotions.OrderPromotion;
import promotions.ProductPromotion;

/**
 * This is a utility class which perform calculations about discounts and prints the bill
 * @author Preeti Kumawat
 * Date : 26-07-2017
 *
 */
public class OrderUtil {
    public static float productLevelDiscount = 0;
    public static float orderLevelDiscount = 0;
    private static float totalCost = 0;
    public static float costAfterProductDiscount = 0;
    
    private static Map<Product, Integer> orderList = new HashMap<Product, Integer>();

    /**
     * adds products to cart
     * @param product
     * @param quantity
     * @return String
     */
    public static OrderEntry createCart(Product product, int quantity) {
        OrderEntry entry;
        if (!orderList.containsKey(product)) {
            orderList.put(product, quantity);
        } else {
            orderList.put(product, orderList.get(product) + quantity);
        }
        entry = new OrderEntry(product, orderList.get(product));
        return entry;
    }

    /**
     * gets available discounts (both product level and order level)
     * @param order
     * @param orderPromotionsList
     * @param productPromotionsList
     * @return String
     */
    public static String getAvailableDiscounts(Order order, ArrayList<OrderPromotion> orderPromotionsList, ArrayList<ProductPromotion> productPromotionsList){
        Collections.sort(orderPromotionsList);
        Collections.reverse(orderPromotionsList);
        
        ArrayList<OrderEntry> orderList = order.getOrders();
        String data = "\n\nAPPLIED PROMOTIONS/DISCOUNTS :\n";
        for (Iterator<OrderEntry> iterator = orderList.iterator(); iterator.hasNext();) {
            OrderEntry orderEntry = (OrderEntry) iterator.next();
            data += ProductPromotion.applicableProductPromotions(orderEntry, productPromotionsList);
            
        }
        totalCost = order.getTotalCost();
        costAfterProductDiscount = totalCost - productLevelDiscount;
        if(costAfterProductDiscount < 0){
            costAfterProductDiscount = 0;
        }
        data += OrderPromotion.applicableOrderPromotions(orderPromotionsList);
        return data;
    }

    /**
     * prints bill to file and returns string for console print
     * @param path
     * @return String
     */
    public static String printBill(String path){
        float totalDiscount = getTotalDiscount();
        String billData = "";
        billData += "\n Final Bill :\n";
        billData += "\n Subtotal : Rs." + totalCost;
        billData += "\n Product Level Discounts : Rs."+productLevelDiscount;
        billData += "\n Order Level Discounts : Rs."+orderLevelDiscount;
        billData += "\n Total Discounts : Rs." + totalDiscount + "\n";
        totalCost = getTotalCost();
        billData += "\n Total Cost : Rs." + totalCost + "\n";
        DataAccessObject.accessFileToWrite(billData, path);
        return billData;
    }
    
    public static float getTotalDiscount(){
        return productLevelDiscount+orderLevelDiscount;
    }

    public static float getTotalCost(){
        return (totalCost > 0? totalCost - getTotalDiscount(): 0);
    }
}
