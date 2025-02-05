package com.auth.Authentication.Service.product.Dto;

import java.util.UUID;

public class OrderItemRequest {

    private UUID productId;
    private UUID productVariantId;
    private Double discount;
    private Integer quantity;
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public UUID getProductVariantId() {
		return productVariantId;
	}
	public void setProductVariantId(UUID productVariantId) {
		this.productVariantId = productVariantId;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public OrderItemRequest(UUID productId, UUID productVariantId, Double discount, Integer quantity) {
		super();
		this.productId = productId;
		this.productVariantId = productVariantId;
		this.discount = discount;
		this.quantity = quantity;
	}
	public OrderItemRequest() {
		super();
	}
    
    
}