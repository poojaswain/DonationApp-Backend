package com.pooja.donation.services;

import com.pooja.donation.payloads.ReceiverDto;

public interface UpdateProfileService {
	
	void updateDonorProfile (Integer uid, String fileUuid, String desc);
	
	void updateReceiverProfile (Integer uid, String fileUuid, ReceiverDto receiverDto);

}
