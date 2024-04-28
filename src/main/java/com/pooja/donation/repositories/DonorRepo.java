package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooja.donation.entities.Donor;

public interface DonorRepo extends JpaRepository<Donor, Integer> {

	public Donor findByUserId(int userId);

}
