package com.elasticsearch.ElasticSearch.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



public class Category {

	@Field(type = FieldType.Keyword)
    private String id;

	@Field(type = FieldType.Text)
    private String name;

	@Field(type = FieldType.Keyword)
    private String code;

	@Field(type = FieldType.Text)
    private String description;

	@Field(type = FieldType.Nested)
    private List<CategoryType> categoryTypes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<CategoryType> getCategoryTypes() {
		return categoryTypes;
	}

	public void setCategoryTypes(List<CategoryType> categoryTypes) {
		this.categoryTypes = categoryTypes;
	}

	public Category(String id, String name, String code, String description, List<CategoryType> categoryTypes) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.categoryTypes = categoryTypes;
	}

	public Category() {
		super();
	}
	
	
}
