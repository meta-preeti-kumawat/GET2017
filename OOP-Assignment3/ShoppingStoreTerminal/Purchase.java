import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import order.Order;
import order.OrderEntry;
import product.Product;
import product.ProductList;
import promotions.OrderPromotion;
import promotions.ProductPromotion;
import utility.OrderUtil;

/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class is the main controller of application
 *
 */
public class Purchase {
    
    /**
     * this method gets input from user, validate it and sets order
     * @param productList
     * @return Order
     */
    public static Order getInputs(ProductList productList) {
        Map<String, Product> productMap = new HashMap<String, Product>();
        Order order = new Order(); 
        Scanner scanInput = new Scanner(System.in);
        int numberOfProducts;
        String productCode = new String();
        int quantity;
        
        productMap = productList.getProductMap();
        ArrayList<OrderEntry> orderList = new ArrayList<OrderEntry>();
        
        //scan Inputs
        System.out.println("--------------------------------------");
        System.out.print("Enter number of products to purchase: ");
        numberOfProducts = scanInput.nextInt();
        for(int count = 0; count < numberOfProducts; count++){
            System.out.println("\n\tProduct " + (count+1) );
            System.out.print("\tEnter Product Code: ");
            productCode = scanInput.next();
            
            if(productMap.containsKey(productCode)){
                System.out.print("\tEnter quantity: ");
                quantity = scanInput.nextInt();
                //assign values to product
                OrderEntry productEntry = OrderUtil.createCart(productMap.get(productCode), quantity);
                orderList.remove(productEntry);
                orderList.add(productEntry);
            }
            else{
                System.out.println("Enter a valid Product code");
                count--;
            }
        }
        order.setOrders(orderList);
        scanInput.close();
        return order;
    }
    
    public static void main(String[] args) {
        
        //Display List of products and available discounts
        ProductList productList = new ProductList(); 
        productList.getDetails("src/StoreFiles/ProductList.csv");
        System.out.println(productList.getFileData());
        
        ProductPromotion productPromotion = new ProductPromotion();
        ArrayList<ProductPromotion> productPromotionsList = new ArrayList<ProductPromotion>();
        productPromotionsList = productPromotion.getDetails("src/StoreFiles/ProductPromo.csv", productList);
        System.out.println(productPromotion.getFileData());

        OrderPromotion orderPromotion = new OrderPromotion();
        ArrayList<OrderPromotion> orderPromotionsList = new ArrayList<OrderPromotion>();
        orderPromotionsList = orderPromotion.getDetails("src/StoreFiles/OrderPromo.csv");
        System.out.println(orderPromotion.getFileData());
        
        //Get user inputs for purchase
        Order order = Purchase.getInputs(productList);
        System.out.println(order.printList());
        
        //get available discounts
        System.out.println(OrderUtil.getAvailableDiscounts(order, orderPromotionsList, productPromotionsList));
        System.out.println(OrderUtil.printBill("src/StoreFiles/FinalBill.txt"));
    }
}
