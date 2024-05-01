package com.pooja.donation.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Request;
import com.pooja.donation.entities.UserEntity;
import com.pooja.donation.payloads.PostRequestDTO;
import com.pooja.donation.repositories.RequestRepo;
import com.pooja.donation.services.RequestService;
import com.pooja.donation.services.UserService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepo requestRepository;
    
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostRequestDTO createRequest(PostRequestDTO requestDTO) {
        Request request = dtoToRequest(requestDTO);
        Request savedRequest = requestRepository.save(request);
        return requestToDto(savedRequest);
    }

    @Override
    public PostRequestDTO getRequestById(int id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.map(this::requestToDto).orElse(null);
    }

    @Override
    public List<PostRequestDTO> getAllRequests() {
        List<Request> requests = requestRepository.findAll();
        return requests.stream()
                .map(this::requestToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostRequestDTO updateRequest(int id, PostRequestDTO requestDTO) {
        if (requestRepository.existsById(id)) {
            Request request = dtoToRequest(requestDTO);
            request.setReqId(id);
            Request updatedRequest = requestRepository.save(request);
            return requestToDto(updatedRequest);
        }
        return null;
    }

    @Override
    public void deleteRequest(int id) {
        requestRepository.deleteById(id);
    }

    private Request dtoToRequest(PostRequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Request.class);
    }

    private PostRequestDTO requestToDto(Request request) {
        return modelMapper.map(request, PostRequestDTO.class);
    }

	@Override
	public Request raiseRequest(Integer userId, Integer postId, String reqMessage) {
		
		UserEntity user = userService.getUserEntity(userId);
		
		String requestMessage = "Request Created for donation post by " + user.getFullName();
		Request request = new Request(userId, postId, user.getFullName(), requestMessage, LocalDateTime.now(), false);

		return requestRepository.save(request);
	}

	@Override
	public List<Request> getAllRequestsByPost(Integer postId) {
		return requestRepository.findByPostId(postId);
	}

	
}
