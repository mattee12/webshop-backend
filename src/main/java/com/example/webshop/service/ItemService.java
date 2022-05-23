package com.example.webshop.service;

import com.example.webshop.entity.ShopItem;

import java.util.List;

public interface ItemService {
    List<ShopItem> findAll();
    ShopItem create(ShopItem item);
    ShopItem findById(Long id);
    List<ShopItem> delete(Long id);
}
