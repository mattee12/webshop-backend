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
    public ShopItem findById(Long id){return itemRepository.findById(id).orElse(null);}

    @Override
    public ShopItem create(ShopItem item){
        return itemRepository.save(item);
    }

    @Override
    public List<ShopItem> delete(Long id){
        itemRepository.deleteById(id);
        return itemRepository.findAll();
    }
}
