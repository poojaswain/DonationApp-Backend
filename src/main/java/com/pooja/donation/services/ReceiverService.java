package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.entities.Receiver;

public interface ReceiverService {
	
	Receiver createReceiver(Receiver receiver);

    List<Receiver> getAllReceivers();

    Receiver getReceiverById(int id);

    Receiver updateReceiver(int id, Receiver receiver);

    void deleteReceiver(int id);

}
