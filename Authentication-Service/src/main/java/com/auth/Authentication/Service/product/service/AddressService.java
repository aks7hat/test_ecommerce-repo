package com.auth.Authentication.Service.product.service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.Address;
import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.product.Dto.AddressRequest;
import com.auth.Authentication.Service.product.repo.AddressRepository;


@Service
public class AddressService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressRequest addressRequest, String email){
        UserModel user= (UserModel) userDetailsService.loadUserByUsername(email);
        Address address = new Address();
        address.setName(addressRequest.getName());
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setZipCode(addressRequest.getZipCode());
        address.setPhoneNumber(addressRequest.getPhoneNumber());
        address.setUser(user);

        return addressRepository.save(address);
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }
}
