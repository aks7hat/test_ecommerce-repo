package com.auth.Authentication.Service.product.Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class OrderRequest {
    private UUID userId;
    private Date orderDate;
    private UUID addressId;
    private List<OrderItemRequest> orderItemRequests;
    private Double totalAmount;
    private Double discount;
    private String paymentMethod;
    private Date expectedDeliveryDate;
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public UUID getAddressId() {
		return addressId;
	}
	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}
	public List<OrderItemRequest> getOrderItemRequests() {
		return orderItemRequests;
	}
	public void setOrderItemRequests(List<OrderItemRequest> orderItemRequests) {
		this.orderItemRequests = orderItemRequests;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public OrderRequest(UUID userId, Date orderDate, UUID addressId, List<OrderItemRequest> orderItemRequests,
			Double totalAmount, Double discount, String paymentMethod, Date expectedDeliveryDate) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;
		this.addressId = addressId;
		this.orderItemRequests = orderItemRequests;
		this.totalAmount = totalAmount;
		this.discount = discount;
		this.paymentMethod = paymentMethod;
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public OrderRequest() {
		super();
	}
    
    
}