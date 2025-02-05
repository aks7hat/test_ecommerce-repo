package com.auth.Authentication.Service.product.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.Authentication.Service.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
