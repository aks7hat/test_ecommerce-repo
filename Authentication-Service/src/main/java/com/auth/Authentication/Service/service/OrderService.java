package com.auth.Authentication.Service.service;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.Address;
import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.product.Dto.OrderDetails;
import com.auth.Authentication.Service.product.Dto.OrderItemDetail;
import com.auth.Authentication.Service.product.Dto.OrderRequest;
import com.auth.Authentication.Service.product.Dto.OrderResponse;
import com.auth.Authentication.Service.product.model.Order;
import com.auth.Authentication.Service.product.model.OrderItem;
import com.auth.Authentication.Service.product.model.OrderStatus;
import com.auth.Authentication.Service.product.model.Product;
import com.auth.Authentication.Service.product.repo.OrderRepository;
import com.auth.Authentication.Service.product.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProductService productService;



    @Transactional
    public OrderResponse createOrder(OrderRequest orderRequest, String email) throws Exception {
        UserModel user = (UserModel) userDetailsService.loadUserByUsername(email);
        Address address = user.getAddressList().stream().filter(address1 -> orderRequest.getAddressId().equals(address1.getId())).findFirst().orElseThrow(BadRequestException::new);

        Order order= new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setOrderDate(orderRequest.getOrderDate());
        order.setDiscount(orderRequest.getDiscount());
        order.setExpectedDeliveryDate(orderRequest.getExpectedDeliveryDate());
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setOrderStatus(OrderStatus.CREATED);

        List<OrderItem> orderItems = orderRequest.getOrderItemRequests().stream().map(orderItemRequest -> {
            try {
                Product product= productService.fetchProductById(orderItemRequest.getProductId());
                OrderItem orderItem= new OrderItem();
                orderItem.setProduct(product);
                orderItem.setProductVariantId(orderItemRequest.getProductVariantId());
                orderItem.setQuantity(orderItemRequest.getQuantity());
                orderItem.setOrder(order);
                return orderItem;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();

        order.setOrderItemList(orderItems);
        Order savedOrder = orderRepository.save(order);


        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setPaymentMethod(orderRequest.getPaymentMethod());
        orderResponse.setOrderId(savedOrder.getId());
        return orderResponse;

    }

//    public Map<String,String> updateStatus(String paymentIntentId, String status) {
//
//        try{
//            PaymentIntent paymentIntent= PaymentIntent.retrieve(paymentIntentId);
//            if (paymentIntent != null && paymentIntent.getStatus().equals("succeeded")) {
//               String orderId = paymentIntent.getMetadata().get("orderId") ;
//               Order order= orderRepository.findById(UUID.fromString(orderId)).orElseThrow(BadRequestException::new);
//               Payment payment = order.getPayment();
//               payment.setPaymentStatus(PaymentStatus.COMPLETED);
//                payment.setPaymentMethod(paymentIntent.getPaymentMethod());
//                order.setPaymentMethod(paymentIntent.getPaymentMethod());
//                order.setOrderStatus(OrderStatus.IN_PROGRESS);
//                order.setPayment(payment);
//                Order savedOrder = orderRepository.save(order);
//                Map<String,String> map = new HashMap<>();
//                map.put("orderId", String.valueOf(savedOrder.getId()));
//                return map;
//            }
//            else{
//                throw new IllegalArgumentException("PaymentIntent not found or missing metadata");
//            }
//        }
//        catch (Exception e){
//            throw new IllegalArgumentException("PaymentIntent not found or missing metadata");
//        }
//    }

    public List<OrderDetails> getOrdersByUser(String name) {
        UserModel user = (UserModel) userDetailsService.loadUserByUsername(name);
        List<Order> orders = orderRepository.findByUser(user);
        return orders.stream().map(order -> {
            return new OrderDetails(
            		order.getId(),
            		order.getOrderDate(),
            		order.getAddress(),
            		order.getTotalAmount(),
            		order.getOrderStatus(),
            		order.getShipmentTrackingNumber(),
            		order.getExpectedDeliveryDate(),
            		getItemDetails(order.getOrderItemList())
            		);
        }).toList();

    }

    private List<OrderItemDetail> getItemDetails(List<OrderItem> orderItemList) {

        return orderItemList.stream().map(orderItem -> {
            return new OrderItemDetail(orderItem.getId(), 
            		orderItem.getProduct(),
            		orderItem.getProductVariantId(),
            		orderItem.getQuantity(),
            		orderItem.getItemPrice()
            		);
        }).toList();
    }

    public void cancelOrder(UUID id, String email) {
        UserModel user = (UserModel) userDetailsService.loadUserByUsername(email);
        Order order = orderRepository.findById(id).get();
        if(null != order && order.getUser().getId().equals(user.getId())){
            order.setOrderStatus(OrderStatus.CANCELLED);
            //logic to refund amount
            orderRepository.save(order);
        }
        else{
            new RuntimeException("Invalid request");
        }

    }
}
