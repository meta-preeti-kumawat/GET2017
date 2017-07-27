package order;

import product.Product;

/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class holds a single order entry
 *
 */
public class OrderEntry {
    private Product product;
    private int quantity;
    
    public OrderEntry(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getDetails(){
        return this.product;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof OrderEntry){
            OrderEntry orderEntry = (OrderEntry) object;
            if(orderEntry != null && this.product.getCode().equals(orderEntry.product.getCode())){
                return true;
            }
        }
        return false;
    }
}
