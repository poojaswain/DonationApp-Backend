package com.pooja.donation.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooja.donation.entities.Item;
import com.pooja.donation.payloads.ItemDTO;
import com.pooja.donation.repositories.ItemRepo;
import com.pooja.donation.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = dtoToItem(itemDTO);
        Item savedItem = itemRepository.save(item);
        return itemToDto(savedItem);
    }

    @Override
    public ItemDTO getItemById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(this::itemToDto).orElse(null);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream()
                .map(this::itemToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO updateItem(int id, ItemDTO itemDTO) {
        if (itemRepository.existsById(id)) {
            Item item = dtoToItem(itemDTO);
            item.setId(id);
            Item updatedItem = itemRepository.save(item);
            return itemToDto(updatedItem);
        }
        return null;
    }

    @Override
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    private Item dtoToItem(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, Item.class);
    }

    private ItemDTO itemToDto(Item item) {
        return modelMapper.map(item, ItemDTO.class);
    }
}
