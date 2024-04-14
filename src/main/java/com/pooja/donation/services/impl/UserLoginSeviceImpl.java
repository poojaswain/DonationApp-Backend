package com.pooja.donation.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.payloads.UserRegistrationDto;
import com.pooja.donation.repositories.UserRepo;
import com.pooja.donation.services.UserLoginService;

@Service
public class UserLoginSeviceImpl implements UserLoginService {

	@Autowired
	private UserRepo userRepo;

	private static final Logger logger = LoggerFactory.getLogger(UserLoginSeviceImpl.class);

	@Override
	public void registerUser(UserRegistrationDto request) {

		UserEntity newUser = UserEntity();
		newUser.setUsername(request.getUsername());
		newUser.setPassword(passEncoder().encode(request.getPassword()));
		newUser.setEmail(request.getEmail());
		newUser.setUserType(request.getUserType());
		newUser.setFullName(request.getFullName());
		userRepo.save(newUser);
	}

	private UserEntity UserEntity() {
		return new UserEntity();
	}

	private PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.debug("Entering in loadUserByUsername Method...");
		UserEntity user = userRepo.findByUsername(username);
		if (user == null) {
			logger.error("Username not found: " + username);
			throw new UsernameNotFoundException("could not found user..!!");
		}
		logger.info("User Authenticated Successfully..!!!");
		return User.builder().username(user.getUsername()).password(user.getPassword()).build();
	}

}
