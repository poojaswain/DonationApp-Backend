package com.pooja.donation.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pooja.donation.payloads.UserRegistrationDto;

public interface UserLoginService extends UserDetailsService{
	
	public void registerUser(UserRegistrationDto request);

}
