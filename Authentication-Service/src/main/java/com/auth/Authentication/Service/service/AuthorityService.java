package com.auth.Authentication.Service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.Authority;
import com.auth.Authentication.Service.repo.AuthorityRepository;


@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> getUserAuthority(){
       List<Authority> authorities=new ArrayList<>();
       Authority authority= authorityRepository.findByRoleCode("USER");
       authorities.add(authority);
       return  authorities;
    }

    public Authority createAuthority(String role, String description){
        Authority authority = new Authority();
        authority.setRoleCode(role);
        authority.setRoleDescription(description);
        return authorityRepository.save(authority);
    }
}
