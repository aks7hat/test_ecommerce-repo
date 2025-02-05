package com.auth.Authentication.Service.product.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Authentication.Service.config.JWTTokenHelper;
import com.auth.Authentication.Service.product.Dto.OrderDetails;
import com.auth.Authentication.Service.product.Dto.OrderRequest;
import com.auth.Authentication.Service.product.Dto.OrderResponse;
import com.auth.Authentication.Service.service.OrderService;


@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {


    @Autowired
    OrderService orderService;
    
    @Autowired
    private JWTTokenHelper jWTTokenHelper;



    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest, @RequestHeader (name="Authorization") String token) throws Exception {
    	token = token.split(" ")[1];
    	String email = jWTTokenHelper.getUserNameFromToken(token);
    	OrderResponse orderResponse = orderService.createOrder(orderRequest,email);
            //return new ResponseEntity<>(order, HttpStatus.CREATED);

        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }

//    @PostMapping("/update-payment")
//    public ResponseEntity<?> updatePaymentStatus(@RequestBody Map<String,String> request){
//        Map<String,String> response = orderService.updateStatus(request.get("paymentIntent"),request.get("status"));
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancelOrder(@PathVariable UUID id,@RequestHeader (name="Authorization") String token){
    	token = token.split(" ")[1];
    	String email = jWTTokenHelper.getUserNameFromToken(token);
        orderService.cancelOrder(id,email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderDetails>> getOrderByUser( @RequestHeader (name="Authorization") String token) {
    	token = token.split(" ")[1];
    	String email = jWTTokenHelper.getUserNameFromToken(token);
        List<OrderDetails> orders = orderService.getOrdersByUser(email);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
