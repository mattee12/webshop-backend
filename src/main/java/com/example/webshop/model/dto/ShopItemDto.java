package com.example.webshop.model.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ShopItemDto {
    @NotBlank(message = "Item name is mandatory.")
    private String name;
    private String description;
    @NotNull(message = "Item price is mandatory.")
    @Min(value = 1, message = "The price must be greater than 0.")
    private Integer price;
}
