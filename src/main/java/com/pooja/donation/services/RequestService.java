package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.entities.Request;
import com.pooja.donation.payloads.PostRequestDTO;

public interface RequestService {
	
	PostRequestDTO createRequest(PostRequestDTO requestDTO);

	PostRequestDTO getRequestById(int id);

	List<PostRequestDTO> getAllRequests();

	PostRequestDTO updateRequest(int id, PostRequestDTO requestDTO);

	void deleteRequest(int id);

	Request raiseRequest(Integer userId, Integer postId, String reqMessage);

	List<Request> getAllRequestsByPost(Integer postId);

	Request approveRequest(Integer requestId);
}
