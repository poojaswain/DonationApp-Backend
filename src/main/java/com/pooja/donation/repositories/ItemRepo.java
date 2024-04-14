package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.donation.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
