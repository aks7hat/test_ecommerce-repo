package com.auth.Authentication.Service.product.Dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductDto {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private boolean isNewArrival;
    private Float rating;
    private UUID categoryId;
    private String thumbnail;
    private String slug;
    private String categoryName;
    private UUID categoryTypeId;
    private String categoryTypeName;
    private List<ProductVariantDto> variants;
    private List<ProductResourceDto> productResources;
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
	public boolean isNewArrival() {
		return isNewArrival;
	}
	public void setNewArrival(boolean isNewArrival) {
		this.isNewArrival = isNewArrival;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public UUID getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public UUID getCategoryTypeId() {
		return categoryTypeId;
	}
	public void setCategoryTypeId(UUID categoryTypeId) {
		this.categoryTypeId = categoryTypeId;
	}
	public String getCategoryTypeName() {
		return categoryTypeName;
	}
	public void setCategoryTypeName(String categoryTypeName) {
		this.categoryTypeName = categoryTypeName;
	}
	public List<ProductVariantDto> getVariants() {
		return variants;
	}
	public void setVariants(List<ProductVariantDto> variants) {
		this.variants = variants;
	}
	public List<ProductResourceDto> getProductResources() {
		return productResources;
	}
	public void setProductResources(List<ProductResourceDto> productResources) {
		this.productResources = productResources;
	}
	public ProductDto(UUID id, String name, String description, BigDecimal price, String brand, boolean isNewArrival,
			Float rating, UUID categoryId, String thumbnail, String slug, String categoryName, UUID categoryTypeId,
			String categoryTypeName, List<ProductVariantDto> variants, List<ProductResourceDto> productResources) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.isNewArrival = isNewArrival;
		this.rating = rating;
		this.categoryId = categoryId;
		this.thumbnail = thumbnail;
		this.slug = slug;
		this.categoryName = categoryName;
		this.categoryTypeId = categoryTypeId;
		this.categoryTypeName = categoryTypeName;
		this.variants = variants;
		this.productResources = productResources;
	}
	public ProductDto() {
		super();
	}
    
    
}
