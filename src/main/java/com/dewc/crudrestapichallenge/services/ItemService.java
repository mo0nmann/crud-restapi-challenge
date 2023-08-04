package com.dewc.crudrestapichallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dewc.crudrestapichallenge.adaptors.ItemAdaptor;
import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;
import com.dewc.crudrestapichallenge.repositories.ItemRepository;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

@Service
@Qualifier("itemService")
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void saveItem(ItemDto itemDto) {
        Item item = ItemAdaptor.toEntity(itemDto);
        itemRepository.save(item);
    }

    @Override
    public Optional<ItemDto> getItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.isPresent() ? Optional.of(ItemAdaptor.toDto(item.get())) : Optional.empty();
    }

    @Override
    public void updateItem(Long id, String name, String description) {

        Optional<Item> optionalItem = itemRepository.findById(id);

        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(name);
            item.setDescription(description);
            itemRepository.save(item);
        }

    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
