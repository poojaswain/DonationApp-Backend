package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooja.donation.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findByUsername(String username);

}
