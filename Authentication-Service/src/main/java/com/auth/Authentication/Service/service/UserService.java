package com.auth.Authentication.Service.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.Authentication.Service.dto.RegistrationRequest;
import com.auth.Authentication.Service.dto.RegistrationResponse;
import com.auth.Authentication.Service.model.PasswordResetToken;
import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.repo.PasswordResetTokenRepository;
import com.auth.Authentication.Service.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private PasswordResetTokenRepository tokenRepository;
    
	@Value("${frontend.allowed.url}")
	private String frontend_url;
    

    public RegistrationResponse registerUser(RegistrationRequest user) {
    	Optional<UserModel> user1 = userRepository.findByEmail(user.getEmail());
    	if(user1.isPresent()) {
    		RegistrationResponse res = new RegistrationResponse();
            res.setCode(400);
            res.setMessage("User Already Exists!!");
            return res;
    	}
    	
   	
    	String code = UserService.generateCode();
    	System.out.println("Verification Code -> " + code);

        
        
    	UserModel newUser = new UserModel();
    	newUser.setUsername(user.getUsername());
    	newUser.setFirstName(user.getFirstName());
    	newUser.setLastName(user.getLastName());
    	newUser.setPhoneNumber(user.getPhoneNumber());
    	newUser.setEmail(user.getEmail());
    	newUser.setPassword(passwordEncoder.encode(user.getPassword()));
    	newUser.setVerificationCode(code);
    	newUser.setProvider("Manual");
    	
    	emailService.sendMail(newUser);
        userRepository.save(newUser);
        RegistrationResponse res = new RegistrationResponse();
        res.setCode(200);
        res.setMessage("User Created!!");
        return res;
    }

    public UserModel loginUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(null);
    }
    
    public Optional<UserModel> getUserByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    public static String generateCode(){
        Random random=new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
    
    public String sendPasswordResetEmail(String email) {
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken existingToken = tokenRepository.findByUser(user).orElse(null);
        if(existingToken != null) {
            existingToken.setToken(token);
            existingToken.setExpiryDate(LocalDateTime.now().plusHours(1));
            tokenRepository.save(existingToken);	
        }
        else {
	        PasswordResetToken resetToken = new PasswordResetToken();
	        resetToken.setUser(user);
	        resetToken.setToken(token);
	        tokenRepository.save(resetToken);
        }

        String resetUrl = frontend_url+"/v1/reset-password?token=" + token;

        emailService.sendPasswordResetEmail(user,resetUrl);
        return resetUrl;
    }
    
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expired");
        }

        UserModel user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

}
