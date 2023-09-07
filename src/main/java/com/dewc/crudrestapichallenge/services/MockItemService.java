package com.dewc.crudrestapichallenge.services;

import com.dewc.crudrestapichallenge.adaptors.ItemAdaptor;
import com.dewc.crudrestapichallenge.dao.ItemDao;
import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.entities.Item;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;

public class MockItemService implements IItemService {
    
    private final ItemDao itemDao;

    public MockItemService(@Qualifier("mockItemDao") ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public void saveItem(ItemDto itemDto) {
        Item item = ItemAdaptor.toEntity(itemDto);
        itemDao.save(item);
    }

    @Override
    public List<ItemDto> getItems() {
        List<Item> items = itemDao.findAll();
        return items.stream()
                    .map(ItemAdaptor::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDto> getItem(Long id) {
        Optional<Item> item = itemDao.findById(id);
        return item.map(ItemAdaptor::toDto);
    }

    @Override
    public void updateItem(Long id, String name, String description) {
        Optional<Item> optionalItem = itemDao.findById(id);
        if(optionalItem.isPresent()){
            Item item = optionalItem.get();
            item.setName(name);
            item.setDescription(description);
            itemDao.save(item);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemDao.deleteById(id);
    } 

}
