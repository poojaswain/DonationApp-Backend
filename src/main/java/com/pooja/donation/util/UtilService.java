package com.pooja.donation.util;

import org.springframework.stereotype.Component;

@Component
public class UtilService {
	
	public UserType getUserType(String userTypeString) {
        if (userTypeString == null || userTypeString.isBlank()) {
            throw new IllegalArgumentException("userTypeString cannot be null or blank");
        }

        userTypeString = userTypeString.toUpperCase(); // Ensure case-insensitive comparison

        switch (userTypeString) {
            case "ADMIN":
                return UserType.ADMIN;
            case "DONOR":
                return UserType.DONOR;
            case "RECEIVER":
                return UserType.RECEIVER;
            default:
                throw new IllegalArgumentException("Invalid user type: " + userTypeString);
        }
    }

}
