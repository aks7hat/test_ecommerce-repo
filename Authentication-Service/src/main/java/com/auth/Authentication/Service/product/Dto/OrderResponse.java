package com.auth.Authentication.Service.product.Dto;

import java.util.Map;
import java.util.UUID;

public class OrderResponse {

    private UUID orderId;
    private Map<String,String> credentials;
    private String paymentMethod;
	public UUID getOrderId() {
		return orderId;
	}
	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}
	public Map<String, String> getCredentials() {
		return credentials;
	}
	public void setCredentials(Map<String, String> credentials) {
		this.credentials = credentials;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public OrderResponse(UUID orderId, Map<String, String> credentials, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.credentials = credentials;
		this.paymentMethod = paymentMethod;
	}
	public OrderResponse() {
		super();
	}
    
    
}