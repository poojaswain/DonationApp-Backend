package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.donation.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByUsername(String username);

}
