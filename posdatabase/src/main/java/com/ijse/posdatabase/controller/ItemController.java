 package com.ijse.posdatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.posdatabase.dto.ItemDTO;
import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.service.ItemService;

@RestController

@CrossOrigin(origins = "*")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/items") 
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(200).body(itemService.getAllItems());
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody ItemDTO itemDTO) {
        try {
            return ResponseEntity.status(201).body(itemService.createItem(itemDTO));
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to create the Item");
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);

        if(item != null) {
            return ResponseEntity.status(HttpStatus.OK).body(item);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

     @GetMapping("/categories/{id}/items") 
    public ResponseEntity<List<Item>> getItemsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemService.getItemsByCategory(id));
    } 

 } 