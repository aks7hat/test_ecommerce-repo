package com.auth.Authentication.Service.product.Dto;

import java.util.UUID;


public class ProductVariantDto {

    private UUID id;
    private String color;
    private String size;
    private Integer stockQuantity;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public ProductVariantDto(UUID id, String color, String size, Integer stockQuantity) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
		this.stockQuantity = stockQuantity;
	}
	public ProductVariantDto() {
		super();
	}
    
    
}
