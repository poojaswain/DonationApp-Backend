package com.pooja.donation.services;

import java.util.List;

import com.pooja.donation.payloads.ItemDTO;

public interface ItemService {
	
	ItemDTO createItem(ItemDTO itemDTO);

	ItemDTO getItemById(int id);

	List<ItemDTO> getAllItems();

	ItemDTO updateItem(int id, ItemDTO itemDTO);

	void deleteItem(int id);
}
