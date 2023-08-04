package com.dewc.crudrestapichallenge.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

}
