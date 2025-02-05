package com.auth.Authentication.Service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.repo.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Optional<UserModel> optionalUser = userRepository.findByEmail(username);
        UserModel user= optionalUser.isPresent() ? optionalUser.get() : null;
        if(null == user){
            throw new UsernameNotFoundException("User Not Found with userName " + username);
        }
        return user;
    }
}