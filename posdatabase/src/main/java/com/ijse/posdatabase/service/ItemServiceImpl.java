package com.ijse.posdatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.posdatabase.dto.ItemDTO;
import com.ijse.posdatabase.entity.Category;
import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.repository.CategoryRepository;
import com.ijse.posdatabase.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Item createItem(ItemDTO itemDTO) {
		Category category =
		categoryRepository.findById(itemDTO.getCategoryId()).orElse(null);

		if(category != null){
			Item item = new Item();
			item.setName(itemDTO.getName());
			item.setPrice(itemDTO.getPrice());
			item.setQty(itemDTO.getQty());
			item.setCategory(category);
			

		return itemRepository.save(item);
	}else{
		return null;
	}
		
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
    }

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElse(null);
    }

	@Override
	public List<Item> getItemsByCategory(Long id) {
		
        Category category = categoryRepository.findById(id).orElse(null);

        if(category != null){
            return itemRepository.findItemsByCategory(category);

        }else{
            return null;
        }
    } 

	@Override
	public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if(existingItem != null){
            existingItem.setName(item.getName());
            existingItem.setCategory(item.getCategory());
            existingItem.setPrice(item.getPrice());
            existingItem.setQty(item.getQty());

            return itemRepository.save(existingItem);

        }else{
            return null;
        }
    }

    
}
