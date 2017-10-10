package main.java.com.metacube.layeredArchitecture.dto;

public class ProductDto {
	private int id;
	private String name;
	private float price;
	private String description;
	private String imageUrl;
	
	public ProductDto() { }
	
	public ProductDto(int id, String name, float price, String description, String imageUrl) {
		setId(id);
		setName(name);
		setPrice(price);
		setDescription(description);
		setImageUrl(imageUrl);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}	
}