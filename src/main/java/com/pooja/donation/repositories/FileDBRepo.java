package com.pooja.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pooja.donation.entities.FileDB;

@Repository
public interface FileDBRepo extends JpaRepository<FileDB, String> {

}
