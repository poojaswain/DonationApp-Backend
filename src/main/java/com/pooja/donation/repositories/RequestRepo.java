package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.donation.entities.Request;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {

}
