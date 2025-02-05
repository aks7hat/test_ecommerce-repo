package com.auth.Authentication.Service.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.auth.Authentication.Service.config.JWTTokenHelper;
import com.auth.Authentication.Service.model.UserModel;
import com.auth.Authentication.Service.service.OAuth2Service;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @Autowired
    OAuth2Service oAuth2Service;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;
    
    @Autowired
    private OAuth2AuthorizedClientService clientService;
    
	@Value("${frontend.allowed.url}")
	private String frontend_url;

    @GetMapping("/success")
    public void callbackOAuth2(@AuthenticationPrincipal OAuth2User oAuth2User, HttpServletResponse response) throws IOException {
    	
    	System.out.println("OAuth2Controller -> " + oAuth2User);
        String userName = oAuth2User.getAttribute("email");
        UserModel user=oAuth2Service.getUser(userName);
        if(null == user){
            user = oAuth2Service.createUser(oAuth2User,"google");
        }

        String token = jwtTokenHelper.generateToken(user.getUsername());
        String url = frontend_url + "/oauth2/callback?token="+token+"&email="+userName;
        response.sendRedirect(url);

    }
    
//    @GetMapping("/login/oauth2/code/facebook")
//    public RedirectView loginSuccess(OAuth2AuthenticationToken authenticationToken) {
//      OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
//        authenticationToken.getAuthorizedClientRegistrationId(),
//        authenticationToken.getName()
//      );
//      return new RedirectView("/login-success");
//    }
}
