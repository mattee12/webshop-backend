package com.example.webshop.controller;

import com.example.webshop.annotation.validation.auth.RequiredRole;
import com.example.webshop.entity.ShopItem;
import com.example.webshop.model.dto.ShopItemDto;
import com.example.webshop.model.enums.Role;
import com.example.webshop.service.ItemService;
import com.example.webshop.util.convert.ConvertShopItem;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@Validated
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<ShopItem> getAll(){
        return itemService.findAll();
    }

    @PostMapping
    public ShopItem create(
            @RequestHeader("access-token") @NotBlank(message = "Token is mandatory.") @RequiredRole(role = Role.ADMIN) String token,
            @RequestBody ShopItemDto item){
        return itemService.create(ConvertShopItem.dtoToShopItem(item));
    }

    @DeleteMapping("/{id}")
    public List<ShopItem> delete(
            @RequestHeader("access-token") @NotBlank(message = "Token is mandatory.") @RequiredRole(role = Role.ADMIN) String token,
            @PathVariable @NotNull(message = "Item ID is mandatory.") Long id){
        return itemService.delete(id);
    }
}
