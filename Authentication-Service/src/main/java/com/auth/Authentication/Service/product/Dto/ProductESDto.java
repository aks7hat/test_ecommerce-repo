package com.auth.Authentication.Service.product.Dto;

import java.math.BigDecimal;


public class ProductESDto {
    
    private String productId;

    private String name;

    private String description;

    private BigDecimal price;

    private String brand;
    
    private String color;
    
    private String categoryName;
    
    private String categoryTypeName;
    
    private String url;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryTypeName() {
		return categoryTypeName;
	}

	public void setCategoryTypeName(String categoryTypeName) {
		this.categoryTypeName = categoryTypeName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductESDto(String productId, String name, String description, BigDecimal price, String brand, String color,
			String categoryName, String categoryTypeName, String url) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.categoryName = categoryName;
		this.categoryTypeName = categoryTypeName;
		this.url = url;
	}

	public ProductESDto() {
		super();
	}    
    

}
