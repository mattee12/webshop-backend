package com.example.webshop.controller;

import com.example.webshop.entity.ShopItem;
import com.example.webshop.model.dto.ShopItemDto;
import com.example.webshop.service.ItemService;
import com.example.webshop.util.convert.ConvertShopItem;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ShopItem> getAll(){
        return itemService.findAll();
    }

    @PostMapping
    public ShopItem create(@Validated @RequestBody ShopItemDto item){
        return itemService.create(ConvertShopItem.dtoToShopItem(item));
    }

    @DeleteMapping("/{id}")
    public List<ShopItem> delete(@PathVariable Long id){
        return itemService.delete(id);
    }
}
