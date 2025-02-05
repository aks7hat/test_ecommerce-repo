package com.auth.Authentication.Service.product.Dto;

import java.util.UUID;


public class ProductResourceDto {

    private UUID id;
    private String name;
    private String url;
    private String type;
    private  Boolean isPrimary;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public ProductResourceDto(UUID id, String name, String url, String type, Boolean isPrimary) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.isPrimary = isPrimary;
	}
	public ProductResourceDto() {
		super();
	}
    
    
    
}