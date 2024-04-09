package com.pooja.donation.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.repositories.UserRepo;
import com.pooja.donation.services.UserLoginService;

public class UserLoginSeviceImpl implements UserLoginService {

	@Autowired
	private UserRepo userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserLoginSeviceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.debug("Entering in loadUserByUsername Method...");
		UserEntity user = userRepository.findByUsername(username);
		if (user == null) {
			logger.error("Username not found: " + username);
			throw new UsernameNotFoundException("could not found user..!!");
		}
		logger.info("User Authenticated Successfully..!!!");
		return User.builder().username(user.getUsername()).password(user.getPassword()).build();
	}

}
