package com.example.webshop.service;

import com.example.webshop.entity.ShopItem;
import com.example.webshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    @Override
    public List<ShopItem> findAll(){
        return itemRepository.findAll();
    }

    @Override
    public ShopItem create(ShopItem item){
        return itemRepository.save(item);
    }
}
