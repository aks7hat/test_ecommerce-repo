package com.auth.Authentication.Service.product.Dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.auth.Authentication.Service.model.Address;
import com.auth.Authentication.Service.product.model.OrderStatus;


public class OrderDetails {

    private UUID id;
    private Date orderDate;
    private Address address;
    private Double totalAmount;
    private OrderStatus orderStatus;
    private String shipmentNumber;
    private Date expectedDeliveryDate;
    private List<OrderItemDetail> orderItemList;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getShipmentNumber() {
		return shipmentNumber;
	}
	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}
	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	public List<OrderItemDetail> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItemDetail> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public OrderDetails(UUID id, Date orderDate, Address address, Double totalAmount, OrderStatus orderStatus,
			String shipmentNumber, Date expectedDeliveryDate, List<OrderItemDetail> orderItemList) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.address = address;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.shipmentNumber = shipmentNumber;
		this.expectedDeliveryDate = expectedDeliveryDate;
		this.orderItemList = orderItemList;
	}
	public OrderDetails() {
		super();
	}
    
    

}