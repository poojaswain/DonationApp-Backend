package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

	Integer getUserIdByUsername(String username);

	UserEntity getUserEntity(Integer userId);

}
