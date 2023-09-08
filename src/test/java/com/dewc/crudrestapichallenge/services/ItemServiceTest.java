package com.dewc.crudrestapichallenge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dewc.crudrestapichallenge.dao.MockItemDao;
import com.dewc.crudrestapichallenge.dto.ItemDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemServiceTest {
    
    private MockItemService mockItemService;

    @BeforeEach
    public void setUp() {
        mockItemService = new MockItemService(new MockItemDao());
    }

    @Test
    public void testSaveItem() {
        ItemDto itemDto = new ItemDto();
        itemDto.setName("TestItem");
        itemDto.setDescription("TestDescription");
        
        mockItemService.saveItem(itemDto);

        assertEquals(1, mockItemService.getItems().size());
    }

    @Test
    public void testGetItem() {
        ItemDto itemDto = new ItemDto();
        itemDto.setName("TestItem");
        itemDto.setDescription("TestDescription");
        
        mockItemService.saveItem(itemDto);

        assertTrue(mockItemService.getItem(1L).isPresent());
    }

}
