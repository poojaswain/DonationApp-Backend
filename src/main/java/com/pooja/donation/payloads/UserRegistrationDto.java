package com.pooja.donation.payloads;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationDto {

	private String username;
	private String fullName;
	private String password;
	private String userType;
	private String email;
	private String address;
	private String contactNumber;
	
}