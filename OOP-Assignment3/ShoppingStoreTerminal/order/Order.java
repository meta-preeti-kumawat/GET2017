package order;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class is holds a particular order by a user
 *
 */
public class Order {
    ArrayList<OrderEntry> orderList = new ArrayList<OrderEntry>();
    private float totalCost = 0;
    
    /**
     * @param orderList
     */
    public void setOrders(ArrayList<OrderEntry> orderList) {
        this.orderList = orderList;
    }
    
    public ArrayList<OrderEntry> getOrders(){
        return this.orderList;
    }
    
    /**
     * @return String which is used to display current order
     */
    public String printList() {
        String data;
        data = "##########################\nYour Orders\n##########################\n";
        float cost;
        ArrayList<OrderEntry> orderList = new ArrayList<OrderEntry>();
        orderList = this.getOrders();
        for (Iterator<OrderEntry> iterator = orderList.iterator(); iterator.hasNext();) {
            OrderEntry orderEntry = (OrderEntry) iterator.next();
            cost = (orderEntry.getDetails().getCost() * orderEntry.getQuantity());
            String price = " " + cost + " ( " + orderEntry.getQuantity()
                    + " x Rs." + orderEntry.getDetails().getCost() + ")";
            data += "\nProduct : " + orderEntry.getDetails().getCode()
                    + " - " + orderEntry.getDetails().getName() + " \n Cost :  "
                    + price + "\n";
            this.totalCost += cost;
        }
        return data;
    }
    
    public float getTotalCost() {
        return totalCost;
    }
}
