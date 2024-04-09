package com.pooja.donation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.JwtRequestDto;
import com.pooja.donation.payloads.JwtResponseDto;
import com.pooja.donation.security.JwtService;

@RestController
public class UserLoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public JwtResponseDto AuthenticateAndGetToken(@RequestBody JwtRequestDto authRequestDTO){
	    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
	    if(authentication.isAuthenticated()){
	    	JwtService.GenerateToken(authRequestDTO.getUsername());
	       return JwtResponseDto.builder()
	               .accessToken(JwtService.GenerateToken(authRequestDTO.getUsername())).build();
	    } else {
	        throw new UsernameNotFoundException("invalid user request..!!");
	    }
	}

}
