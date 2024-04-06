package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooja.donation.entities.Request;

public interface RequestRepo extends JpaRepository<Request, Integer> {

}
