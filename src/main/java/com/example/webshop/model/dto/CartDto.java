package com.example.webshop.model.dto;

import com.example.webshop.entity.ShopItem;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CartDto {
    @NotBlank(message = "Cart ID is mandatory.")
    private Long id;
    private List<ShopItem> items;
}
