package com.example.webshop.service;

import com.example.webshop.entity.Cart;
import com.example.webshop.entity.ShopItem;
import com.example.webshop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;
    private final ItemService itemService;

    @Override
    public Cart addItem(Cart cart, Long id){
        final List<ShopItem> items = cart.getItems();
        items.add(itemService.findById(id));
        cart.setItems(items);
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteItem(Cart cart, ShopItem item){
        final List<ShopItem> items = cart.getItems();
        final ShopItem first = items.stream()
                        .filter(elem -> elem.getId().equals(item.getId()))
                                .findFirst().orElse(null);
        items.remove(first);
        cart.setItems(items);
        return cartRepository.save(cart);
    }
}
