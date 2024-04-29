package com.pooja.donation.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int userId;
	private String username;
	private String fullName;
	private String userType;
	private String email;
	private String address;
	private String contactNumber;
}
