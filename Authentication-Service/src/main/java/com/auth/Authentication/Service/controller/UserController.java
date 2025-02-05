package com.auth.Authentication.Service.controller;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Authentication.Service.config.JWTTokenHelper;
import com.auth.Authentication.Service.dto.RegistrationRequest;
import com.auth.Authentication.Service.dto.RegistrationResponse;
import com.auth.Authentication.Service.dto.UserToken;
import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JWTTokenHelper jwtTokenHelper;
    
    @Value("${custom.env.variable}")
    private String envVariable;
    

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request) {
        RegistrationResponse res = userService.registerUser(request);
        return new ResponseEntity<>(res,
        		res.getCode() == 200 ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody Map<String,String> map) {
    	String email = map.get("email");
    	String password = map.get("password");
        try{
            Authentication authentication= UsernamePasswordAuthenticationToken.unauthenticated(email,password);
            Authentication authenticationResponse = this.authenticationManager.authenticate(authentication);

            if(authenticationResponse.isAuthenticated()){
                UserModel user= (UserModel) authenticationResponse.getPrincipal();
                String token =jwtTokenHelper.generateToken(user.getEmail());
                UserToken userToken= new UserToken(token);
                return new ResponseEntity<>(userToken,HttpStatus.OK);
            }

        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(@RequestBody Map<String,String> map){
        String email = map.get("userName");
        String code = map.get("code");

        java.util.Optional<UserModel> optionalUser = userService.getUserByEmail(email);
        UserModel user = null;
        if(optionalUser.isPresent()) {
        	user = optionalUser.get();
        }
        if(null != user && user.getVerificationCode().equals(code)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam(required = true,name = "email") String email) {
        try {
            String resetUrl = userService.sendPasswordResetEmail(email);
            return new ResponseEntity<>(resetUrl,HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Some error occured!!");
        }
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String,String> map) {
    	String token = map.get("token");
    	String password = map.get("password");
        try {
            userService.resetPassword(token, password);
            return new ResponseEntity<>("Password reset successfully!",HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/greet")
    public String getVariable() {
		return "Hello, Env variable is " +envVariable ;
    }
    
}