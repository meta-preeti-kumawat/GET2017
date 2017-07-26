import static org.junit.Assert.*;

import org.junit.Test;

import product.Product;
import product.ProductList;

public class ShoppingStoreTest {
    @Test
    public void testGetProductByCodeForNullList(){
    	ProductList productList = new ProductList();
    	assertNull("Initially it returns null", productList.getProductByCode("1001"));
    }
    
    @Test
    public void testGetProductByCodeForNonEmptyList(){
    	ProductList productList = new ProductList();
    	Product product = new Product();
    	product.setCode("1001");
    	product.setCost(100);
    	product.setName("Reebok");
    	productList.setMap(product);
    	assertNotNull("Initially it returns null", productList.getProductByCode("1001"));
    }
}
