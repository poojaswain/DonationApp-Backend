package com.pooja.donation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Donor;
import com.pooja.donation.repositories.DonorRepo;
import com.pooja.donation.services.DonorService;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepo donorRepository;

    @Override
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Donor getDonorById(int id) {
        return donorRepository.findById(id).orElse(null);
    }

    @Override
    public Donor updateDonor(int id, Donor donor) {
        if (donorRepository.existsById(id)) {
            donor.setId(id);  
            return donorRepository.save(donor);
        }
        return null;
    }

    @Override
    public void deleteDonor(int id) {
        donorRepository.deleteById(id);
    }

}
