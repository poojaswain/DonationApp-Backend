package com.pooja.donation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.entities.Request;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.services.RequestService;

@RestController
@RequestMapping("/api")
public class MainRequestController {
	
	@Autowired
    private RequestService requestService;
	
	
	// Create a new request specific to an user & post
	@PostMapping("/user/{userId}/post/{postId}/request")
	public ResponseEntity<ResponseDTO> createRequest(@RequestBody String reqMessage,
			@PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId) {
		Request createdRequest = requestService.raiseRequest(userId, postId, reqMessage);

		ResponseDTO response = new ResponseDTO(createdRequest, "New Request Created Successfully", HttpStatus.CREATED);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	// Get all requests for a specific post
	@GetMapping("/post/{postId}/requests")
	public ResponseEntity<ResponseDTO> getAllRequests(@PathVariable("postId") Integer postId) {
		List<Request> allRequests = requestService.getAllRequestsByPost(postId);
		ResponseDTO response = new ResponseDTO(allRequests, "New Request Created Successfully", HttpStatus.CREATED);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}
