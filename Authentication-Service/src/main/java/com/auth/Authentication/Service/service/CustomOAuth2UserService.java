package com.auth.Authentication.Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.model.UserModel;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	
    @Autowired
    OAuth2Service oAuth2Service;
	
	 @Override
	    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
//		 System.out.println("CustomOAuth2UserService -> " + oAuth2UserRequest.getAdditionalParameters());		 
		 OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
//		 System.out.println("CustomOAuth2UserService -> " + oAuth2User.getName() + " " + oAuth2User.getAttribute("email"));
//		 System.out.println(oAuth2UserRequest.getClientRegistration().getClientName());
		 
		String userName = oAuth2User.getAttribute("email");
		UserModel user=oAuth2Service.getUser(userName);
		if(null == user){
		    user = oAuth2Service.createUser(oAuth2User,oAuth2UserRequest.getClientRegistration().getClientName());
		}

		 return oAuth2User;
		 
		 
	 }
}
