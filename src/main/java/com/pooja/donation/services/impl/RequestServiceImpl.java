package com.pooja.donation.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Request;
import com.pooja.donation.payloads.RequestDTO;
import com.pooja.donation.repositories.RequestRepo;
import com.pooja.donation.services.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepo requestRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RequestDTO createRequest(RequestDTO requestDTO) {
        Request request = dtoToRequest(requestDTO);
        Request savedRequest = requestRepository.save(request);
        return requestToDto(savedRequest);
    }

    @Override
    public RequestDTO getRequestById(int id) {
        Optional<Request> request = requestRepository.findById(id);
        return request.map(this::requestToDto).orElse(null);
    }

    @Override
    public List<RequestDTO> getAllRequests() {
        List<Request> requests = requestRepository.findAll();
        return requests.stream()
                .map(this::requestToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RequestDTO updateRequest(int id, RequestDTO requestDTO) {
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

    private Request dtoToRequest(RequestDTO requestDTO) {
        return modelMapper.map(requestDTO, Request.class);
    }

    private RequestDTO requestToDto(Request request) {
        return modelMapper.map(request, RequestDTO.class);
    }
}
