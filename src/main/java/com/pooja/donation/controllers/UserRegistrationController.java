package com.pooja.donation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.UserRegistrationDto;
import com.pooja.donation.services.UserLoginService;
import com.pooja.donation.services.impl.UserLoginSeviceImpl;

@RestController
@RequestMapping("/auth/register")
public class UserRegistrationController {

	@Autowired
	private UserLoginService userService;

	@PostMapping("/newUser")
	public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationRequest) {
		userService.registerUser(registrationRequest);
		return new ResponseEntity<>("New User registered successfully", HttpStatus.CREATED);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}

}