package com.pooja.donation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Donor;
import com.pooja.donation.entities.Receiver;
import com.pooja.donation.payloads.ReceiverDto;
import com.pooja.donation.repositories.DonorRepo;
import com.pooja.donation.repositories.ReceiverRepo;
import com.pooja.donation.services.DonorService;
import com.pooja.donation.services.ReceiverService;
import com.pooja.donation.services.UpdateProfileService;

@Service
public class UpdateProfileServiceImpl implements UpdateProfileService {

	@Autowired
	private DonorRepo donorRepository;

	@Autowired
	private ReceiverRepo receiverRepository;

	@Autowired
	private DonorService donorService;

	@Autowired
	private ReceiverService receiverService;

	@Override
	public void updateDonorProfile(Integer uid, String fileUuid, String desc) {
		Donor donorUser = donorRepository.findByUserId(uid);
		Donor updateDonor = new Donor(donorUser.getId(), uid, desc, fileUuid);
		donorService.updateDonor(updateDonor.getId(), updateDonor);
	}

	@Override
	public void updateReceiverProfile(Integer uid, String fileUuid, ReceiverDto receiverDto) {
		Receiver receiverUser = receiverRepository.findByUserId(uid);
		Receiver updateReceiver = new Receiver(receiverUser.getId(), uid, receiverDto.getWebsite(),
				receiverDto.getDescription(), fileUuid);
		receiverService.updateReceiver(updateReceiver.getId(), updateReceiver);
	}

}
