package com.pooja.donation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.JwtRequestDto;
import com.pooja.donation.payloads.JwtResponseDto;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.security.JwtService;
import com.pooja.donation.services.UserLoginService;
import com.pooja.donation.services.UserService;

@RequestMapping("/auth")
@RestController
public class UserLoginController {

	@Autowired
	AuthenticationManager manager;

	@Autowired
	JwtService jwtService;

	@Autowired
	UserLoginService loginService;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> AuthenticateAndGetToken(@RequestBody JwtRequestDto request) {
		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = loginService.loadUserByUsername(request.getUsername());
		String token = this.jwtService.generateToken(userDetails);
		String userType = loginService.getUserType(userDetails.getUsername());
		String userId = userService.getUserIdByUsername(userDetails.getUsername()).toString();

		JwtResponseDto response = JwtResponseDto.builder().userId(userId).jwtToken(token)
				.username(userDetails.getUsername()).userType(userType).build();
		ResponseDTO result = new ResponseDTO(response, "User Logged In Successfully", HttpStatus.OK);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	private void doAuthenticate(String username, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
