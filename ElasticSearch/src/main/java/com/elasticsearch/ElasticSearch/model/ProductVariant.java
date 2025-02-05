package com.elasticsearch.ElasticSearch.model;

import java.util.UUID;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


public class ProductVariant {
	
	@Field(type = FieldType.Keyword)
    private String id;

	@Field(type = FieldType.Keyword)
    private String color;
	
	@Field(type = FieldType.Keyword)
    private String size;

	@Field(type = FieldType.Integer)
    private Integer stockQuantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public ProductVariant(String id, String color, String size, Integer stockQuantity) {
		super();
		this.id = id;
		this.color = color;
		this.size = size;
		this.stockQuantity = stockQuantity;
	}

	public ProductVariant() {
		super();
	}
	
	
}
