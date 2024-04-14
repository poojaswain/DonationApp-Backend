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
import com.pooja.donation.security.JwtService;
import com.pooja.donation.services.UserLoginService;

@RequestMapping("/auth")
@RestController
public class UserLoginController {

	@Autowired
	AuthenticationManager manager;

	@Autowired
	JwtService jwtService;

	@Autowired
	UserLoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<JwtResponseDto> AuthenticateAndGetToken(@RequestBody JwtRequestDto request) {
		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = loginService.loadUserByUsername(request.getUsername());
		String token = this.jwtService.generateToken(userDetails);

		JwtResponseDto response = JwtResponseDto.builder().jwtToken(token).username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
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
