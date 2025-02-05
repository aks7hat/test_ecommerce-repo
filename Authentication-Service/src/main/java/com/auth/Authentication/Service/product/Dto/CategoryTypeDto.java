package com.auth.Authentication.Service.product.Dto;

import java.util.UUID;


public class CategoryTypeDto {
    private UUID id;
    private String name;
    private String code;
    private String description;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CategoryTypeDto(UUID id, String name, String code, String description) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
	}
	public CategoryTypeDto() {
		super();
	}
    
    
    
}