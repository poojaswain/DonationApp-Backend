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

import com.pooja.donation.payloads.ItemDTO;
import com.pooja.donation.services.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO createdItem = itemService.createItem(itemDTO);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable int id) {
        ItemDTO itemDTO = itemService.getItemById(id);
        if (itemDTO != null) {
            return new ResponseEntity<>(itemDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> itemDTOs = itemService.getAllItems();
        return new ResponseEntity<>(itemDTOs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        ItemDTO updatedItem = itemService.updateItem(id, itemDTO);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
