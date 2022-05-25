package com.example.webshop.model.dto;

import com.example.webshop.annotation.validation.auth.StringLength;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ShopItemDto {
    @NotBlank(message = "Item name is mandatory.")
    private String name;

    @StringLength.List({
            @StringLength(min = 3, message = "Item description must be at least 3 characters long."),
            @StringLength(max = 5, message = "Item description must be less than 255 characters.")
    })
    private String description;

    @NotNull(message = "Item price is mandatory.")
    @Min(value = 1, message = "The price must be greater than 0.")
    private Integer price;
}
