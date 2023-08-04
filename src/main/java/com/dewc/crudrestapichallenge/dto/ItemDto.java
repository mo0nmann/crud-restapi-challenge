package com.dewc.crudrestapichallenge.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class ItemDto {
    
    @JsonAlias("ItemId")
    private Long id;

    private String name;
    private String description;
    
}
