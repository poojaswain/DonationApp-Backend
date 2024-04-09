package com.pooja.donation.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.exceptions.*;
import com.pooja.donation.payloads.UserDto;
import com.pooja.donation.repositories.*;
import com.pooja.donation.services.UserService;
import com.pooja.donation.entities.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
		
	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity user= this.dtoToUser(userDto);
		UserEntity savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		UserEntity user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));	
		user.setFullName(userDto.getName());
		user.setUserType(userDto.getType());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddress(userDto.getAddress());
		user.setContactNumber(userDto.getContact());
		UserEntity updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return  userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		UserEntity user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
	return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<UserEntity> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		UserEntity user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
	}

	public UserEntity dtoToUser(UserDto userDto) {
		UserEntity user= this.modelMapper.map(userDto, UserEntity.class);
		return user;
	}
	
	public UserDto userToDto(UserEntity user) {
		UserDto userDto= this.modelMapper.map(user, UserDto.class);
		return userDto;

	}
	
}
