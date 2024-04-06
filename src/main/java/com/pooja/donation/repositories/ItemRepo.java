package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooja.donation.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
