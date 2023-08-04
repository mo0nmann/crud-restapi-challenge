package com.dewc.crudrestapichallenge.controllers.bases;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dewc.crudrestapichallenge.dto.ItemDto;
import com.dewc.crudrestapichallenge.services.interfaces.IItemService;

public abstract class ItemControllerBase {
    
    private IItemService itemService;

    public ItemControllerBase(IItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity<Void> saveItem(@RequestBody ItemDto itemDto) {
        itemService.saveItem(itemDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id) {
        Optional<ItemDto> itemDto = itemService.getItem(id);
        return itemDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        itemService.updateItem(id, itemDto.getName(), itemDto.getDescription());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}