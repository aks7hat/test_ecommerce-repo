package com.auth.Authentication.Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Authentication.Service.config.JWTTokenHelper;
import com.auth.Authentication.Service.dto.UserDetailsDto;
import com.auth.Authentication.Service.model.UserModel;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserDetailsController {
	
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JWTTokenHelper jWTTokenHelper;

    @GetMapping("/profile")
    public ResponseEntity<UserDetailsDto> getUserProfile(@RequestHeader (name="Authorization") String token){
    	UserDetailsDto userDetailsDto = new UserDetailsDto();
    	try {
	    	token = token.split(" ")[1];
	    	String email = jWTTokenHelper.getUserNameFromToken(token);
	        UserModel user = (UserModel) userDetailsService.loadUserByUsername(email);
	
	        if(null == user){
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }
	        userDetailsDto.setFirstName(user.getFirstName());
	        userDetailsDto.setLastName(user.getLastName());
	        userDetailsDto.setEmail(user.getEmail());
	        userDetailsDto.setId(user.getId());
	        userDetailsDto.setPhoneNumber(user.getPhoneNumber());
	        userDetailsDto.setAddressList(user.getAddressList());
	        userDetailsDto.setAuthorityList(user.getAuthorities().toArray());
    	}
    	catch (Exception e) {
			// TODO: handle exception
//    		e.printStackTrace();
		}

        return new ResponseEntity<>(userDetailsDto, HttpStatus.OK);

    }
}
