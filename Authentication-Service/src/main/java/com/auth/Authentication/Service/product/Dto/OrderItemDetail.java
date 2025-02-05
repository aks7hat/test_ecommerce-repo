package com.auth.Authentication.Service.product.Dto;

import java.util.UUID;

import com.auth.Authentication.Service.product.model.Product;


public class OrderItemDetail {

    private UUID id;
    private Product product;
    private UUID productVariantId;
    private Integer quantity;
    private Double itemPrice;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public UUID getProductVariantId() {
		return productVariantId;
	}
	public void setProductVariantId(UUID productVariantId) {
		this.productVariantId = productVariantId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public OrderItemDetail(UUID id, Product product, UUID productVariantId, Integer quantity, Double itemPrice) {
		super();
		this.id = id;
		this.product = product;
		this.productVariantId = productVariantId;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}
	public OrderItemDetail() {
		super();
	}
    
    
}