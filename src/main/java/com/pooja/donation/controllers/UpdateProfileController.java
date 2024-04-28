package com.pooja.donation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.ReceiverDto;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.UserDto;
import com.pooja.donation.services.UpdateProfileService;
import com.pooja.donation.services.UserService;

import jakarta.validation.Valid;

@RequestMapping("/api/update")
@RestController
public class UpdateProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	private UpdateProfileService profileService;

	// PUT -- update basic user details
	@PutMapping("/user/{userId}")
	public ResponseEntity<ResponseDTO> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		ResponseDTO response = new ResponseDTO(updatedUser, "User Basic Information got updated", HttpStatus.OK);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

	// PUT -- update donor user profile
	@PutMapping("/donor/profile/{userId}/upload/{fileUuid}")
	public ResponseEntity<ResponseDTO> updateDonorProfile(@Valid @RequestBody String donorDescription,
			@PathVariable("fileUuid") String fileUuid, @PathVariable("userId") Integer uid) {
		ResponseDTO response = new ResponseDTO();
		String fileMessage = "";
		if (fileUuid != null) {
			profileService.updateDonorProfile(uid, fileUuid, donorDescription);
			fileMessage = "Uploaded the file successfully. ";

			response.setMessage("Donor profile Updated & " + fileMessage);
			response.setHttpStatus(HttpStatus.OK);
		} else {
			profileService.updateDonorProfile(uid, null, donorDescription);
			fileMessage = "Could not upload the file!";

			response.setMessage("Donor profile Updated & " + fileMessage);
			response.setHttpStatus(HttpStatus.PARTIAL_CONTENT);
		}

		return new ResponseEntity<>(response, response.getHttpStatus());
	}

	// PUT -- update receiver user profile
	@PutMapping("/receiver/profile/{userId}/upload/{fileUuid}")
	public ResponseEntity<ResponseDTO> updateReceiverProfile(@Valid @RequestBody ReceiverDto receiverDto,
			@PathVariable("fileUuid") String fileUuid, @PathVariable("userId") Integer uid) {
		ResponseDTO response = new ResponseDTO();
		String fileMessage = "";
		if (fileUuid != null) {
			profileService.updateReceiverProfile(uid, fileUuid, receiverDto);
			fileMessage = "Uploaded the file successfully. ";

			response.setMessage("Receiver profile Updated & " + fileMessage);
			response.setHttpStatus(HttpStatus.OK);
		} else {
			profileService.updateReceiverProfile(uid, null, receiverDto);
			fileMessage = "Could not upload the file!";

			response.setMessage("Receiver profile Updated & " + fileMessage);
			response.setHttpStatus(HttpStatus.PARTIAL_CONTENT);
		}

		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}
