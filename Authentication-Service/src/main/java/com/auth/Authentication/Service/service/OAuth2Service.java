package com.auth.Authentication.Service.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.repo.UserRepository;


@Service
public class OAuth2Service {

    @Autowired
    UserRepository userDetailRepository;

    @Autowired
    private AuthorityService authorityService;

    public UserModel getUser(String userName) {
    	Optional<UserModel> optionalUser= userDetailRepository.findByEmail(userName);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public UserModel createUser(OAuth2User oAuth2User, String provider) {
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");
        String email = oAuth2User.getAttribute("email");
        if(provider.equalsIgnoreCase("github") && StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
        	String name = oAuth2User.getAttribute("name");
        	firstName = name.split(" ")[0];
        	lastName = name.split(" ")[1];
        }
        UserModel user= new UserModel();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUsername(email);
		user.setProvider(provider);
		user.setAuthorities(authorityService.getUserAuthority());
        return userDetailRepository.save(user);
    }
}
