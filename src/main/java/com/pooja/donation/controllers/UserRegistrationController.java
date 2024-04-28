package com.pooja.donation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.UserRegistrationDto;
import com.pooja.donation.services.UserLoginService;

@RestController
@RequestMapping("/auth/register")
public class UserRegistrationController {

	@Autowired
	private UserLoginService userService;

	@PostMapping("/newUser")
	public ResponseEntity<ResponseDTO> registerUser(@RequestBody UserRegistrationDto registrationRequest) {	
		ResponseDTO response = userService.registerUser(registrationRequest);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}

}