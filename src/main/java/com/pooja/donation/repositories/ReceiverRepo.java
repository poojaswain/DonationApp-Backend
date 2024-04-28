package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooja.donation.entities.Receiver;

public interface ReceiverRepo extends JpaRepository<Receiver, Integer>{
	
	public Receiver findByUserId(int userId);

}
