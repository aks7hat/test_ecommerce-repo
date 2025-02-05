package com.auth.Authentication.Service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.Authentication.Service.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	Optional<UserModel> findByEmail(String email);
}
