package com.auth.Authentication.Service.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.Authentication.Service.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
	
    Authority findByRoleCode(String user);
}
