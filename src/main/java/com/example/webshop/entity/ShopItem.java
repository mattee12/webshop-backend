package com.example.webshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop_item")
@Data
public class ShopItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Integer price;
}
