package com.example.webshop.util.convert;

import com.example.webshop.entity.Cart;
import com.example.webshop.model.dto.CartDto;

public class ConvertCart {
    public static Cart dtoToCart(CartDto dto){
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setItems(dto.getItems());
        return cart;
    }

    public static CartDto shopItemToDto(Cart cart){
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setItems(cart.getItems());
        return dto;
    }
}
