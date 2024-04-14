package com.pooja.donation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.donation.payloads.RequestDTO;
import com.pooja.donation.services.RequestService;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO requestDTO) {
        RequestDTO createdRequest = requestService.createRequest(requestDTO);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable int id) {
        RequestDTO requestDTO = requestService.getRequestById(id);
        if (requestDTO != null) {
            return new ResponseEntity<>(requestDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<RequestDTO> requestDTOs = requestService.getAllRequests();
        return new ResponseEntity<>(requestDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDTO> updateRequest(@PathVariable int id, @RequestBody RequestDTO requestDTO) {
        RequestDTO updatedRequest = requestService.updateRequest(id, requestDTO);
        if (updatedRequest != null) {
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable int id) {
        requestService.deleteRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
