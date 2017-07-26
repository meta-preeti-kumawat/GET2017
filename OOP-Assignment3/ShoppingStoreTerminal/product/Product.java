package product;


/**
 * 
 * @author Preeti Kumawat
 * Date; 26-07-2017
 * This class holds details about each product
 *
 */
public class Product{
    private String code;
    private String name;
    private float cost;
    private String error;

    public String getError() {
        return this.error;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * this method splits the data and set data for product
     * @param data
     * @return
     */
    public Product splitData(String data) {
        if (data.indexOf(',') != -1) {
            String[] productData = data.split(",");
            if (productData.length == 3) {
                this.setCode(productData[0]);
                this.setName(productData[1]);
                this.setCost(Float.parseFloat(productData[2]));
            }
            else{
                this.error = "invalid data string";
            }
        }
        return this;
    }
    
}
