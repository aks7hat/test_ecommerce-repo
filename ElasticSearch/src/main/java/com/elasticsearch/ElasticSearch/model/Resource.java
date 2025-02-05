package com.elasticsearch.ElasticSearch.model;


import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


public class Resource {
	
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String url;

    @Field(type = FieldType.Boolean)
    private Boolean isPrimary;

    @Field(type = FieldType.Keyword)
    private String type;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Resource(String id, String name, String url, Boolean isPrimary, String type) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.isPrimary = isPrimary;
		this.type = type;
	}

	public Resource() {
		super();
	}
    
    

}
