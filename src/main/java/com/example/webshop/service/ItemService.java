package com.example.webshop.service;

import com.example.webshop.entity.ShopItem;

import java.util.List;

public interface ItemService {
    List<ShopItem> findAll();
    ShopItem create(ShopItem item);
}
