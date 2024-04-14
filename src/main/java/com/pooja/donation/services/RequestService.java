package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.payloads.RequestDTO;

public interface RequestService {
	
	RequestDTO createRequest(RequestDTO requestDTO);

	RequestDTO getRequestById(int id);

	List<RequestDTO> getAllRequests();

	RequestDTO updateRequest(int id, RequestDTO requestDTO);

	void deleteRequest(int id);
}
