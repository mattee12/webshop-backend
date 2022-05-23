package com.example.webshop.service;

import com.example.webshop.entity.Cart;
import com.example.webshop.entity.ShopItem;

public interface CartService {
    Cart addItem(Cart cart, Long id);
    Cart deleteItem(Cart cart, ShopItem item);
}
