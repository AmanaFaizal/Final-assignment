package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.ItemDTO;
import com.ijse.posdatabase.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item createItem(ItemDTO itemDTO);
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);
    List<Item> getItemsByCategory(Long id);
}

 