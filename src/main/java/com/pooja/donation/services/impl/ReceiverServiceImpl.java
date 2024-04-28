package com.pooja.donation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Receiver;
import com.pooja.donation.repositories.ReceiverRepo;
import com.pooja.donation.services.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverRepo receiverRepository;

    @Override
    public Receiver createReceiver(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    @Override
    public List<Receiver> getAllReceivers() {
        return receiverRepository.findAll();
    }

    @Override
    public Receiver getReceiverById(int id) {
        return receiverRepository.findById(id).orElse(null);
    }

    @Override
    public Receiver updateReceiver(int id, Receiver receiver) {
        if (receiverRepository.existsById(id)) {
            receiver.setId(id);  
            return receiverRepository.save(receiver);
        }
        return null;
    }

    @Override
    public void deleteReceiver(int id) {
        receiverRepository.deleteById(id);
    }

}
