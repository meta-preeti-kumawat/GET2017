package com.metacube.shoppingCart.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.metacube.shoppingCart.enums.Status;
import com.metacube.shoppingCart.facade.ProductFacade;
import com.metacube.shoppingCart.model.Product;

public class ProductFacadeTest {
    private ProductFacade productFacade;
    
    @Before
    public void initialize() throws IOException {
        productFacade = ProductFacade.getInstance();
    }
    
    @Test
    public void storeProductPositiveTest() throws IOException{
        Product product = new Product();
        product.setCode("1322");
        product.setName("Reebok Shoes");
        product.setPrice((float) 1500.25);
        
        Status expectedStatus = Status.OK;
        
        assertEquals(expectedStatus, productFacade.storeProduct(product));
    }
    
    @Test
    public void storeProductNegativeTest() throws IOException{
        Product product = new Product();
        product.setCode("1001");
        product.setName("Reebok");
        product.setPrice((float) 1050);
        
        Status expectedStatus = Status.DUPLICATE;
        
        assertEquals(expectedStatus, productFacade.storeProduct(product));
    }

    @Test
    public void updateProductPositiveTest() throws IOException{
        Product product = new Product();
        product.setId("192");
        product.setCode("111");
        product.setName("Puma");
        product.setPrice((float)1503.50);
        Status expectedStatus = Status.OK;
        
        assertEquals(expectedStatus, productFacade.updateProduct(product));
    }
    
    @Test
    public void updateProductNegativeTest() throws IOException{
        Product product = new Product();
        product.setId("7108");
        
        Status expectedStatus = Status.UNAVAILABLE;
        
        assertEquals(expectedStatus, productFacade.updateProduct(product));
    }

    @Test
    public void removeProductPositiveTest() throws IOException{
        Product product = new Product();
        product.setId("708");
        
        Status expectedStatus = Status.OK;
        
        assertEquals(expectedStatus, productFacade.removeProduct(product));
    }
    
    @Test
    public void removeProductNegativeTest() throws IOException{
        Product product = new Product();
        product.setId("7108");
        
        Status expectedStatus = Status.UNAVAILABLE;
        
        assertEquals(expectedStatus, productFacade.removeProduct(product));
    }
}
