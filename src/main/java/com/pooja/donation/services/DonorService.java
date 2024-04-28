package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.entities.Donor;

public interface DonorService {
	
	Donor createDonor(Donor donor);

    List<Donor> getAllDonors();

    Donor getDonorById(int id);

    Donor updateDonor(int id, Donor donor);

    void deleteDonor(int id);

}
