package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.donation.entities.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{

}
