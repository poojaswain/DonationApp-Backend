package com.pooja.donation.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Donor;
import com.pooja.donation.entities.Receiver;
import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.exceptionhandlers.PreconditionFailedException;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.UserRegistrationDto;
import com.pooja.donation.repositories.UserRepo;
import com.pooja.donation.services.DonorService;
import com.pooja.donation.services.ReceiverService;
import com.pooja.donation.services.UserLoginService;
import com.pooja.donation.util.UserType;
import com.pooja.donation.util.UtilService;

@Service
public class UserLoginSeviceImpl implements UserLoginService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private DonorService donorService;

	@Autowired
	private ReceiverService receiverService;

	@Autowired
	private UtilService utilService;

	private static final Logger logger = LoggerFactory.getLogger(UserLoginSeviceImpl.class);

	@Override
	public ResponseDTO registerUser(UserRegistrationDto request) {

		ResponseDTO result = new ResponseDTO();

		UserEntity user = userRepo.findByUsername(request.getUsername());
		if (user != null) {
			result.setMessage("User Already Exists!");
			result.setHttpStatus(HttpStatus.PRECONDITION_FAILED);
		} else {
			UserEntity newUser = UserEntity();
			newUser.setUsername(request.getUsername());
			newUser.setPassword(passEncoder().encode(request.getPassword()));
			newUser.setEmail(request.getEmail());
			newUser.setUserType(utilService.getUserType(request.getUserType()).toString());
			newUser.setFullName(request.getFullName());
			UserEntity savedUser = userRepo.save(newUser);

			UserType userType = utilService.getUserType(request.getUserType());
			if (userType.equals(UserType.DONOR)) {
				Donor donorTypeUser = new Donor(savedUser.getId());
				donorService.createDonor(donorTypeUser);
			} else if (userType.equals(UserType.RECEIVER)) {
				Receiver receiverTypeUser = new Receiver(savedUser.getId());
				receiverService.createReceiver(receiverTypeUser);
			}

			result.setMessage("New User registered successfully");
			result.setHttpStatus(HttpStatus.CREATED);
		}
		return result;
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

	@Override
	public String getUserType(String username) {
		UserEntity user = userRepo.findByUsername(username);
		return user.getUserType();
	}

}
