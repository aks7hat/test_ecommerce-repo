package com.auth.Authentication.Service.product.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Authentication.Service.config.JWTTokenHelper;
import com.auth.Authentication.Service.model.Address;
import com.auth.Authentication.Service.product.Dto.AddressRequest;
import com.auth.Authentication.Service.product.service.AddressService;


@RestController
@RequestMapping("/api/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private JWTTokenHelper jWTTokenHelper;

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest, @RequestHeader (name="Authorization") String token){
    	token = token.split(" ")[1];
    	String email = jWTTokenHelper.getUserNameFromToken(token);
    	
        Address address = addressService.createAddress(addressRequest,email);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable UUID id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}