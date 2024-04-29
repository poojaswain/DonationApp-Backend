package com.pooja.donation.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.ApiResponse;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.UserDto;
import com.pooja.donation.services.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class MainUserController {
	
	@Autowired
	private UserService userService;
	
   
	// GET -- get user
	@GetMapping("/user/{userId}")
	public ResponseEntity<ResponseDTO> getUserBasicDetails(@PathVariable("userId") Integer userId) {
		UserDto getUser = userService.getUserBasicDetails(userId);
		ResponseDTO response = new ResponseDTO(getUser, "Successfully fetched user by " + userId, HttpStatus.OK);

		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
}
