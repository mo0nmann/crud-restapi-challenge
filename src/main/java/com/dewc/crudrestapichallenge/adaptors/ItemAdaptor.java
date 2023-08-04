package com.dewc.crudrestapichallenge.adaptors;

import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;

public class ItemAdaptor {
    
    public static Item toEntity(ItemDto itemDto) {

        Item item = new Item();

        item.setName(itemDto.getName());
        item.setDescription(itemDto.getDescription())
        
        return item;


    }

}
