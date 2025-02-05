package com.auth.Authentication.Service.product.Dto;

import java.util.List;
import java.util.UUID;


public class CategoryDto {

    private UUID id;
    private String name;
    private String code;
    private String description;
    private List<CategoryTypeDto> categoryTypes;
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
	public List<CategoryTypeDto> getCategoryTypes() {
		return categoryTypes;
	}
	public void setCategoryTypes(List<CategoryTypeDto> categoryTypes) {
		this.categoryTypes = categoryTypes;
	}
	public CategoryDto(UUID id, String name, String code, String description, List<CategoryTypeDto> categoryTypes) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.categoryTypes = categoryTypes;
	}
	public CategoryDto() {
		super();
	}
    
    
    

}
