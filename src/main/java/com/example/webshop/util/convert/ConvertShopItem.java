package com.example.webshop.util.convert;

import com.example.webshop.entity.ShopItem;
import com.example.webshop.model.dto.ShopItemDto;

public class ConvertShopItem {
    public static ShopItem dtoToShopItem(ShopItemDto dto){
        ShopItem item = new ShopItem();
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        return item;
    }

    public static ShopItemDto shopItemToDto(ShopItem item){
        ShopItemDto dto = new ShopItemDto();
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setPrice(item.getPrice());
        return dto;
    }
}
