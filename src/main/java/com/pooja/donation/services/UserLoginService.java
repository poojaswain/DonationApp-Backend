package com.pooja.donation.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.UserRegistrationDto;

public interface UserLoginService extends UserDetailsService{
	
	public ResponseDTO registerUser(UserRegistrationDto request);
	
	public String getUserType(String username);

}
