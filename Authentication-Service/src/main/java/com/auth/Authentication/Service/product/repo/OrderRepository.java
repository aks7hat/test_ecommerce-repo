package com.auth.Authentication.Service.product.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.product.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findByUser(UserModel user);
}
