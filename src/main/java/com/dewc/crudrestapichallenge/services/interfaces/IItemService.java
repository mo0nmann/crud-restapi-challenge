package com.dewc.crudrestapichallenge.services.interfaces;

import java.util.Optional;

import com.dewc.crudrestapichallenge.dto.ItemDto;

public interface IItemService {
    
    public void saveItem(ItemDto itemDto);

    Optional<ItemDto> getItem(Long id);

    void updateItem(Long id, String name, String description);

    void deleteItem(Long id);
}
